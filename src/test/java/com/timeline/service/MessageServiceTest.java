/**
 * Junit4 OK
 */
package com.timeline.service;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.timeline.Application;
import com.timeline.mapper.MessageImageMapper;
import com.timeline.mapper.MessageMapper;
import com.timeline.pojo.Message;
import com.timeline.pojo.MessageImage;
import com.timeline.service.MessageService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MessageServiceTest {
	@MockBean
	private MessageMapper messageMapper;
	@MockBean
	private MessageImageMapper messageImageMapper;
	@Autowired
	private MessageService messageService;
	private Message message;

	@Before
	public void setup() throws Exception {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		message = new Message.MessageBuilder().author("Tom").content("Hello")
				.createTime(format.parse("2019-11-11 11:00:00")).build();
		message.setId(1);
	}

	@Test 
	public void should_get_all_messages() throws Exception {
		List<Message> list = new ArrayList<Message>();
		list.add(message);
		System.out.print(message.getContent());
		when(messageMapper.queryAll()).thenReturn(list);
		messageService.getAllMessages(1, 3);
		verify(messageMapper, times(1)).queryAll();
		ArgumentCaptor<Integer> intArgCaptor = ArgumentCaptor.forClass(Integer.class);
		verify(messageImageMapper, times(1)).queryByMessage(intArgCaptor.capture());
		
		assertEquals(Integer.valueOf(message.getId()), intArgCaptor.getValue());
	}
}

//package com.timeline.service;
//
//import java.net.URI;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mockito;
//import org.mockito.internal.verification.Times;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//import com.timeline.Application;
//import com.timeline.mapper.MessageImageMapper;
//import com.timeline.mapper.MessageMapper;
//import com.timeline.pojo.Message;
//import com.timeline.pojo.MessageImage;
//import com.timeline.service.MessageService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class MessageServiceTest {
//	@Autowired
//	private MessageMapper messageMapper;
//	@Autowired
//	private MessageImageMapper messageImageMapper;
//	
//	private MessageService messageService;
//
//	@Before
//	public void setUp() throws Exception {
//		messageMapper = mock(MessageMapper.class);
//		messageImageMapper = mock(MessageImageMapper.class);
//
////		messageService = new MessageService(mockDao);
//	}
//	@Test
//	public void getAllMessages() throws Exception {
//		List<Message> list = new ArrayList<Message>();
//		Message message = new Message();
//		message.setAuthor("Tom");
//		message.setContent("Hello");
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");     
//		message.setCreateTime(format.parse("2019-11-11 11:00:00"));
//		message.setId(1);
//		list.add(message);
//
//		List<MessageImage> messageImages = new ArrayList<MessageImage>();
//		MessageImage messageImage = new MessageImage();
//		messageImage.setId(1);
//		messageImage.setMid(1);
//		messageImages.add(messageImage);
//		
//		when(messageMapper.queryAll()).thenReturn(list);
//		
//		messageService.getAllMessages(1, 3);
//		verify(messageMapper, times(1)).queryAll();
//		ArgumentCaptor<Integer> intArgCaptor = ArgumentCaptor.forClass(Integer.class);
//		verify(messageImageMapper, times(1)).queryByMessage(intArgCaptor.capture());
//		assertEquals(Integer.valueOf(list.size()), intArgCaptor.getValue());
//	}
//}
