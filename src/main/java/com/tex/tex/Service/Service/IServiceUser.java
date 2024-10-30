package com.tex.tex.Service.Service;

import com.tex.tex.DTO.ContactRequestDTO;
import com.tex.tex.Models.Profile;
import com.tex.tex.Models.User;
import com.tex.tex.DTO.UserDTO;

import java.util.UUID;

public interface IServiceUser {
    public void addUser(User user);
    public void updateUser(User user);
    public UserDTO searchUserByEmail(String email) throws Exception;

    public void linkToProfile(String userId, Profile profile);

}
