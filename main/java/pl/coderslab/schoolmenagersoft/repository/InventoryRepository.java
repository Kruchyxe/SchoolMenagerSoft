package pl.coderslab.schoolmenagersoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.schoolmenagersoft.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
