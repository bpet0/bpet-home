/*添加评论*/
/*statecomment_addComment*/
insert into state_comment(content, state_message_id, user_id, at_user_id, comment_type, create_time)
values(@content, @stateMessageId, @userId, @atUserId, @commentType, @createTime)


/*添加状态消息*/
/*statecomment_queryComments*/
select * from state_comment where state_message_id = @stateMessageId order by create_time