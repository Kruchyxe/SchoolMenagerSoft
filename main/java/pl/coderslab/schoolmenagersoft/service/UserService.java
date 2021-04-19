package pl.coderslab.schoolmenagersoft.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.schoolmenagersoft.model.User;
import pl.coderslab.schoolmenagersoft.web.dto.UserRegisterDto;

public interface UserService extends UserDetailsService {
    User save(UserRegisterDto registerDto);

}
