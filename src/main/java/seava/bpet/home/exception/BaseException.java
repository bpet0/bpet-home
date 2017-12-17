package seava.bpet.home.exception;

/**
 * 自定义异常
 * @author WaterHsu
 *
 */
public class BaseException extends Exception {
	
	private static final long serialVersionUID = -2203517814756569826L;

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable e, String message) {
		super(message, e);
	}
	
	public BaseException() {
		super();
	}
}
