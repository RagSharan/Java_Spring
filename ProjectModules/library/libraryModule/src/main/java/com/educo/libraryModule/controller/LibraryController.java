package com.educo.libraryModule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	
	@PostMapping("/createLibrary")
	public void createLibrary() {
		
	}
	@PostMapping("addItemsInLibrary")
	public void addItemsInLibrary() {
		
	}
	@GetMapping("/getLibrary")
	public void getLibrary() {
		
	}
	
	@GetMapping("/getItemsFromLibrary")
	public void getItemsFromLibrary() {
		
	}

}
