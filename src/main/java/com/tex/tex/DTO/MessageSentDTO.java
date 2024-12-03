package com.tex.tex.DTO;

import lombok.Data;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

@Data
public class MessageSentDTO {
    UUID messageId;
    String content;
    Date createdAt;
    UUID senderId;
}
