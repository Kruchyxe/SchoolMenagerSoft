package pl.coderslab.schoolmenagersoft.service;

import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student addStudent(StudentDto studentDto);
    List<StudentDto> findAllStudents();
    Optional<Student> get(Long id);
    void deleteStudentById(Long id);
    void updateStudent(Student student);


}
