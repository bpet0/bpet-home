package seava.bpet.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import seava.bpet.home.dao.callback.Rs2ObjectConverter;
import seava.bpet.home.meta.StateMessage;

/**
 * 状态消息的dao
 * 
 * @author water
 *
 */
@IocBean
public class StateMessageDao {

	@Inject
	private Dao dao;
	
	public class StateMessageConvertor implements Rs2ObjectConverter<StateMessage> {

		@Override
		public StateMessage invoke(ResultSet rs) throws SQLException {
			StateMessage sm = new StateMessage();
			sm.setId(rs.getLong("id"));
			sm.setContent(rs.getString("content"));
			sm.setUrl(rs.getString("url"));
			sm.setKind(rs.getInt("kind"));
			sm.setOwnerId(rs.getLong("owner_id"));
			sm.setPetId(rs.getLong("pet_id"));
			sm.setLongitude(rs.getDouble("longitude"));
			sm.setLattitude(rs.getDouble("lattitude"));
			sm.setAddress(rs.getString("address"));
			sm.setCreateTime(rs.getLong("create_time"));
			return sm;
		}
	}
}
