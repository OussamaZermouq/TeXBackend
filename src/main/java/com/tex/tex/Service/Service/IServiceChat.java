package com.tex.tex.Service.Service;

import com.tex.tex.Models.Chat;
import com.tex.tex.Models.Profile;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IServiceChat {
    void createChat(List<Profile> members);
    List<Chat> getChatsForAProfile(UUID profileId);

}
