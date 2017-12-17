package seava.bpet.home.meta;

/**
 * 宠物信息
 * 
 * @author water
 *
 */
public class Pet {

	private long id;
	
	/**
	 * 宠物昵称
	 */
	private String petNick;
	
	/**
	 * 宠物名称
	 */
	private String petName;
	
	/**
	 * 宠物类型
	 */
	private long petKind;
	
	/**
	 * 生日
	 */
	private long birthday;
	
	/**
	 * 性别 0公  1母
	 */
	private int gender;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 用户id
	 */
	private long ownerId;
	
	/**
	 * 经度
	 */
	private double longitude;
	
	/**
	 * 纬度
	 */
	private double lattitude;
	
	/**
	 * 家 地址
	 */
	private String home;
	
	/**
	 * 头像
	 */
	private String headPartrait;
	
	/**
	 * 更新时间
	 */
	private long updateTime;
	
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

	public String getPetNick() {
		return petNick;
	}

	public void setPetNick(String petNick) {
		this.petNick = petNick;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public long getPetKind() {
		return petKind;
	}

	public void setPetKind(long petKind) {
		this.petKind = petKind;
	}

	public long getBirthday() {
		return birthday;
	}

	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
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

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getHeadPartrait() {
		return headPartrait;
	}

	public void setHeadPartrait(String headPartrait) {
		this.headPartrait = headPartrait;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
