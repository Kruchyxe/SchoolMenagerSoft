package pl.coderslab.schoolmenagersoft.service;

import org.springframework.stereotype.Service;
import pl.coderslab.schoolmenagersoft.model.Role;
import pl.coderslab.schoolmenagersoft.model.User;
import pl.coderslab.schoolmenagersoft.repository.UserRepository;
import pl.coderslab.schoolmenagersoft.web.dto.UserRegisterDto;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegisterDto registerDto) {
        User user = new User(registerDto.getFirstName(),
                registerDto.getLastName(), registerDto.getEmail(),
                registerDto.getPassword(), Arrays.asList(new Role("USER_ROLE")));

        return userRepository.save(user);
    }
}
