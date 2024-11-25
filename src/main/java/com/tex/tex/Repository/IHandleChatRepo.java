package com.tex.tex.Repository;

import com.tex.tex.Models.Chat;
import com.tex.tex.Models.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IHandleChatRepo extends MongoRepository<Chat, UUID> {
    /*
    * Used to fetch for the chats where a user  - member - is in*/
    List<Chat> findByMembersContaining(Profile member);
}
