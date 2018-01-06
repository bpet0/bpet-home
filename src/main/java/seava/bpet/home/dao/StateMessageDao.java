package seava.bpet.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import seava.bpet.home.dao.callback.OwnCallbacks;
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
	
	/**
	 * 新增状态消息
	 * 
	 * @param sm
	 */
	public void addStateMessage(StateMessage sm) {
		Sql sql = dao.sqls().create("statemessage_addMessage");
		sql.params().set("content", null == sm.getContent() ? "" : sm.getContent());
		sql.params().set("url", null == sm.getUrl() ? "" : sm.getUrl());
		sql.params().set("kind", sm.getKind());
		sql.params().set("ownerId", sm.getOwnerId());
		sql.params().set("petId", sm.getPetId());
		sql.params().set("longitude", sm.getLongitude());
		sql.params().set("lattitude", sm.getLattitude());
		sql.params().set("address", null == sm.getAddress() ? "" : sm.getAddress());
		sql.params().set("createTime", sm.getCreateTime());
		dao.execute(sql);
	} 
	
	/**
	 * 查询id
	 * 
	 * @param sm
	 * @return
	 */
	public Long queryId(StateMessage sm) {
		Sql sql = dao.sqls().create("statemessage_queryId");
		sql.params().set("content", sm.getContent());
		sql.params().set("kind", sm.getKind());
		sql.params().set("ownerId", sm.getOwnerId());
		sql.params().set("petId", sm.getPetId());
		sql.params().set("longitude", sm.getLongitude());
		sql.params().set("lattitude", sm.getLattitude());
		sql.params().set("createTime", sm.getCreateTime());
		sql.setCallback(Sqls.callback.longValue());
		dao.execute(sql);
		return sql.getObject(Long.class);
	}
	
	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public StateMessage queryById(long id) {
		Sql sql = dao.sqls().create("statemessage_queryMessageById");
		sql.params().set("id", id);
		sql.setCallback(OwnCallbacks.object(new StateMessageConvertor()));
		dao.execute(sql);
		return sql.getObject(StateMessage.class);
	}
	
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
