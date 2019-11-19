/**
 * 基于Junit4 使用Junit5方法会报错or失效
 */
package com.timeline.controller;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
import com.timeline.Application;
import com.timeline.service.MessageService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MessageControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	//@MockBean=@Autowired+mock方法实例化对象
	@MockBean
	private MessageService messageService;
	
	//如果改成@BeforeAll 会失败
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void should_show_first_page() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(new URI("/showAll")))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.jsonPath("msg").value("OK"))
				.andDo(MockMvcResultHandlers.print());
		ArgumentCaptor<Integer> intArgCaptor1 = ArgumentCaptor.forClass(Integer.class);
		ArgumentCaptor<Integer> intArgCaptor2 = ArgumentCaptor.forClass(Integer.class);
		verify(messageService,times(1)).getAllMessages(intArgCaptor1.capture(),intArgCaptor2.capture());
		assertEquals(Integer.valueOf(1), intArgCaptor1.getValue());
		assertEquals(Integer.valueOf(8), intArgCaptor2.getValue());
	}

	@Test
	public void should_show_second_page() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(new URI("/showAll?page=2")))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(MockMvcResultMatchers.jsonPath("msg").value("OK"))
				.andDo(MockMvcResultHandlers.print());

		ArgumentCaptor<Integer> intArgCaptor1 = ArgumentCaptor.forClass(Integer.class);
		ArgumentCaptor<Integer> intArgCaptor2 = ArgumentCaptor.forClass(Integer.class);
		verify(messageService,times(1)).getAllMessages(intArgCaptor1.capture(),intArgCaptor2.capture());
		assertEquals(Integer.valueOf(2), intArgCaptor1.getValue());
		assertEquals(Integer.valueOf(8), intArgCaptor2.getValue());
	}
}

/**
 * 同PPT 失败
 */
//package com.timeline.controller;
//
//import java.net.URI;
//
//import javax.annotation.Resource;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
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
//import com.timeline.service.MessageService;
////@ExtendWith(SpringExtension.class)
//@WebMvcTest
//public class MessageControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//	@MockBean
////	@Resource
//	private MessageService messageService;
//	
//	@Test
//	public void showFirstPage() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get(new URI("/showAll")))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//        .andExpect(MockMvcResultMatchers.jsonPath("msg").value("OK"))
//				.andDo(MockMvcResultHandlers.print());
////		verify(messageService).getAllMessages(Integer.valueOf(1),Integer.valueOf(3));
//
//		ArgumentCaptor<Integer> intArgCaptor1 = ArgumentCaptor.forClass(Integer.class);
//		ArgumentCaptor<Integer> intArgCaptor2 = ArgumentCaptor.forClass(Integer.class);
//		verify(messageService,times(1)).getAllMessages(intArgCaptor1.capture(),intArgCaptor2.capture());
//		assertEquals(Integer.valueOf(1), intArgCaptor1.getValue());
//		assertEquals(Integer.valueOf(3), intArgCaptor2.getValue());
//	}
//
//	@Test
//	public void showOtherPage() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get(new URI("/showAll?page=2")))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//        .andExpect(MockMvcResultMatchers.jsonPath("msg").value("OK"))
//				.andDo(MockMvcResultHandlers.print());
//
//		ArgumentCaptor<Integer> intArgCaptor1 = ArgumentCaptor.forClass(Integer.class);
//		ArgumentCaptor<Integer> intArgCaptor2 = ArgumentCaptor.forClass(Integer.class);
//		verify(messageService,times(1)).getAllMessages(intArgCaptor1.capture(),intArgCaptor2.capture());
//		assertEquals(Integer.valueOf(2), intArgCaptor1.getValue());
//		assertEquals(Integer.valueOf(3), intArgCaptor2.getValue());
//	}
//}



//package com.timeline.controller;
//
//import java.net.URI;
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
//import com.timeline.service.MessageService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
//public class MessageControllerTest {
//
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//	private MockMvc mockMvc;
//	@Autowired
//	private MessageService messageService;
//	
//	@Before
//	public void setupMockMvc() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//		messageService = mock(MessageService.class);
//	}
//
//	@Test
//	@DisplayName("展示首页")
//	public void showFirstPage() throws Exception {
////		Mockito.when(messageService.getAllMessages(1,3)).thenReturn(null);
////		assertNull(messageService.getAllMessages(1,3));
//		mockMvc.perform(MockMvcRequestBuilders.get(new URI("/showAll")))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//        .andExpect(MockMvcResultMatchers.jsonPath("msg").value("OK"))
////        .andExpect(content().string("query result"));
//				.andDo(MockMvcResultHandlers.print());
////		verify(messageService).getAllMessages(Integer.valueOf(1),Integer.valueOf(3));
////
////		ArgumentCaptor<Integer> intArgCaptor1 = ArgumentCaptor.forClass(Integer.class);
////		ArgumentCaptor<Integer> intArgCaptor2 = ArgumentCaptor.forClass(Integer.class);
////		verify(messageService,times(1)).getAllMessages(intArgCaptor1.capture(),intArgCaptor2.capture());
////		assertEquals(Integer.valueOf(1), intArgCaptor1.getValue());
////		assertEquals(Integer.valueOf(3), intArgCaptor2.getValue());
//	}
//
//	@Test
//	@DisplayName("展示第二页")
//	public void showOtherPage() throws Exception {
////		Mockito.when(messageService.getAllMessages(1,3)).thenReturn(null);
////		assertNull(messageService.getAllMessages(1,3));
//		mockMvc.perform(MockMvcRequestBuilders.get(new URI("/showAll?page=2")))
//		.andExpect(MockMvcResultMatchers.status().isOk())
//		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
//        .andExpect(MockMvcResultMatchers.jsonPath("msg").value("OK"))
////        .andExpect(content().string("query result"));
//				.andDo(MockMvcResultHandlers.print());
////		verify(messageService).getAllMessages(Integer.valueOf(1),Integer.valueOf(3));
////
////		ArgumentCaptor<Integer> intArgCaptor1 = ArgumentCaptor.forClass(Integer.class);
////		ArgumentCaptor<Integer> intArgCaptor2 = ArgumentCaptor.forClass(Integer.class);
////		verify(messageService,times(1)).getAllMessages(intArgCaptor1.capture(),intArgCaptor2.capture());
////		assertEquals(Integer.valueOf(1), intArgCaptor1.getValue());
////		assertEquals(Integer.valueOf(3), intArgCaptor2.getValue());
//	}
//}



