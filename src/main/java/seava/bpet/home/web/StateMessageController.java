package seava.bpet.home.web;


import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

import com.seava.image.util.FileUploadUtil;

import seava.bpet.home.constant.MessageType;
import seava.bpet.home.meta.vo.CommonResult;
import seava.bpet.home.service.StateMessageService;
import seava.bpet.home.utils.StringTool;

/**
 * 状态消息的controller
 * 
 * @author water
 *
 */
@At("backend")
@IocBean
public class StateMessageController {

	private static final String uploadUrl = "http://image.cnthrowable.com/seava/image/uploadFile";
	
	@Inject
	private StateMessageService stateMessageService;
	
	/**
	 * 发布状态
	 * 
	 * @param userId
	 * @param petId
	 * @param messageType
	 * @param longitude
	 * @param lattitude
	 * @param address
	 * @param webUrl
	 * @param url
	 * @param file
	 * @return
	 */
	@Ok("json")
	@At("/publishState")
	@AdaptBy(type=UploadAdaptor.class, args={"ioc:myUpload"})
	public Object publishState(Long userId, Long petId, Integer messageType, 
			Double longitude, Double lattitude, String address, String webUrl, @Param("media") TempFile[] files) {
		if (null == userId || null == messageType || userId < 1 || null == MessageType.getById(messageType)) {
			return CommonResult.fail("参数错误");
		}
		String mediaUrl = "";
		if (MessageType.IMAGE == MessageType.getById(messageType)
				|| MessageType.VIDEO == MessageType.getById(messageType)) {
			if (null == files || files.length == 0) {
				return CommonResult.fail("文件信息为空");
			}
			if (MessageType.VIDEO == MessageType.getById(messageType)) {
				try {
					mediaUrl = FileUploadUtil.uploadFile(uploadUrl, files[0].getFile(), "seava_bpet", "seava_bpet_home", "state_message", "xpf12", 1);
				} catch (Exception e) {
					return CommonResult.fail("视频上传失败" + e.getMessage());
				}
			} else {
				StringBuilder builder = new StringBuilder();
				for (TempFile f : files) {
					try {
						builder.append(FileUploadUtil.uploadFile(uploadUrl, f.getFile(), "seava_bpet", "seava_bpet_home", "state_message", "xpf12", 1));
					} catch (Exception e) {
						return CommonResult.fail("图片上传失败" + e.getMessage());
					}
				}
				if (builder.length() > 0) {
					builder.replace(builder.length() - 1, builder.length(), ")");
				}
				mediaUrl = builder.toString();
			}
		}
		if (MessageType.WEB == MessageType.getById(messageType)) {
			if (StringTool.isBlank(webUrl)) {
				return CommonResult.fail("url地址不能为空");
			}
			mediaUrl = webUrl;
		}
		stateMessageService.addStateMessage(MessageType.getById(messageType), userId, petId, longitude, lattitude, address, mediaUrl);
		return CommonResult.success();
	}
}
