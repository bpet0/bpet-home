package seava.bpet.home.vo;

/**
 * 状态消息的评论
 * 
 * @author water
 *
 */
public class StateCommentVo {

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
	 * 用户昵称
	 */
	private String userNickName;
	
	/**
	 * at用户的昵称
	 */
	private String atUserNickName;

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

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getAtUserNickName() {
		return atUserNickName;
	}

	public void setAtUserNickName(String atUserNickName) {
		this.atUserNickName = atUserNickName;
	}
}
