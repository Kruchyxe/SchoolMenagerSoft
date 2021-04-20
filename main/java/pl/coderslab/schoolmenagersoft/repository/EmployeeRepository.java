package pl.coderslab.schoolmenagersoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.schoolmenagersoft.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
