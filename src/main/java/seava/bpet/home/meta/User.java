package seava.bpet.home.meta;

/**
 * 用户信息
 * 
 * @author water
 *
 */
public class User {

	private long id;
	
	/**
	 * 昵称
	 */
	private String nickName;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 电话号码
	 */
	private String phoneNum;
	
	/**
	 * 邮件
	 */
	private String email;
	
	/**
	 * 密码 md5加密
	 */
	private String password;
	
	/**
	 * 性别 0男 1女
	 */
	private int gender;
	
	/**
	 * 生日
	 */
	private long birthday;
	
	/**
	 * 注册时经度
	 */
	private double longitude;
	
	/**
	 * 注册时纬度
	 */
	private double lattitude;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 默认宠物
	 */
	private long defaultPet;
	
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public long getBirthday() {
		return birthday;
	}

	public void setBirthday(long birthday) {
		this.birthday = birthday;
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

	public long getDefaultPet() {
		return defaultPet;
	}

	public void setDefaultPet(long defaultPet) {
		this.defaultPet = defaultPet;
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
