package com.tex.tex.Service.Service;

import com.tex.tex.Models.User;
import com.tex.tex.UserDTO;

import java.util.List;
import java.util.UUID;

public interface IServiceUser {
    public void addUser(User user);
    public void updateUser(User user);
    public UserDTO searchUserByEmail(String email) throws Exception;

}
