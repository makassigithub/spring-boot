package com.makas.shipwreck.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@RequestMapping("/")
	public String SayHello() {
		return "Entrance point of the my Application";
	}
	
	
}
