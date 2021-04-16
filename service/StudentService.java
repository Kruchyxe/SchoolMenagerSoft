package pl.coderslab.schoolmenagersoft.service;

import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentDto studentDto);
    List<StudentDto> findAllStudents();
    void deleteStudentById(Long id);
    Student getStudent(Long id);
    Student updateStudent(StudentDto studentDto);


}
