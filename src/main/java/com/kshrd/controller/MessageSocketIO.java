package com.kshrd.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.kshrd.model.Message;

@Controller
public class MessageSocketIO {
	
	private SocketIOServer server;

	private DataListener<Message> onNewMessageListener = new DataListener<Message>() {
		@Override
		public void onData(SocketIOClient client, Message data, AckRequest ack) throws Exception {
			System.out.println("data: " + data);
			
			if(data.getSocketId() == "" || data.getSocketId() == null)
				server.getBroadcastOperations().sendEvent("message", data);
			else{
				UUID u = UUID.fromString(data.getSocketId());
				server.getClient(u).sendEvent("message", data);
			
				/*for(SocketIOClient cl: server.getAllClients()){
					if(cl.getSessionId().toString().equals(data.getSocketId())){
						server.getClient(cl.getSessionId()).sendEvent("message", data);
						break;
					}
				}*/
			}
		}
	};
	
	// /
	@Autowired
	public MessageSocketIO(SocketIOServer server) {
		this.server = server;
		this.server.addConnectListener(onConnect );
		this.server.addDisconnectListener(onDisconnect );
		this.server.addEventListener("new message", Message.class, onNewMessageListener );
	}
	
	private ConnectListener onConnect = new ConnectListener() {
		@Override
		public void onConnect(SocketIOClient client) {
			System.out.println("Client connected: " + client.getSessionId());
		}
	};
	
	private DisconnectListener onDisconnect = new DisconnectListener() {
		@Override
		public void onDisconnect(SocketIOClient client) {
			System.out.println("Client disconnected: " + client.getSessionId());
		}
	};
	
}
