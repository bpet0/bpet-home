package seava.bpet.home.meta;

/**
 * 宠物类型
 * 
 * @author water
 *
 */
public class PetKind {

	private long id;
	
	/**
	 * 类型名称
	 */
	private String kindName;
	
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

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
}
