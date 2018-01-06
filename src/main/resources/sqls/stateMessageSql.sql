/*添加状态消息*/
/*statemessage_addMessage*/
insert into state_message(content, url, kind, owner_id, pet_id, longitude, lattitude, address, create_time)
values(@content, @url, @kind, @ownerId, @petId, @longitude, @lattitude, @address, @createTime)


/*添加状态消息*/
/*statemessage_queryId*/
select id from state_message where owner_id = @ownerId and pet_id = @petId
and longitude = @longitude and lattitude = @lattitude and kind = @kind
and create_time = @createTime and content = @content

/*根据id查询消息*/
/*statemessage_queryMessageById*/
select * from state_message where id = @id

