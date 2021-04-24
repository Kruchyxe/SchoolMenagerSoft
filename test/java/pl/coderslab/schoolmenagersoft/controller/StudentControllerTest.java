package pl.coderslab.schoolmenagersoft.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;
import pl.coderslab.schoolmenagersoft.service.StudentService;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @Mock
    StudentService studentService;

    @Mock
    Model model;

    StudentController studentController;

    @BeforeEach
    void setUp() {

    }

    @Test
    void studentList() {
    }

    @Test
    void showAddStudentForm() {
    }

    @Test
    void addNewStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void showDetailForm() {
    }

    @Test
    void showEditForm() {
    }

    @Test
    void editStudent() {
    }
}