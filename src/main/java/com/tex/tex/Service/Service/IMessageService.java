package com.tex.tex.Service.Service;

import com.tex.tex.Models.Message;

import java.util.List;

public interface IMessageService {
    void saveMessage(Message message);
    List<Message> getMessagesFromChat(String chatId);
}
