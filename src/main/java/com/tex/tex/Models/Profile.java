package com.tex.tex.Models;

import com.tex.tex.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    private HashSet<Profile> contacts;

}
