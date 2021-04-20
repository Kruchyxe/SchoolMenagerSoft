package pl.coderslab.schoolmenagersoft.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.schoolmenagersoft.repository.StudentRepository;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    private StudentServiceImpl underTest;

    @BeforeEach
    void setUp(){
        underTest = new StudentServiceImpl(studentRepository);

    }

    @Test
    @Disabled
    void shouldAddStudent() {

    }

    @Test
    void shouldFindAllStudents() {
        // when
        underTest.findAllStudents();

        // then
        verify(studentRepository).findAll();

    }

    @Test
    @Disabled
    void shouldGetStudent() {
    }

    @Test
    @Disabled
    void shouldDeleteStudentById() {
    }

    @Test
    @Disabled
    void shouldUpdateStudent() {
    }
}