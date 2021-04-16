package pl.coderslab.schoolmenagersoft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.service.StudentService;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

import javax.persistence.EntityNotFoundException;
import java.awt.print.Book;


@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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

    @GetMapping("/deletestudent")
    public String deleteStudent(Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/detailsstudent")
    public String showDetailForm(long id, Model model) {
        model.addAttribute("student", studentService.get(id).orElseThrow(EntityNotFoundException::new));
        return "detailsstudent";
    }

    @GetMapping("/editstudent")
    public String showEditForm(long id, Model model) {
        model.addAttribute("student", studentService.get(id));
        return "editstudent";
    }

    @PostMapping("/editstudent")
    public String editStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }
}
