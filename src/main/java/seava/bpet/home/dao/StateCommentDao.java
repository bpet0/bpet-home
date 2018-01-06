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
import seava.bpet.home.meta.StateComment;

/**
 * 消息评论的dao
 * 
 * @author water
 *
 */
@IocBean
public class StateCommentDao {

	@Inject
	private Dao dao;
	
	/**
	 * 新增评论
	 * 
	 * @param sc
	 */
	public void addStateComment(StateComment sc) {
		Sql sql = dao.sqls().create("statecomment_addComment");
		sql.params().set("content", null == sc.getContent() ? "" : sc.getContent());
		sql.params().set("stateMessageId", sc.getStateMessageId());
		sql.params().set("userId", sc.getUserId());
		sql.params().set("atUserId", sc.getAtUserId());
		sql.params().set("commentType", sc.getCommentType());
		sql.params().set("createTime", sc.getCreateTime());
		dao.execute(sql);
	}
	
	/**
	 * 根据状态消息查询评论
	 * 
	 * @param messageId
	 * @return
	 */
	public List<StateComment> queryCommentsByMessageId(long messageId) {
		Sql sql = dao.sqls().create("statecomment_queryComments");
		sql.params().set("stateMessageId", messageId);
		sql.setCallback(OwnCallbacks.objects(new StateCommentConvertor()));
		dao.execute(sql);
		return sql.getList(StateComment.class);
	}
	
	public class StateCommentConvertor implements Rs2ObjectConverter<StateComment> {

		@Override
		public StateComment invoke(ResultSet rs) throws SQLException {
			StateComment sc = new StateComment();
			sc.setAtUserId(rs.getLong("at_user_id"));
			sc.setCommentType(rs.getInt("comment_type"));
			sc.setContent(rs.getString("content"));
			sc.setCreateTime(rs.getLong("create_time"));
			sc.setId(rs.getLong("id"));
			sc.setStateMessageId(rs.getLong("state_message_id"));
			sc.setUserId(rs.getLong("user_id"));
			return sc;
		}
	}
}
