package com.tex.tex.Controller;

import com.tex.tex.Models.Profile;
import com.tex.tex.Service.Impl.ServiceProfileImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {
    @Autowired
    private ServiceProfileImpl serviceProfile;
    @PostMapping("/add")
    private ResponseEntity<String> addUser(@RequestBody Profile profile){
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

}
