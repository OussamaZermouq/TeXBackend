package com.tex.tex.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    private UUID profileId;
    private String firstName;
    private String lastName;
    private String username;
    private int age;
    private String bio;
    private String imageURI;
    @DBRef
    private User user;
}
