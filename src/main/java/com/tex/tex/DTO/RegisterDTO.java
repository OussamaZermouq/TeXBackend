package com.tex.tex.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterDTO {
    private UUID id;
    private String email;
    private String password;

}
