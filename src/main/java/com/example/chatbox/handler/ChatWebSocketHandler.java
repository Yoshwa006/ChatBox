package com.example.chatbox.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
    private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
 int count =0;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        sess.-----
        count++;
        System.out.println("Connection Established: " + session.getId()+ "number 1");
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received Message: " + message.getPayload());

        // Broadcast message to all clients\
        if (message.getPayload().equals("KILL ALL")) {

        } else {
            for (WebSocketSession s : sessions) {
                if (s.isOpen()) {
                    s.sendMessage(new TextMessage("User " + count + " : " + message.getPayload()));
                }
            }
        }
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) {
        count --;
        sessions.remove(session);
        System.out.println("Connection Closed: " + session.getId());

    }
}
