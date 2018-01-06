package seava.bpet.home.meta;

/**
 * 状态消息的详情
 * 
 * @author water
 *
 */
public class StateMessageDetail {

	/**
	 * id
	 */
	private long id;
	
	/**
	 * 状态消息id
	 */
	private long messageId;
	
	/**
	 * 原始多媒体的url
	 */
	private String sourceUrl;
	
	/**
	 * 缩略图
	 */
	private String thumbnailUrl;
	
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

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
