package seava.bpet.home.service;

import java.util.List;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.trans.Atom;
import org.nutz.trans.Trans;

import seava.bpet.home.constant.CommentType;
import seava.bpet.home.constant.MessageType;
import seava.bpet.home.dao.StateCommentDao;
import seava.bpet.home.dao.StateFabulousDao;
import seava.bpet.home.dao.StateMessageDao;
import seava.bpet.home.dao.StateMessageDetailDao;
import seava.bpet.home.meta.StateComment;
import seava.bpet.home.meta.StateFabulous;
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
	
	@Inject
	private StateCommentDao stateCommentDao;
	
	@Inject
	private StateFabulousDao stateFabulousDao;
	
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
	
	/**
	 * 新增评论
	 * 
	 * @param userId
	 * @param messageId
	 * @param atUserId
	 * @param content
	 */
	public void addComment(long userId, long messageId, long atUserId, String content) {
		StateComment sc = new StateComment();
		sc.setAtUserId(atUserId);
		sc.setContent(content);
		sc.setStateMessageId(messageId);
		sc.setUserId(userId);
		sc.setCreateTime(System.currentTimeMillis());
		sc.setCommentType(atUserId == 0 ? CommentType.FOR_MESSAGE.getId() : CommentType.FOR_COMMENT.getId());
		stateCommentDao.addStateComment(sc);
	}
	
	/**
	 * 新增点赞
	 * 
	 * @param userId
	 * @param messageId
	 */
	public void addFabulous(long userId, long messageId) {
		StateFabulous sf = new StateFabulous();
		sf.setCreateTime(System.currentTimeMillis());
		sf.setStateMessageId(messageId);
		sf.setUserId(userId);
		stateFabulousDao.addFabulous(sf);
	}
	
	/**
	 * 取消点赞
	 * 
	 * @param userId
	 * @param messageId
	 */
	public void deleteFabulous(long userId, long messageId) {
		stateFabulousDao.deleteFabulousByMessageAndUser(messageId, userId);
	}
	
	public List<StateMessage> queryAllStateMessages() {
		
	}
	
	private void fillAll(List<StateMessage> smList) {
		for (StateMessage sm : smList) {
			fillAll(sm);
		}
	}
	
	/**
	 * 填充所有的信息
	 * 
	 * @param sm
	 */
	private void fillAll(StateMessage sm) {
		fillDetails(sm);
		fillComments(sm);
		fillFabulous(sm);
	}
	
	/**
	 * 填充评论
	 * 
	 * @param sm
	 */
	private void fillComments(StateMessage sm) {
		List<StateComment> comments = stateCommentDao.queryCommentsByMessageId(sm.getId());
		sm.setStateComments(comments);
	}
	
	/**
	 * 填充点赞
	 * 
	 * @param sm
	 */
	private void fillFabulous(StateMessage sm) {
		List<StateFabulous> fabulous = stateFabulousDao.queryFabulousByMessage(sm.getId());
		sm.setStateFabulous(fabulous);
	}
	
	/**
	 * 填充详情
	 * 
	 * @param sm
	 */
	private void fillDetails(StateMessage sm) {
		List<StateMessageDetail> detailList = stateMessageDetailDao.queryDetailsByMessageId(sm.getId());
		sm.setMediaDetail(detailList);
	}
}
