package pl.coderslab.schoolmenagersoft.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.coderslab.schoolmenagersoft.repository.UserRepository;
import pl.coderslab.schoolmenagersoft.web.dto.UserRegisterDto;


class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl underTest;

    @BeforeEach
    void setUp(){

    }

    @Test
    void shouldSaveUser() {
        // given

        // when

        // then
    }

    @Test
    void shouldLoadUserByUsername() {
        // given


        // when

        // then
    }
}