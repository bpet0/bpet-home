package seava.bpet.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import seava.bpet.home.dao.callback.Rs2ObjectConverter;
import seava.bpet.home.meta.Pet;

/**
 * pet的dao的实现
 * 
 * @author water
 *
 */
@IocBean
public class PetDao {

	@Inject
	private Dao dao;
	
	public class PetConvertor implements Rs2ObjectConverter<Pet> {

		@Override
		public Pet invoke(ResultSet rs) throws SQLException {
			Pet pet = new Pet();
			pet.setId(rs.getLong("id"));
			pet.setPetNick(rs.getString("pet_nick"));
			pet.setPetName(rs.getString("pet_name"));
			pet.setPetKind(rs.getLong("pet_kind"));
			pet.setBirthday(rs.getLong("birthday"));
			pet.setGender(rs.getInt("gender"));
			pet.setDescription(rs.getString("description"));
			pet.setOwnerId(rs.getLong("owner_id"));
			pet.setLongitude(rs.getDouble("longitude"));
			pet.setLattitude(rs.getDouble("lattitude"));
			pet.setHome(rs.getString("home"));
			pet.setHeadPartrait(rs.getString("head_partrait"));
			pet.setUpdateTime(rs.getLong("update_time"));
			pet.setCreateTime(rs.getLong("create_time"));
			return pet;
		}
		
	}
}
