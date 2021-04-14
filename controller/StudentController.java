package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.service.StudentService;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentlist")
    public String studentList(Model model){
        List<StudentDto> students = studentService.findAllStudents();
        model.addAttribute("student", students);
        return "studentlist";
    }
}
