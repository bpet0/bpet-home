package seava.bpet.home.meta;

/**
 * 通知消息
 * 
 * @author water
 *
 */
public class NoticeMessage {

	private long id;
	
	/**
	 * 通知的消息类型 0 系统消息  1评论消息  2点赞消息
	 */
	private int noticeKind;
	
	/**
	 * 状态消息的id
	 */
	private long stateMessageId;
	
	/**
	 * 相关的id 评论消息则为评论id 点赞消息为点赞id
	 */
	private long relationId;
	
	/**
	 * 发起人id
	 */
	private long fromUserId;
	
	/**
	 * 接收人id
	 */
	private long toUserId;
	
	/**
	 * 消息内容
	 */
	private String content;
	
	/**
	 * 创建时间
	 */
	private long createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNoticeKind() {
		return noticeKind;
	}

	public void setNoticeKind(int noticeKind) {
		this.noticeKind = noticeKind;
	}

	public long getStateMessageId() {
		return stateMessageId;
	}

	public void setStateMessageId(long stateMessageId) {
		this.stateMessageId = stateMessageId;
	}

	public long getRelationId() {
		return relationId;
	}

	public void setRelationId(long relationId) {
		this.relationId = relationId;
	}

	public long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public long getToUserId() {
		return toUserId;
	}

	public void setToUserId(long toUserId) {
		this.toUserId = toUserId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
