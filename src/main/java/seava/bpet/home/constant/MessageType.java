package seava.bpet.home.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息类型
 * 
 * @author water
 *
 */
public enum MessageType {

	WORD(0, "word", "文字类型"),
	IMAGE(1, "image", "图片类型"),
	VIDEO(2, "video", "视频类型"),
	WEB(3, "web", "分享网站");
	
	private int id;
	
	private String value;
	
	private String text;
	
	private static Map<Integer, MessageType> map = new HashMap<Integer, MessageType>();
	
	static {
		map.put(WORD.getId(), WORD);
		map.put(IMAGE.getId(), IMAGE);
		map.put(VIDEO.getId(), VIDEO);
	}
	
	private MessageType(int id, String value, String text) {
		this.id = id;
		this.value = value;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public String getText() {
		return text;
	}
	
	public static MessageType getById(int id) {
		return map.get(id);
	}
}
