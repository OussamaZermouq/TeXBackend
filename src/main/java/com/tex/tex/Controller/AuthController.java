package com.tex.tex.Controller;


import com.tex.tex.DTO.AuthResponseDTO;
import com.tex.tex.DTO.LoginDTO;
import com.tex.tex.DTO.RegisterDTO;
import com.tex.tex.Models.User;
import com.tex.tex.Repository.IHandleUserRepo;
import com.tex.tex.Service.Impl.AuthServiceImpl;
import com.tex.tex.Service.Impl.ServiceUserImpl;
import com.tex.tex.Service.Service.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;
    private ServiceUserImpl serviceUser;
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
        String token = authService.login(loginDTO);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setAccessToken(token);
        return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody User user){
        serviceUser.addUser(user);
        String token = authService.login(new LoginDTO(user.getEmail(), user.getPassword()));
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setAccessToken(token);
        return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
    }
}
