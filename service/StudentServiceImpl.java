package pl.coderslab.schoolmenagersoft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.repository.StudentRepository;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(StudentDto studentDto) {
        Student student = new Student(studentDto.getFirstName(), studentDto.getLastName(),
                studentDto.getPesel(), studentDto.getAge(), studentDto.getParentMobileNumber(),
                studentDto.getParentMail(), studentDto.getSchoolStartDate(), studentDto.getSchoolEndDate());
        return studentRepository.save(student);
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentsDto = StreamSupport.stream(students.spliterator(), false).map(student -> {
            StudentDto dto = new StudentDto();
            BeanUtils.copyProperties(student, dto);
            return dto;
        }).collect(Collectors.toList());
        return studentsDto;
    }

    @Override
    public Student deleteStudentById(Long id) {
        return null;
    }

    @Override
    public Optional<Student> getStudent(StudentDto studentDto) {
        return Optional.empty();
    }

    @Override
    public Student updateStudent(StudentDto studentDto) {
        Student student = new Student(studentDto.getFirstName(), studentDto.getLastName(),
                studentDto.getPesel(), studentDto.getAge(), studentDto.getParentMobileNumber(), studentDto.getParentMail(),
                studentDto.getSchoolStartDate(), studentDto.getSchoolEndDate());
        return studentRepository.save(student);
    }


}
