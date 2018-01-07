/*添加状态消息多媒体详情*/
/*statemessagedetail_addDetail*/
insert into state_message_detail(message_id, source_url, thumbnail_url, create_time)
values(@mesageId, @sourceUrl, @thumbnailUrl, @createTime)

/*根据状态消息id查询多媒体详情*/
/*statemessagedetail_queryDetailsByMessageId*/
select * from state_message_detail where message_id = @messageId order by id


/*根据状态消息id删除多媒体详情*/
/*statemessagedetail_deleteByMessageId*/
delete state_message_detail where message_id = @messageId

/*根据状态消息id查询多媒体详情*/
/*statemessagedetail_queryDetailsByMessageId*/
select * from state_message_detail where message_id = @messageId
