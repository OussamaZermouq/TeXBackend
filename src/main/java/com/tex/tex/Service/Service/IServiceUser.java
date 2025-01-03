package com.tex.tex.Service.Service;

import com.tex.tex.Models.Profile;
import com.tex.tex.Models.User;
import com.tex.tex.DTO.UserDTO;

import java.util.HashSet;

public interface IServiceUser {
    public void addUser(User user);
    public void updateUser(User user);
    public UserDTO searchUserDTOByEmail(String email) throws Exception;

    public void linkToProfile(String userId, Profile profile);
    public HashSet<Profile> getContactsForAUser(String userToken);

    public User searchUserByEmail(String email);
}
