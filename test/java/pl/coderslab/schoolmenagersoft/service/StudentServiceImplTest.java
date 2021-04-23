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
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    // test class cant be mocked
    @InjectMocks
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
        assertThat(studentDto).isSameAs(studentDto);


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

        // given
        Student student = new Student();
        student.setId(2L);
        student.setFirstName("Andrzej");
        student.setLastName("Maliniak");
        student.setPesel(888888888);
        student.setAge(10);

        // when
        underTest.get(2L);

        // then
        assertThat(student.getId()).isEqualTo(2L);
    }

    @Test
    void shouldDeleteStudentById() {

        // given
        Student student = new Student();
        student.setId(2L);
        student.setFirstName("Andrzej");
        student.setLastName("Maliniak");
        student.setPesel(888888888);
        student.setAge(10);

        // when
        underTest.deleteStudentById(student.getId());

        // then
        assertThat(student.getId()).isEqualTo(2L);
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