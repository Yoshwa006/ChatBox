package com.example.chatbox.controller;

import com.example.chatbox.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @GetMapping("/status")
    public String getStatus() {
        return "Chatbox server is running on localhost:8080!";
    }
    @Autowired
    ChatService service;
    @GetMapping("clear")
    public String clear(){
        service.clear();
        return "Cleared !";
    }
}
