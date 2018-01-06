package seava.bpet.home.meta;

/**
 * 消息的点赞
 * 
 * @author water
 *
 */
public class StateFabulous {

	private long id;
	
	/**
	 * 评论的消息id
	 */
	private long stateMessageId;
	
	/**
	 * 评论的用户id
	 */
	private long userId;
	
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

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
