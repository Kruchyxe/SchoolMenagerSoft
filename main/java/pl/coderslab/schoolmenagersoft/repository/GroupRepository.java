package pl.coderslab.schoolmenagersoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.schoolmenagersoft.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
