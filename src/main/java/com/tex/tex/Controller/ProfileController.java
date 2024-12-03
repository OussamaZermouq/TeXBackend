package com.tex.tex.Controller;

import com.tex.tex.DTO.ContactRequestDTO;
import com.tex.tex.Models.Profile;
import com.tex.tex.Service.Impl.ServiceProfileImpl;
import com.tex.tex.Service.Impl.ServiceUserImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {
    @Autowired
    private ServiceProfileImpl serviceProfile;
    @Autowired
    private ServiceUserImpl serviceUser;
    @PostMapping("/add")
    private ResponseEntity<String> addUser(@RequestBody Profile profile){
        //this should probably take the token and use it for the user linking but since im using the user id it works as well
        serviceProfile.createProfile(profile);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/username")
    private ResponseEntity<Profile> getProfile(@RequestParam String username){

        Profile profile = serviceProfile.getProfile(username);
        if (profile!=null){
            return ResponseEntity.ok(profile);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addContact")
    private ResponseEntity<String> addContact(@RequestBody ContactRequestDTO profileRequestID,
                                              @RequestHeader(name = "Authorization") String token
    ){
        serviceProfile.addContact(UUID.fromString(profileRequestID.getProfileID()), token.substring(7));
        return ResponseEntity.ok().build();
    }
}
