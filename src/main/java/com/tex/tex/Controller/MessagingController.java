package com.tex.tex.Controller;

import com.tex.tex.DTO.MessageSentDTO;
import com.tex.tex.Models.Chat;
import com.tex.tex.Models.Message;
import com.tex.tex.Models.User;
import com.tex.tex.Service.Impl.ChatServiceImpl;
import com.tex.tex.Service.Impl.MessageServiceImpl;
import com.tex.tex.Service.Impl.ServiceUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Controller
public class MessagingController {

    @Autowired
    public ServiceUserImpl userService;
    @Autowired
    public MessageServiceImpl messageService;
    @Autowired
    public ChatServiceImpl chatService;

    //endpoint example :/app/chat/0294c2dc-30b0-4123-ae32-28718a654358
    @MessageMapping("/chat/{chatId}")
    @SendTo("/topic/chat/{chatId}")
    public Message message(MessageSentDTO message, @DestinationVariable String chatId) {
        Chat chat = chatService.getChatById(UUID.fromString(chatId));
        Optional<User> userSender = userService.getUserById(String.valueOf(message.getSenderId()));

        if (chat == null || message == null || userSender.isEmpty()) {
            System.err.print("THERE IS AN ISSUE WITH THE SENT MESSAGE");
            return null;
        }

        Message messageToSend = Message.builder().
                messageId(message.getMessageId()).
                sender(userSender.get()).
                content(message.getContent()).
                createdAt(message.getCreatedAt()).
                build();

        chat.getMessages().add(messageToSend);
        messageService.saveMessage(messageToSend);
        chatService.updateChat(chat);

        return messageToSend;

    }
}
