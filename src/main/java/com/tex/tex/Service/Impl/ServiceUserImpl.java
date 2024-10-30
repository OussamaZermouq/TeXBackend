package com.tex.tex.Service.Impl;

import com.tex.tex.DTO.ContactRequestDTO;
import com.tex.tex.Models.Profile;
import com.tex.tex.Models.User;
import com.tex.tex.Provider.JwtTokenProvider;
import com.tex.tex.Repository.IHandleProfileRepo;
import com.tex.tex.Repository.IHandleUserRepo;
import com.tex.tex.Service.Service.IServiceUser;
import com.tex.tex.DTO.UserDTO;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
@Transactional
public class ServiceUserImpl implements IServiceUser {
    private final IHandleUserRepo iHandleUserRepo;
    private final PasswordEncoder passwordEncoder;
    private final IHandleProfileRepo iHandleProfileRepo;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void addUser(User user) {
        var user_ = User.builder().
                id(user.getId()).
                email(user.getEmail()).
                password(passwordEncoder.encode(user.getPassword())).
                roles(user.getRoles()).
                build();
        System.out.println(user_);
        iHandleUserRepo.save(user_);
    }


    @Override
    public void updateUser(User user) {
        iHandleUserRepo.save(user);
    }
    @Override
    public UserDTO searchUserByEmail(String email){
        return convertToDTO(iHandleUserRepo.findByEmail(email));
    }

    @Override
    public void linkToProfile(String userId, Profile profile) {
        Optional<User> user= iHandleUserRepo.findById(UUID.fromString(userId));
        user.ifPresent(value -> value.setProfile(profile));
        iHandleUserRepo.save(user.get());

    }

    public UserDTO convertToDTO(User user){
        return new UserDTO(user.getId(),user.getEmail(),user.getCreatedAt(),user.getProfile());
    }
    public Optional<User> getUserById(String userId){
        return iHandleUserRepo.findById(UUID.fromString(userId));
    }

}
