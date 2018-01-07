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
	
	/**
	 * 新增详情信息
	 * 
	 * @param detail
	 */
	public void addDetail(StateMessageDetail detail) {
		Sql sql = dao.sqls().create("statemessagedetail_addDetail");
		sql.params().set("mesageId", detail.getMessageId());
		sql.params().set("sourceUrl", null == detail.getSourceUrl() ? "" : detail.getSourceUrl());
		sql.params().set("thumbnailUrl", null == detail.getThumbnailUrl() ? "" : detail.getThumbnailUrl());
		sql.params().set("createTime", detail.getCreateTime());
		dao.execute(sql);
	}
	
	/**
	 * 查询所有的详情
	 * 
	 * @param messageId
	 * @return
	 */
	public List<StateMessageDetail> queryDetailsByMessageId(long messageId) {
		Sql sql = dao.sqls().create("statemessagedetail_queryDetailsByMessageId");
		sql.params().set("messageId", messageId);
		sql.setCallback(OwnCallbacks.objects(new StateMessageDetailConvertor()));
		dao.execute(sql);
		return sql.getList(StateMessageDetail.class);
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
