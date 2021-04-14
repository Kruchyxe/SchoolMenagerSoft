package pl.coderslab.schoolmenagersoft.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.repository.StudentRepository;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save (StudentDto studentDto){
        Student student = new Student(studentDto.getFirstName(),studentDto.getLastName(),
                studentDto.getPesel(),studentDto.getAge(),studentDto.getParentMobileNumber(),
                studentDto.getParentMail(),studentDto.getSchoolStartDate(),studentDto.getSchoolEndDate());
        return studentRepository.save(student);
    }

    @Override
    public Student findAll(StudentDto studentDto) {
        return null;
    }

    @Override
    public Student delete(StudentDto studentDto) {
        return null;
    }

    @Override
    public Student findById(StudentDto studentDto) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
