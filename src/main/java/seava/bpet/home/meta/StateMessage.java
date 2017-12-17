package seava.bpet.home.meta;

/**
 * 状态消息meta
 * 
 * @author water
 *
 */
public class StateMessage {

	/**
	 * id
	 */
	private long id;
	
	/**
	 * 文字信息
	 */
	private String content;
	
	/**
	 * 图片/视频/分享的url地址 图片多张 多个url的逗号拼接串
	 */
	private String url;
	
	/**
	 * 状态信息类别 0纯文字 1图片 2视频 3分享的url
	 */
	private int kind;
	
	/**
	 * 状态信息所属用户id
	 */
	private long ownerId;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
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
}
