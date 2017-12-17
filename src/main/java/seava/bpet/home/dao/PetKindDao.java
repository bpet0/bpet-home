package seava.bpet.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import seava.bpet.home.dao.callback.Rs2ObjectConverter;
import seava.bpet.home.meta.PetKind;

/**
 * 宠物类型的dao的实现
 * 
 * @author water
 *
 */
@IocBean
public class PetKindDao {

	@Inject
	private Dao dao;
	
	public class PetKindConvertor implements Rs2ObjectConverter<PetKind> {

		@Override
		public PetKind invoke(ResultSet rs) throws SQLException {
			PetKind pk = new PetKind();
			pk.setId(rs.getLong("id"));
			pk.setKindName(rs.getString("kind_name"));
			pk.setCreateTime(rs.getLong("create_time"));
			return pk;
		}
		
	}
}
