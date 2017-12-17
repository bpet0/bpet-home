package seava.bpet.home.service;

import java.io.File;

import org.nutz.ioc.loader.annotation.IocBean;

import com.seava.image.util.FileUploadUtil;

import seava.bpet.home.constant.MessageType;

/**
 * 状态消息的服务
 * 
 * @author water
 *
 */
@IocBean
public class StateMessageService {

	
	public void addStateMessage(MessageType type, Long userId, Long petId, 
			Double longitude, Double lattitude, String address, String url) {
	}
}
