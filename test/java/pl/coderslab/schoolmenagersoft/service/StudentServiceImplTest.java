package pl.coderslab.schoolmenagersoft.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.repository.StudentRepository;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    // test class cant be mocked
    private StudentServiceImpl underTest;

    @BeforeEach
    void setUp(){
        underTest = new StudentServiceImpl(studentRepository);

    }

    @Test
    void shouldAddStudent() {

        // given
        StudentDto student = new StudentDto("Adam","Mickiewicz",
                22222222,10,6666666,
                "mama@wp.pl",LocalDate.parse("2021-04-12"),LocalDate.parse("2022-01-12"));

        // when
        underTest.addStudent(student);

        assertNotNull(student);

    }

    @Test
    void shouldFindAllStudents() {

        // when
        List<StudentDto> studentList = underTest.findAllStudents();
        StudentDto studentDto = new StudentDto();
        studentList.add(studentDto);
        studentList.add(studentDto);
        studentList.add(studentDto);

        // then
        verify(studentRepository).findAll();

        assertEquals(3,studentList.size());

    }

    @Test
    void shouldGetStudent() {

        when(underTest.get(anyLong())).thenReturn(Optional.of(new Student()));

        Optional<Student> student = underTest.get(2L);

        assertNotNull(student);
    }

    @Test
    void shouldDeleteStudentById() {
        // when

        underTest.deleteStudentById(anyLong());

        // then
        verify(studentRepository, times(1)).deleteById(anyLong());


    }

    @Test
    void shouldUpdateStudent() {

        // given
        Student student = new Student();
        student.setId(2L);
        student.setFirstName("Andrzej");
        student.setLastName("Maliniak");
        student.setPesel(888888888);
        student.setAge(10);

        // when
        underTest.updateStudent(student);


        // then
        assertThat(student.getAge()).isEqualTo(10);
    }
}