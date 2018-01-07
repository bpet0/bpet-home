package seava.bpet.home.web;


import java.util.ArrayList;
import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;


import seava.bpet.home.constant.MessageType;
import seava.bpet.home.dao.StateMessageDao;
import seava.bpet.home.meta.StateMessage;
import seava.bpet.home.meta.StateMessageDetail;
import seava.bpet.home.service.MediaUploadService;
import seava.bpet.home.service.MediaUploadService.ResultV;
import seava.bpet.home.service.StateMessageService;
import seava.bpet.home.utils.StringTool;
import seava.bpet.home.vo.CommonResult;

/**
 * 状态消息的controller
 * 
 * @author water
 *
 */
@At("backend")
@IocBean
public class StateMessageController {

	private static Log log = Logs.getLog(StateMessageController.class);
	
	@Inject
	private StateMessageService stateMessageService;
	
	@Inject
	private MediaUploadService mediaUploadService;
	
	@Inject
	private StateMessageDao stateMessageDao;
	
	/**
	 * 发布状态
	 * 
	 * @param userId         用户id
	 * @param petId          宠物id
	 * @param messageType    消息类型 	0纯文字  1图片加文字  2视频加文字  3分享网站
	 * @param longitude      经度
	 * @param lattitude      纬度
	 * @param address        地址信息
	 * @param webUrl         网址url
	 * @param files          多个文件  图片允许多个  视频和网站只允许一个
	 * @return
	 */
	@Ok("json")
	@At("/publishState")
	@AdaptBy(type=UploadAdaptor.class, args={"ioc:myUpload"})
	public Object publishState(Long userId, String content, Long petId, Integer messageType, 
			Double longitude, Double lattitude, String address, String webUrl, @Param("media") TempFile[] files) {
		if (null == userId || null == messageType || userId < 1 || null == MessageType.getById(messageType)) {
			return CommonResult.fail("参数错误");
		}
		// 如果是分享网页 网页url不能为空
		String mediaUrl = "";
		if (MessageType.WEB == MessageType.getById(messageType)) {
			if (StringTool.isBlank(webUrl)) {
				return CommonResult.fail("url地址不能为空");
			}
			mediaUrl = webUrl;
		}
		if (MessageType.WORD == MessageType.getById(messageType)) {
			if (StringTool.isBlank(content)) {
				return CommonResult.fail("文字内容不能为空");
			}
		}
		List<StateMessageDetail> detailList = new ArrayList<StateMessageDetail>();
		if (MessageType.IMAGE == MessageType.getById(messageType)
				|| MessageType.VIDEO == MessageType.getById(messageType)) {
			if (null == files || files.length == 0) {
				return CommonResult.fail("文件信息为空");
			}
			if (MessageType.VIDEO == MessageType.getById(messageType)) {
				ResultV rv = mediaUploadService.uploadMedia(files[0].getFile(), 2, 100, 200);
				if (null == rv) {
					return CommonResult.fail("视频上传失败");
				}
				StateMessageDetail d = new StateMessageDetail();
				d.setSourceUrl(rv.getSourceUrl());
				d.setThumbnailUrl(rv.getThumbnailUrl());
				detailList.add(d);
				mediaUrl = rv.getSourceUrl();
			} else {
				StringBuilder builder = new StringBuilder();
				for (TempFile f : files) {
					ResultV rv = mediaUploadService.uploadMedia(f.getFile(), 1, 100, 200);
					if (null == rv) {
						return CommonResult.fail("图片上传失败");
					}
					StateMessageDetail d = new StateMessageDetail();
					d.setSourceUrl(rv.getSourceUrl());
					d.setThumbnailUrl(rv.getThumbnailUrl());
					detailList.add(d);
					builder.append(rv.getSourceUrl()).append(";");
				}
				if (builder.length() > 0) {
					builder.replace(builder.length() - 1, builder.length(), "");
					mediaUrl = builder.toString();
				}
			}
		}
		try {
			stateMessageService.addStateMessage(MessageType.getById(messageType), 
					content, userId, petId, longitude, lattitude, address, mediaUrl, detailList);
			return CommonResult.success();
		} catch (Exception e) {
			log.error("新增发布消息失败 user[" + userId + "]", e);
			return CommonResult.fail("保存消息失败");
		}
	}
	
	/**
	 * 新增评论
	 * 
	 * @param messageId
	 * @param userId
	 * @param atUserId
	 * @param content
	 * @return
	 */
	@Ok("json")
	@At("/addComment")
	public Object addComment(Long messageId, Long userId, Long atUserId, String content) {
		if (null == messageId || messageId < 1 || null == userId || userId > 1 || StringTool.isBlank(content)) {
			return CommonResult.fail("参数错误");
		}
		StateMessage sm = stateMessageDao.queryById(messageId.longValue());
		if (null == sm) {
			log.error("message[" + messageId + "] user[" + userId + "] 评论 消息不存在");
			return CommonResult.fail("消息不存在");
		}
		try {
			stateMessageService.addComment(userId, messageId, null == atUserId ? 0 : atUserId, content);
			return CommonResult.success();
		} catch (Exception e) {
			log.error("message[" + messageId + "] user[" + userId + "] content[" + content + "]保存消息出错", e);
			return CommonResult.fail("新增评论失败");
		}
	}
	
	/**
	 * 点赞
	 * 
	 * @param messageId
	 * @param userId
	 * @return
	 */
	@Ok("json")
	@At("/addFabulous")
	public Object addFabulous(Long messageId, Long userId) {
		if (null == messageId || messageId < 1 || null == userId || userId > 1) {
			return CommonResult.fail("参数错误");
		}
		StateMessage sm = stateMessageDao.queryById(messageId.longValue());
		if (null == sm) {
			log.error("message[" + messageId + "] user[" + userId + "] 点赞 消息不存在");
			return CommonResult.fail("消息不存在");
		}
		try {
			stateMessageService.addFabulous(userId, messageId);
			return CommonResult.success();
		} catch (Exception e) {
			log.error("message[" + messageId + "] user[" + userId + "] 点赞失败", e);
			return CommonResult.fail("点赞失败");
		}
	}
	
	/**
	 * 取消点赞
	 * 
	 * @param messageId
	 * @param userId
	 * @return
	 */
	@Ok("json")
	@At("/cancelFabulous")
	public Object cancelFabulous(Long messageId, Long userId) {
		if (null == messageId || messageId < 1 || null == userId || userId > 1) {
			return CommonResult.fail("参数错误");
		}
		StateMessage sm = stateMessageDao.queryById(messageId.longValue());
		if (null == sm) {
			log.error("message[" + messageId + "] user[" + userId + "] 取消点赞 消息不存在");
			return CommonResult.fail("消息不存在");
		}
		try {
			stateMessageService.deleteFabulous(userId, messageId);
			return CommonResult.success();
		} catch (Exception e) {
			log.error("message[" + messageId + "] user[" + userId + "] 取消点赞失败", e);
			return CommonResult.fail("取消点赞失败");
		}
	}
	
	/**
	 * 查询所有的状态消息
	 * 
	 * @return
	 */
	@Ok("json")
	@At("/queryAllStateMessages")
	public Object queryAllStateMessages() {
		
	}
}
