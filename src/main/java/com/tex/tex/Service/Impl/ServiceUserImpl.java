package com.tex.tex.Service.Impl;

import com.tex.tex.Models.Role;
import com.tex.tex.Models.User;
import com.tex.tex.Repository.IHandleUserRepo;
import com.tex.tex.Service.Service.IServiceUser;
import com.tex.tex.DTO.UserDTO;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

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
    public UserDTO searchUserByEmail(String email) throws Exception {
        return convertToDTO(iHandleUserRepo.findByEmail(email));
    }
    private UserDTO convertToDTO(User user){
        return new UserDTO(user.getId(),user.getEmail(),user.getCreatedAt());
    }

    private User convertToEntity(UserDTO userDTO){
        Set<Role> userRole = new HashSet<Role>();
        Role role = new Role(0L,"USER");
        userRole.add(role);
        return new User(userDTO.getId(),userDTO.getEmail(),null,userDTO.getCratedAt(), userRole);
    }
}
