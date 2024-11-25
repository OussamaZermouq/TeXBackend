package com.tex.tex.Controller;

import com.tex.tex.Models.Profile;
import com.tex.tex.Models.User;
import com.tex.tex.Service.Impl.ServiceProfileImpl;
import com.tex.tex.Service.Impl.ServiceUserImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private ServiceUserImpl serviceUser;
    @Autowired
    private ServiceProfileImpl serviceProfile;

    @PostMapping("/add")
    private ResponseEntity<String> addUser(@RequestBody User user){
        serviceUser.addUser(user);
        return ResponseEntity.accepted().build();
    }


    @PostMapping("/linkProfile")
    private ResponseEntity<String> linkProfile(@RequestParam String userId,
                                               @RequestBody Profile profile) {
        try {
            serviceProfile.createProfile(profile);
            serviceUser.linkToProfile(userId, profile);
            return ResponseEntity.ok("Profile linked successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to link profile: " + e.getMessage());
        }
    }

    @GetMapping("/user")
    private Optional<User> getUser(@RequestParam String userId){
        return ResponseEntity.accepted().body(serviceUser.getUserById(userId)).getBody();
    }
    @GetMapping("/contacts")
    private ResponseEntity<HashSet<Profile>> getContacts(@RequestHeader String authorization){
        return ResponseEntity.accepted().body(serviceUser.getContactsForAUser(authorization));
    }

}
