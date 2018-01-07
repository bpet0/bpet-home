package seava.bpet.home.vo;

/**
 * 点赞的vo
 * 
 * @author water
 *
 */
public class StateFabulousVo {

	/**
	 * 评论的消息id
	 */
	private long stateMessageId;
	
	/**
	 * 评论的用户id
	 */
	private long userId;
	
	/**
	 * 用户昵称
	 */
	private String userNickName;

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

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
}
