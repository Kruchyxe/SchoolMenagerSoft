package pl.coderslab.schoolmenagersoft.service;

import pl.coderslab.schoolmenagersoft.model.Employee;
import pl.coderslab.schoolmenagersoft.model.Student;
import pl.coderslab.schoolmenagersoft.web.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee addEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> findAllEmployees();

    Optional<Employee> getEmployee(Long id);

    void deleteEmployeeById(Long id);

    void updateEmployee(Employee employee);
}
