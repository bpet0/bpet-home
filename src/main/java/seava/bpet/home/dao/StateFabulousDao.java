package seava.bpet.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import seava.bpet.home.dao.callback.OwnCallbacks;
import seava.bpet.home.dao.callback.Rs2ObjectConverter;
import seava.bpet.home.meta.StateFabulous;

/**
 * 消息的点赞的dao
 * 
 * @author water
 *
 */
@IocBean
public class StateFabulousDao {

	@Inject
	private Dao dao;
	
	/**
	 * 新增点赞
	 * 
	 * @param sf
	 */
	public void addFabulous(StateFabulous sf) {
		Sql sql = dao.sqls().create("statefabulous_addFabulous");
		sql.params().set("stateMessageId", sf.getStateMessageId());
		sql.params().set("userId", sf.getUserId());
		sql.params().set("createTime", sf.getCreateTime());
		dao.execute(sql);
	}
	
	/**
	 * 根据消息id查询所有点赞
	 * 
	 * @param messageId
	 * @return
	 */
	public List<StateFabulous> queryFabulousByMessage(long messageId) {
		Sql sql = dao.sqls().create("statefabulous_queryFabulous");
		sql.params().set("stateMessageId", messageId);
		sql.setCallback(OwnCallbacks.objects(new StateFabulousConvertor()));
		dao.execute(sql);
		return sql.getList(StateFabulous.class);
	}
	
	/**
	 * 删除点赞
	 * 
	 * @param messageId
	 * @param userId
	 */
	public void deleteFabulousByMessageAndUser(long messageId, long userId) {
		Sql sql = dao.sqls().create("statefabulous_deleteFabulous");
		sql.params().set("stateMessageId", messageId);
		sql.params().set("userId", userId);
		dao.execute(sql);
	}
	
	public class StateFabulousConvertor implements Rs2ObjectConverter<StateFabulous> {

		@Override
		public StateFabulous invoke(ResultSet rs) throws SQLException {
			StateFabulous sf = new StateFabulous();
			sf.setCreateTime(rs.getLong("create_time"));
			sf.setId(rs.getLong("id"));
			sf.setStateMessageId(rs.getLong("state_message_id"));
			sf.setUserId(rs.getLong("user_id"));
			return sf;
		}
	}
}
