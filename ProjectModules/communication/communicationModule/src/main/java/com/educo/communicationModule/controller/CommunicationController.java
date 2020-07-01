package com.educo.communicationModule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/communication")
@RestController
public class CommunicationController {
	
	
	@PostMapping("SendMessage")
	public void sendMessage() {
		
	}
	
	@GetMapping("getMessages")
	public void getMessage() {
		
	}
	
	@PostMapping("/sendClassMessage")
	public void sendClassMessage() {
		
	}

}
