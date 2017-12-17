package seava.bpet.home.dao.callback;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 将rs转成object
 * @author WaterHsu
 *
 */
public interface Rs2ObjectConverter<T> {

	public T invoke(ResultSet rs) throws SQLException;
}
