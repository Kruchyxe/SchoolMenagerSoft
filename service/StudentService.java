package pl.coderslab.schoolmenagersoft.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

public interface StudentService extends UserDetailsService {

    Student save(StudentDto studentDto);
    Student findAll(StudentDto studentDto);
    Student delete(StudentDto studentDto);
    Student findById(StudentDto studentDto);


}
