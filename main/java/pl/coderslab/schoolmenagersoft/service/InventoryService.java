package pl.coderslab.schoolmenagersoft.service;

import pl.coderslab.schoolmenagersoft.model.Group;
import pl.coderslab.schoolmenagersoft.model.Inventory;
import pl.coderslab.schoolmenagersoft.web.dto.GroupDto;
import pl.coderslab.schoolmenagersoft.web.dto.InventoryDto;

import java.util.List;
import java.util.Optional;

public interface InventoryService {

    Inventory addInventory(InventoryDto inventoryDto);

    List<InventoryDto> findAllInventories();

    Optional<Inventory> getInventory(Long id);

    void deleteInventoryById(Long id);

    void updateInventory(Inventory inventory);
}
