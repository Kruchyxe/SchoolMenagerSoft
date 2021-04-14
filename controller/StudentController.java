package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.schoolmenagersoft.service.StudentService;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String studentList(Model model){
        model.addAttribute("student", studentService.findAllStudents());
        return "students";
    }
}
