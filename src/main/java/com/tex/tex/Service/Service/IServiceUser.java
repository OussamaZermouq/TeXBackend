package com.tex.tex.Service.Service;

import com.tex.tex.Models.User;
import com.tex.tex.DTO.UserDTO;

public interface IServiceUser {
    public void addUser(User user);
    public void updateUser(User user);
    public UserDTO searchUserByEmail(String email) throws Exception;

}
