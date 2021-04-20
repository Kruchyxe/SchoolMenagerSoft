package pl.coderslab.schoolmenagersoft.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.repository.StudentRepository;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
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
    void shouldAddStudent() {

        // given
        StudentDto studentDto = new StudentDto(
                "Antek",
                "Malinowski",
                88888888,
                10,
                666666666,
                "anton@o2.pl",
                LocalDate.parse("2021-04-21"),
                LocalDate.parse("2021-06-18")
        );

        // when
        underTest.addStudent(studentDto);

        // then
        ArgumentCaptor<Student> studentDtoArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);
        verify(studentRepository)
                .save(studentDtoArgumentCaptor.capture());
        Student value = studentDtoArgumentCaptor.getValue();
        assertThat(value).isSameAs(studentDto);

    }

    @Test
    void shouldFindAllStudents() {

        // when
        underTest.findAllStudents();

        // then
        verify(studentRepository).findAll();

    }

    @Test
    void shouldGetStudent() {

        // given
        long id = 2;

        // when
        underTest.get(id);

        // then
        verify(studentRepository).getOne(id);
    }

    @Test
    void shouldDeleteStudentById() {

        // given
        long id = 2;

        // when
        underTest.deleteStudentById(id);

        // then
        verify(studentRepository).deleteById(id);
    }

    @Test
    @Disabled
    void shouldUpdateStudent() {
    }
}