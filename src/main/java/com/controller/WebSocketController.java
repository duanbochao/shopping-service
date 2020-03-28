package com.controller;

import com.bean.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/27 11:56
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat){
        chat.setFrom(principal.getName());
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }

}
