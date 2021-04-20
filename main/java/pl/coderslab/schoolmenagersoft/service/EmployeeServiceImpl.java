package pl.coderslab.schoolmenagersoft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.coderslab.schoolmenagersoft.model.Employee;
import pl.coderslab.schoolmenagersoft.repository.EmployeeRepository;
import pl.coderslab.schoolmenagersoft.web.dto.EmployeeDto;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getFirstName(), employeeDto.getLastName(),
                employeeDto.getPesel(), employeeDto.getMobile(), employeeDto.getEmail(),
                employeeDto.getHireDate(), employeeDto.getTerminationOfEmployment());
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDto = StreamSupport
                .stream(employees.spliterator(), false)
                .map(employee -> {
                    EmployeeDto dto = new EmployeeDto();
                    BeanUtils.copyProperties(employee, dto);
                    return dto;
                })
                .collect(Collectors.toList());
        return employeeDto;
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);

    }
}
