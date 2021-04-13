package pl.coderslab.schoolmenagersoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.schoolmenagersoft.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
