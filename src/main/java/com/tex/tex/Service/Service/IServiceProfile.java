package com.tex.tex.Service.Service;

import com.tex.tex.Models.Profile;
import com.tex.tex.Models.User;

import java.util.UUID;

public interface IServiceProfile {
    public void createProfile(Profile profile);
    public void updateProfile(Profile profile);
    public Profile getProfile(String username);
    public void addContact(UUID profileID, String token);

}
