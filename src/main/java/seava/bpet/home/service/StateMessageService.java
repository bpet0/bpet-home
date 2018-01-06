package seava.bpet.home.service;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import seava.bpet.home.constant.MessageType;
import seava.bpet.home.dao.StateMessageDao;
import seava.bpet.home.dao.StateMessageDetailDao;
import seava.bpet.home.meta.StateMessage;
import seava.bpet.home.meta.StateMessageDetail;

/**
 * 状态消息的服务
 * 
 * @author water
 *
 */
@IocBean
public class StateMessageService {

	@Inject
	private StateMessageDao stateMessageDao;
	
	@Inject
	private StateMessageDetailDao stateMessageDetailDao;
	
	/**
	 * 新增状态消息
	 * 
	 * @param type
	 * @param userId
	 * @param petId
	 * @param longitude
	 * @param lattitude
	 * @param address
	 * @param mediaUrl
	 * @param details
	 * @return
	 */
	public void addStateMessage(MessageType type, String content, Long userId, Long petId, 
			Double longitude, Double lattitude, String address, String mediaUrl, final List<StateMessageDetail> details) {
		final StateMessage sm = new StateMessage();
		sm.setAddress(address);
		sm.setContent(content);
		sm.setKind(type.getId());
		sm.setLattitude(lattitude);
		sm.setLongitude(longitude);
		sm.setOwnerId(userId);
		sm.setPetId(petId);
		sm.setUrl(mediaUrl);
		long time = System.currentTimeMillis();
		sm.setCreateTime(time);
		for (StateMessageDetail d : details) {
			d.setCreateTime(time);
		}
		Trans.exec(new Atom() {

			@Override
			public void run() {
				stateMessageDao.addStateMessage(sm);
				long id = stateMessageDao.queryId(sm);
				sm.setId(id);
				for (StateMessageDetail d : details) {
					d.setMessageId(id);
					stateMessageDetailDao.addDetail(d);
				}
			}
		});
	}
}
