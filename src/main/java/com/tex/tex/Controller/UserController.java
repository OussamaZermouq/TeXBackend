package com.tex.tex.Controller;

import com.tex.tex.Models.User;
import com.tex.tex.Service.Impl.ServiceUserImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private ServiceUserImpl serviceUser;
    @PostMapping("/add")
    private ResponseEntity<String> addUser(@RequestBody User user){
        serviceUser.addUser(user);
        return ResponseEntity.accepted().build();
    }

}
