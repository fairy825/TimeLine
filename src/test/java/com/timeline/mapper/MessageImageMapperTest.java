/**
 * Junit4 OK
 */
package com.timeline.mapper;

import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
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
@MybatisTest 
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class MessageImageMapperTest {
	@Autowired
	private MessageImageMapper messageImageMapper;
	private Message message;
 
	@Test
	public void should_query_image_by_message() throws Exception {
		List<MessageImage> messageImages = messageImageMapper.queryByMessage(1);
		assertEquals(2, messageImages.size());
	}

}

//package com.timeline.mapper;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.timeline.Application;
//import com.timeline.pojo.Message;
//
//@RunWith(SpringRunner.class)
//@MybatisTest 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.H2)
////JPA使用下列注解
////@DataJpaTest
////@DirtiesContext
//class MessageMapperTest {
//	@Autowired
//	private MessageMapper messageMapper;
////	JPA
////	@Autowired
////	private TestEntityManager entityManager;
//
//	private Message message;
//
//	@Before
//	public void setup() throws Exception {
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//		message = new Message.MessageBuilder().author("Tom").content("Hello")
//				.createTime(format.parse("2019-11-11 11:00:00")).build();
//		message.setId(1);
//	}
//
////	@After
////	public void cleanup() {
////		this.entityManager.clear();
////	}
//
//	@Test
//	void should_query_all_message() throws Exception {
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
////		this.entityManager.persist(message);
//		List<Message> messages = messageMapper.queryAll();
//
//		int count = 0;
//		System.out.println(messages.size());
//
////		for (Message message : messages) {
////			System.out.println(message);
////			assertEquals("Tom", message.getAuthor());
////			assertEquals("Hello", message.getContent());
////			assertEquals(format.parse("2019-11-11 11:00:00"), message.getCreateTime());
////			count++;
////		}
////		assertEquals(1, count);
//	}
//
//}
