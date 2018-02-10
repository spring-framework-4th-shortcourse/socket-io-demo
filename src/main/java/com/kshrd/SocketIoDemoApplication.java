package com.kshrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SocketIoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketIoDemoApplication.class, args);
	}
	
	@GetMapping("/")
	public String home(){
		return "index";
	}
	
}
