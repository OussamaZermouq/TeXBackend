package com.tex.tex.Service.Impl;

import com.tex.tex.Models.Chat;
import com.tex.tex.Models.Profile;
import com.tex.tex.Repository.IHandleChatRepo;
import com.tex.tex.Repository.IHandleProfileRepo;
import com.tex.tex.Service.Service.IServiceChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatServiceImpl implements IServiceChat {
    @Autowired
    IHandleChatRepo iHandleChatRepo;
    @Autowired
    IHandleProfileRepo iHandleProfileRepo;
    @Override
    public void createChat(List<Profile> members) {
        iHandleChatRepo.save(new Chat(members));
    }

    @Override
    public List<Chat> getChatsForAProfile(UUID profileId) {
        Profile profile = iHandleProfileRepo.getProfileById(profileId);
        List<Chat> chats = iHandleChatRepo.findByMembersContaining(profile);
        //filter the list so that we can ignore the requester from the member list -- helps the frontend a lot
        return chats.stream()
                .map(chat -> {
                    // Remove the requester from the members list
                    chat.setMembers(chat.getMembers().stream()
                            .filter(member -> !member.getProfileId().equals(profileId))
                            .toList());
                    return chat;
                })
                .toList();
    }


}
