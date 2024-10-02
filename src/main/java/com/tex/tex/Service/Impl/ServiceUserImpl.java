package com.tex.tex.Service.Impl;

import com.tex.tex.Models.User;
import com.tex.tex.Repository.IHandleUserRepo;
import com.tex.tex.Service.Service.IServiceUser;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Data
@Service
@Transactional
public class ServiceUserImpl implements IServiceUser {
    private final IHandleUserRepo iHandleUserRepo;
    @Override
    public void addUser(User user) {
        iHandleUserRepo.save(user);
    }

    @Override
    public void updateUser(User user) {
        iHandleUserRepo.save(user);
    }

    @Override
    public User searchUserByEmail(String email) throws Exception {
        return iHandleUserRepo.findByEmail(email);
    }
}
