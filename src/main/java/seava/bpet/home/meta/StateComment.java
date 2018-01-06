package seava.bpet.home.meta;

/**
 * 消息评论的meta
 * 
 * @author water
 *
 */
public class StateComment {
	
	private long id;
	
	/**
	 * 评论的内容
	 */
	private String content;
	
	/**
	 * 评论的消息id
	 */
	private long stateMessageId;
	
	/**
	 * 评论用户的id
	 */
	private long userId;
	
	/**
	 * at的用户id
	 */
	private long atUserId;
	
	/**
	 * 评论类型
	 * 0评论该消息
	 * 1评论其他人的评论 at了某人
	 */
	private int commentType;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getStateMessageId() {
		return stateMessageId;
	}

	public void setStateMessageId(long stateMessageId) {
		this.stateMessageId = stateMessageId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getAtUserId() {
		return atUserId;
	}

	public void setAtUserId(long atUserId) {
		this.atUserId = atUserId;
	}

	public int getCommentType() {
		return commentType;
	}

	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
