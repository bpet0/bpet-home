package seava.bpet.home.meta.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回给页面的结果
 * @author WaterHsu
 *
 */
public class CommonResult {

	/** 成功的值 */
	public static final int success = 1;
	
	/** 失败的值 */
	public static final int fail = 0;
	
	/** 成功的标志 */
	private int msgCode;
	
	/** 失败消息 */
	private String message;
	
	/** 其他值 */
	private Map<String, Object> data;
	
	public static CommonResult success() {
		CommonResult result = new CommonResult();
		result.setMsgCode(CommonResult.success);
		return result;
	}
	
	public static CommonResult success(String key, Object value) {
		CommonResult result = success();
		result.setKeyValue(key, value);
		return result;
	}
	
	public static CommonResult success(int code, String message) {
		CommonResult result = success();
		result.setMsgCode(code);
		result.setMessage(message);
		return result;
	}
	
	public static CommonResult success(String message) {
		CommonResult result = success();
		result.setMessage(message);
		return result;
	}
	
	public static CommonResult fail() {
		CommonResult result = new CommonResult();
		result.setMsgCode(CommonResult.fail);
		return result;
	}
	
	public static CommonResult fail(int msgCode, String message) {
		CommonResult result = new CommonResult();
		result.setMsgCode(msgCode);
		result.setMessage(message);
		return result;
	}
	
	public static CommonResult fail(String message) {
		CommonResult result = fail();
		result.setMessage(message);
		return result;
	}

	public int getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(int msgCode) {
		this.msgCode = msgCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public void setKeyValue(String key, Object value) {
		if (null == this.data) {
			this.data = new HashMap<String, Object>();
		}
		this.data.put(key, value);
	}
}
