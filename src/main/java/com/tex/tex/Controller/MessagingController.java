package com.tex.tex.Controller;

import com.tex.tex.Models.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessagingController{
    @MessageMapping("/chat/{chatID}")
    @SendTo("/topic/chat/{chatID}")
    public Message greeting(@DestinationVariable String chatID, Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return message;
    }
}
