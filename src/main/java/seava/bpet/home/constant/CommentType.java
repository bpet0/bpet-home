package seava.bpet.home.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 评论类型
 * 
 * @author water
 *
 */
public enum CommentType {

	FOR_MESSAGE(0, "forMessage", "评论状态消息"),
	FOR_COMMENT(1, "forComment", "评论消息的评论");
	
	private int id;
	
	private String value;
	
	private String text;
	
	private static Map<Integer, CommentType> map = new HashMap<Integer, CommentType>();
	
	static {
		map.put(FOR_MESSAGE.getId(), FOR_MESSAGE);
		map.put(FOR_COMMENT.getId(), FOR_COMMENT);
	}
	
	private CommentType(int id, String value, String text) {
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
	
	public static CommentType getById(int id) {
		return map.get(id);
	}
}
