package com.tex.tex.Controller;


import com.tex.tex.DTO.ContactRequestDTO;
import com.tex.tex.Models.Chat;
import com.tex.tex.Models.Profile;
import com.tex.tex.Models.User;
import com.tex.tex.Provider.JwtTokenProvider;
import com.tex.tex.Repository.IHandleProfileRepo;
import com.tex.tex.Service.Impl.ChatServiceImpl;
import com.tex.tex.Service.Impl.ServiceProfileImpl;
import com.tex.tex.Service.Impl.ServiceUserImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RequestMapping("/api/v1/chat")
@RestController
public class ChatController {
    @Autowired
    private ChatServiceImpl chatService;
    @Autowired
    private ServiceProfileImpl serviceProfile;
    @Autowired
    private ServiceUserImpl serviceUser;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @GetMapping("/")
    public ResponseEntity<List<Chat>> getChats(@RequestHeader String authorization){
        User user = serviceUser.searchUserByEmail(jwtTokenProvider.getUsername(authorization.substring(7)));
        Profile profile = user.getProfile();
        List<Chat> chats = chatService.getChatsForAProfile(profile.getProfileId());
        return ResponseEntity.ok().body(chats);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createChat(@RequestBody ContactRequestDTO profileRequest,
                                             @RequestHeader String authorization){

        System.out.println(profileRequest.getProfileID());
        Profile profile = serviceProfile.getProfileById(profileRequest.getProfileID());
        User user = serviceUser.searchUserByEmail(
                jwtTokenProvider.getUsername(authorization.substring(7))
        );
        if (profile == null || user == null){

            System.out.println(user.toString());
            System.out.println(profile.toString());

            return ResponseEntity.badRequest().body("One of the members is not found");
        }
        List<Profile> members = new ArrayList<>();
        members.add(user.getProfile());
        members.add(profile);
        chatService.createChat(members);
        return ResponseEntity.ok().body("Chat created successfully");
    }
}
