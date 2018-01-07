package seava.bpet.home.vo;

/**
 * 状态消息详情的vo
 * 
 * @author water
 *
 */
public class StateMessageDetailVo {

	/**
	 * 原始媒体的url
	 */
	private String sourceUrl;
	
	/**
	 * 缩略媒体的url
	 */
	private String thumbnailUrl;

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
}
