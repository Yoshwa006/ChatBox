package com.example.chatbox.service;

import com.example.chatbox.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private final List<ChatMessage> chatHistory = new ArrayList<>();

    public void saveMessage(ChatMessage message) {
        chatHistory.add(message);
    }

    public String clear(){
        chatHistory.clear();
        return "Cleared";
    }

    public List<ChatMessage> getChatHistory() {
        return chatHistory;
    }
}
