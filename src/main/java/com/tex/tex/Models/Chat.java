package com.tex.tex.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("chat")
public class Chat {
    @Id
    private UUID chatUUID;
    private List<Message> messages;
    private List<User> members;

}
