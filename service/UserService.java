package pl.coderslab.schoolmenagersoft.service;

import pl.coderslab.schoolmenagersoft.model.User;
import pl.coderslab.schoolmenagersoft.web.dto.UserRegisterDto;

public interface UserService {
    User save(UserRegisterDto registerDto);

}
