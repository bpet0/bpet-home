package seava.bpet.home.dao.callback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;


/**
 * 自己实现的rs与meta类的转换
 * @author WaterHsu
 *
 */
public class OwnCallbacks {

	public static SqlCallback object(final Rs2ObjectConverter<?> roc) {
		return new SqlCallback() {
			
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				if (null != rs && rs.next()) {
					return roc.invoke(rs);
				}
				return null;
			}
		};
	}
	
	public static SqlCallback objects(final Rs2ObjectConverter<?> roc) {
		return new SqlCallback() {
			
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Object> list = new ArrayList<Object>();
				while (rs.next()) {
					list.add(roc.invoke(rs));
				}
				return list;
			}
		};
	}
}
