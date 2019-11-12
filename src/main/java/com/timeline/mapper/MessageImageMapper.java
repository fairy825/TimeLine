package com.timeline.mapper;

import java.util.List;

import com.timeline.pojo.Message;
import com.timeline.pojo.MessageImage;
import com.timeline.utils.MyMapper;

public interface MessageImageMapper extends MyMapper<MessageImage> {
	public List<MessageImage> queryByMessage(Integer mid);

}