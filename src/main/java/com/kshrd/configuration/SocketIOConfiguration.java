package com.kshrd.configuration;

import org.springframework.context.annotation.Bean;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

@org.springframework.context.annotation.Configuration
public class SocketIOConfiguration {

	@Bean
	public SocketIOServer socketIOServer(){
		SocketIOServer socket = new SocketIOServer(socketConfig());
		socket.start();
		return socket;
	}
	
	@Bean
	public Configuration socketConfig(){
		Configuration conf = new Configuration();
		conf.setHostname("localhost");
		conf.setPort(4444);
		return conf;
	}
	
}
