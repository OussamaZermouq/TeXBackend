package com.tex.tex.Models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("user")
public class User {
    @Id
    private UUID id = UUID.randomUUID();
    @Indexed(unique = true)
    private String email;
    private String password;
    @CreatedDate
    private Date createdAt;
    @DBRef
    public Profile profile;
    @DBRef
    private Set<Role> roles;
}
