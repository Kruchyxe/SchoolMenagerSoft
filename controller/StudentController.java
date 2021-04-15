package pl.coderslab.schoolmenagersoft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.schoolmenagersoft.service.StudentService;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;


@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ModelAttribute("student")
    public StudentDto studentDto(){
        return new StudentDto();
    }

    @GetMapping()
    public String studentList(Model model){
        model.addAttribute("student", studentService.findAllStudents());
        return "students";
    }

    @GetMapping("/addstudents")
    public String showAddStudentForm(){
        return "addstudents";
    }

    @PostMapping("/addstudents")
    public String addNewStudent(@ModelAttribute("student") StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return "redirect:/students";
    }


}
