package com.tex.tex.Service.Service;

import com.tex.tex.DTO.LoginDTO;
import com.tex.tex.DTO.RegisterDTO;

public interface IAuthService {
    String login (LoginDTO loginDTO);
}
