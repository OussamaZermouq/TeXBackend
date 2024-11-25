package com.tex.tex.Controller;

import com.tex.tex.test.Greeting;
import com.tex.tex.test.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessagingController{
    @MessageMapping("/chat/{chatID}")
    @SendTo("/topic/chat/{chatID}")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println(message.getName());
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
