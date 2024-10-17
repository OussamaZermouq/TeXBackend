package com.tex.tex.Service.Impl;

import com.tex.tex.Models.Profile;
import com.tex.tex.Models.User;
import com.tex.tex.Repository.IHandleProfileRepo;
import com.tex.tex.Repository.IHandleUserRepo;
import com.tex.tex.Service.Service.IServiceProfile;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
@Transactional
public class ServiceProfileImpl implements IServiceProfile {
    @Autowired
    private final IHandleProfileRepo iHandleProfileRepo;
    @Override
    public void createProfile(Profile profile) {
        iHandleProfileRepo.save(profile);
    }
    @Override
    public void updateProfile(Profile profile) {
        iHandleProfileRepo.save(profile);
    }

    @Override
    public Profile getProfile(String username) {
        return iHandleProfileRepo.getProfileByUsername(username);
    }

}
