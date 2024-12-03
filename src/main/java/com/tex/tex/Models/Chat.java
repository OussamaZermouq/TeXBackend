package com.tex.tex.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat")
public class Chat {
    @Id
    private UUID chatId = UUID.randomUUID();
    //initialize empty array on object creation so that we can store message upon creating a chat
    @DBRef
    private List<Message> messages = new ArrayList<>();
    @DBRef
    private List<Profile> members;

    public Chat(List<Profile> members){
        this.members = members;
    }
}
