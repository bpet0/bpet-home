package seava.bpet.home.vo;

import java.util.ArrayList;
import java.util.List;

import seava.bpet.home.meta.StateComment;
import seava.bpet.home.meta.StateFabulous;
import seava.bpet.home.meta.StateMessage;
import seava.bpet.home.meta.StateMessageDetail;
import seava.bpet.home.utils.StringTool;


/**
 * 状态消息的vo
 * 
 * @author water
 *
 */
public class StateMessageVo {

	/**
	 * 消息id
	 */
	private long messageId;
	
	/**
	 * 文字信息
	 */
	private String content; 
	
	/**
	 * 状态信息类别 0纯文字 1图片 2视频 3分享的url
	 */
	private int kind;
	
	/**
	 * 状态信息所属用户id
	 */
	private long userId;
	
	/**
	 * 用户昵称
	 */
	private String userNickName;
	
	/**
	 * 状态信息所属宠物id 可以为空
	 */
	private long petId;
	
	/**
	 * 发状态时所处经度
	 */
	private double longitude;
	
	/**
	 * 发状态时所处纬度
	 */
	private double lattitude;
	
	/**
	 * 发状态时所处地址
	 */
	private String address;
	
	/**
	 * 创建时间
	 */
	private long createTime;
	
	/**
	 * 媒体信息
	 */
	private List<StateMessageDetailVo> medias;
	
	/**
	 * 评论
	 */
	private List<StateCommentVo> comments;
	
	/**
	 * 点赞
	 */
	private List<StateFabulousVo> fabulous;

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public long getPetId() {
		return petId;
	}

	public void setPetId(long petId) {
		this.petId = petId;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLattitude() {
		return lattitude;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public List<StateMessageDetailVo> getMedias() {
		return medias;
	}

	public void setMedias(List<StateMessageDetailVo> medias) {
		this.medias = medias;
	}

	public List<StateCommentVo> getComments() {
		return comments;
	}

	public void setComments(List<StateCommentVo> comments) {
		this.comments = comments;
	}

	public List<StateFabulousVo> getFabulous() {
		return fabulous;
	}

	public void setFabulous(List<StateFabulousVo> fabulous) {
		this.fabulous = fabulous;
	}
	
	public static StateMessageVo getVo(StateMessage sm) {
		StateMessageVo vo = new StateMessageVo();
		vo.setAddress(sm.getAddress());
		vo.setContent(sm.getContent());
		vo.setCreateTime(sm.getCreateTime());
		vo.setKind(sm.getKind());
		vo.setLattitude(sm.getLattitude());
		vo.setLongitude(sm.getLongitude());
		vo.setMessageId(sm.getId());
		vo.setPetId(sm.getPetId());
		vo.setUserId(sm.getOwnerId());
		vo.setUserNickName(sm.getUserNickName());
		if (StringTool.isNotEmpty(sm.getMediaDetail())) {
			List<StateMessageDetailVo> detailVoList = new ArrayList<StateMessageDetailVo>();
			for (StateMessageDetail d : sm.getMediaDetail()) {
				StateMessageDetailVo dtVo = new StateMessageDetailVo();
				dtVo.setSourceUrl(d.getSourceUrl());
				dtVo.setThumbnailUrl(d.getThumbnailUrl());
				detailVoList.add(dtVo);
			}
			vo.setMedias(detailVoList);
		}
		if (StringTool.isNotEmpty(sm.getStateComments())) {
			List<StateCommentVo> commentVoList = new ArrayList<StateCommentVo>();
			for (StateComment sc : sm.getStateComments()) {
				StateCommentVo scVo = new StateCommentVo();
				scVo.setAtUserId(sc.getAtUserId());
				scVo.setAtUserNickName(sc.getAtUserNickName());
				scVo.setContent(sc.getContent());
				scVo.setStateMessageId(sc.getStateMessageId());
				scVo.setUserId(sc.getUserId());
				scVo.setUserNickName(sc.getUserNickName());
				commentVoList.add(scVo);
			}
			vo.setComments(commentVoList);
		}
		if (StringTool.isNotEmpty(sm.getStateFabulous())) {
			List<StateFabulousVo> sfVoList = new ArrayList<StateFabulousVo>();
			for (StateFabulous sf : sm.getStateFabulous()) {
				StateFabulousVo sfVo = new StateFabulousVo();
				sfVo.setStateMessageId(sf.getStateMessageId());
				sfVo.setUserId(sf.getUserId());
				sfVo.setUserNickName(sf.getUserNickName());
				sfVoList.add(sfVo);
			}
			vo.setFabulous(sfVoList);
		}
		return vo;
	}
}
