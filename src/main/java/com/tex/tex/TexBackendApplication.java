package com.tex.tex;

import com.tex.tex.Models.User;
import com.tex.tex.Service.Impl.ServiceUserImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class TexBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(TexBackendApplication.class, args);
	}
}
