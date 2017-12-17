package seava.bpet.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import seava.bpet.home.dao.callback.Rs2ObjectConverter;
import seava.bpet.home.meta.User;

/**
 * 用户dao的实现
 * 
 * @author water
 *
 */
@IocBean
public class UserDao {
	
	@Inject
	private Dao dao;

	public class UserConvertor implements Rs2ObjectConverter<User> {

		@Override
		public User invoke(ResultSet rs) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setNickName(rs.getString("nick_name"));
			user.setUserName(rs.getString("user_name"));
			user.setPhoneNum(rs.getString("phone_num"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setGender(rs.getInt("gender"));
			user.setBirthday(rs.getLong("birthday"));
			user.setLongitude(rs.getDouble("longitude"));
			user.setLattitude(rs.getDouble("lattitude"));
			user.setAddress(rs.getString("address"));
			user.setDefaultPet(rs.getLong("default_pet"));
			user.setHeadPartrait(rs.getString("head_partrait"));
			user.setUpdateTime(rs.getLong("update_time"));
			user.setCreateTime(rs.getLong("create_time"));
			return user;
		}
		
	}
}
