package com.tex.tex.Service.Impl;

import com.tex.tex.DTO.UserDTO;
import com.tex.tex.Models.Profile;
import com.tex.tex.Provider.JwtTokenProvider;
import com.tex.tex.Repository.IHandleProfileRepo;
import com.tex.tex.Service.Service.IServiceProfile;
import com.tex.tex.Service.Service.IServiceUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Data
@Service
@Transactional
public class ServiceProfileImpl implements IServiceProfile {
    @Autowired
    private final IHandleProfileRepo iHandleProfileRepo;
    @Autowired
    private final IServiceUser iServiceUser;
    @Autowired
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public void createProfile(Profile profile) {
        iHandleProfileRepo.save(profile);
    }
    @Override
    public void updateProfile(Profile profile) {
        iHandleProfileRepo.save(profile);
    }
    @Override
    public Profile getProfileById(String uuid) {
        UUID profileId = UUID.fromString(uuid);
        return iHandleProfileRepo.getProfileById(profileId);
    }

    @Override
    public Profile getProfile(String username) {
        return iHandleProfileRepo.getProfileByUsername(username);
    }


    @Override
    @Transactional
    public void addContact(UUID profileID, String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token is required");
        }

        Profile profileToAdd = iHandleProfileRepo.findById(profileID)
                .orElseThrow(() -> new RuntimeException("Profile to add not found"));

        try {
            String inviterEmail = jwtTokenProvider.getUsername(token);
            UserDTO inviterUser = iServiceUser.searchUserDTOByEmail(inviterEmail);

            Profile inviterProfile = inviterUser.getProfile();
            if (inviterProfile == null) {
                throw new RuntimeException("Inviter doesn't have a profile");
            }

            if (inviterProfile.getProfileId().equals(profileID)) {
                throw new RuntimeException("Cannot add yourself as a contact");
            }

            // Initialize contacts if null (THIS IS THE IMPORTANT PART)
            if (inviterProfile.getContacts() == null) {
                inviterProfile.setContacts(new HashSet<>());
            }

            if (inviterProfile.getContacts().contains(profileToAdd)) {
                throw new RuntimeException("Contact already exists");
            }

            inviterProfile.getContacts().add(profileToAdd);
            iHandleProfileRepo.save(inviterProfile);

        } catch (Exception e) {
            throw new RuntimeException("Failed to add contact: " + e.getMessage(), e);
        }
    }


}
