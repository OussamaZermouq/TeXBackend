package com.tex.tex.Service.Impl;

import com.tex.tex.Models.Chat;
import com.tex.tex.Models.Message;
import com.tex.tex.Repository.IHandleChatRepo;
import com.tex.tex.Repository.IHandleMessageRepo;
import com.tex.tex.Service.Service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    IHandleMessageRepo messageRepo;
    @Autowired
    IHandleChatRepo iHandleChatRepo;
    @Override
    public void saveMessage(Message message) {
        messageRepo.save(message);
    }

    @Override
    public List<Message> getMessagesFromChat(String chatId) {
        Optional<Chat> chat = iHandleChatRepo.findById(UUID.fromString(chatId));
        if (chat.isPresent()){
            return chat.get().getMessages();
        }

        return null;
    }

}
