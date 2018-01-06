/*添加点赞*/
/*statefabulous_addFabulous*/
insert into state_fabulous(state_message_id, user_id, create_time)
values(@stateMessageId, @userId, @createTime)


/*查询点赞*/
/*statefabulous_queryFabulous*/
select * from state_fabulous where state_message_id = @stateMessageId order by create_time

/*取消点赞*/
/*statefabulous_deleteFabulous*/
delete from state_fabulous where state_message_id = @stateMessageId and user_id = @userId