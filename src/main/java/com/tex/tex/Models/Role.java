package com.tex.tex.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("role")
public class Role {
    private Long id;
    private String name;
}
