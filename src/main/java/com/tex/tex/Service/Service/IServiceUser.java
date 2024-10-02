package com.tex.tex.Service.Service;

import com.tex.tex.Models.User;

public interface IServiceUser {
    public void addUser(User user);
    public void updateUser(User user);
    public User searchUserByEmail(String email) throws Exception;
}
