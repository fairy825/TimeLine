package com.timeline.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.timeline.mapper.MessageImageMapper;
import com.timeline.mapper.MessageMapper;
import com.timeline.pojo.Message;
import com.timeline.pojo.MessageImage;
import com.timeline.utils.PagedResult;
@Service
public class MessageService {
	@Autowired
	MessageMapper messageMapper;
	@Autowired
	MessageImageMapper messageImageMapper;
	
	@Transactional(propagation= Propagation.SUPPORTS)
	public PagedResult getAllMessages(Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<Message> list = messageMapper.queryAll();
		for(Message message:list) {
			List<MessageImage> messageImages = messageImageMapper.queryByMessage(message.getId());
			message.setMessageImages(messageImages);
		}
		PageInfo<Message> pageList = new PageInfo<>(list);
		
		PagedResult pagedResult = new PagedResult();
		pagedResult.setPage(page);
		pagedResult.setTotal(pageList.getPages());
		pagedResult.setRows(list);
		pagedResult.setRecords(pageList.getTotal());
		
		return pagedResult;
	}
}
