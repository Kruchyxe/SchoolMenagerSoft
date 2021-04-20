package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.schoolmenagersoft.model.Employee;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.service.EmployeeService;
import pl.coderslab.schoolmenagersoft.web.dto.EmployeeDto;
import pl.coderslab.schoolmenagersoft.web.dto.StudentDto;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String employeesList(Model model){
        model.addAttribute("employee", employeeService.findAllEmployees());
        return "employees";
    }

    @GetMapping("/addemployee")
    public String showAddEmployeeForm(Model model){
        model.addAttribute("employee", new EmployeeDto());
        return "addemployee";
    }

    @PostMapping("/addemployee")
    public String addNewEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto , BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addemployee";
        }
        employeeService.addEmployee(employeeDto);
        return "redirect:/employees";
    }

    @GetMapping("/deleteemployee")
    public String deleteEmployee(Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @GetMapping("/detailsemployee")
    public String showDetailForm(long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id).orElseThrow(EntityNotFoundException::new));
        return "detailsemployee";
    }

    @GetMapping("/editemployee")
    public String showEditEmployeeForm(long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "editemployee";
    }

    @PostMapping("/editemployee")
    public String editEmployee(@Valid Employee employee, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "editemployee";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }


}
