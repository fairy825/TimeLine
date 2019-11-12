package com.timeline.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.timeline.pojo.Message;
import com.timeline.utils.MyMapper;

public interface MessageMapper extends MyMapper<Message> {
	public List<Message> queryAll();

}