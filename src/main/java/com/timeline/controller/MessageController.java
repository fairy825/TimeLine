package com.timeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timeline.service.MessageService;
import com.timeline.utils.IMoocJSONResult;
import com.timeline.utils.PagedResult;

@RestController
public class MessageController {
	@Autowired
	MessageService messageService;

	@GetMapping(value = "/showAll")
	public IMoocJSONResult showAll(Integer page) throws Exception {
		if (page == null) {
			page = 1;
		}
		PagedResult pagedResult = messageService.getAllMessages(page, 8);
		return IMoocJSONResult.ok(pagedResult);
	}
}
