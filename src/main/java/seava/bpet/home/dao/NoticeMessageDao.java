package seava.bpet.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import seava.bpet.home.dao.callback.Rs2ObjectConverter;
import seava.bpet.home.meta.NoticeMessage;

/**
 * 消息dao的实现
 * 
 * @author water
 *
 */
@IocBean
public class NoticeMessageDao {

	@Inject
	private Dao dao;
	
	public class NoticeMesageConvertor implements Rs2ObjectConverter<NoticeMessage> {

		@Override
		public NoticeMessage invoke(ResultSet rs) throws SQLException {
			NoticeMessage nm = new NoticeMessage();
			nm.setId(rs.getLong("id"));
			nm.setNoticeKind(rs.getInt("notice_kind"));
			nm.setStateMessageId(rs.getLong("state_message_id"));
			nm.setRelationId(rs.getLong("relation_id"));
			nm.setFromUserId(rs.getLong("from_user_id"));
			nm.setToUserId(rs.getLong("to_user_id"));
			nm.setContent(rs.getString("content"));
			nm.setCreateTime(rs.getLong("create_time"));
			return nm;
		}
		
	}
}
