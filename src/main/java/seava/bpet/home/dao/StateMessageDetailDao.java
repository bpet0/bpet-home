package seava.bpet.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.nutz.dao.Dao;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import seava.bpet.home.dao.callback.Rs2ObjectConverter;
import seava.bpet.home.meta.StateMessageDetail;

/**
 * 状态消息的多媒体详情的dao
 * 
 * @author water
 *
 */
@IocBean
public class StateMessageDetailDao {

	@Inject
	private Dao dao;
	
	public void addDetail(StateMessageDetail detail) {
		Sql sql = dao.sqls().create("statemessagedetail_addDetail");
		sql.params().set("mesageId", detail.getMessageId());
		sql.params().set("sourceUrl", null == detail.getSourceUrl() ? "" : detail.getSourceUrl());
		sql.params().set("thumbnailUrl", null == detail.getThumbnailUrl() ? "" : detail.getThumbnailUrl());
		sql.params().set("createTime", detail.getCreateTime());
		dao.execute(sql);
	}
	
	public class StateMessageDetailConvertor implements Rs2ObjectConverter<StateMessageDetail> {

		@Override
		public StateMessageDetail invoke(ResultSet rs) throws SQLException {
			StateMessageDetail d = new StateMessageDetail();
			d.setId(rs.getLong("id"));
			d.setMessageId(rs.getLong("message_id"));
			d.setSourceUrl(rs.getString("source_url"));
			d.setThumbnailUrl(rs.getString("thumbnail_url"));
			d.setCreateTime(rs.getLong("create_time"));
			return d;
		}
	}
}
