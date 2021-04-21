package pl.coderslab.schoolmenagersoft.service;

import pl.coderslab.schoolmenagersoft.model.Group;
import pl.coderslab.schoolmenagersoft.model.Inventory;
import pl.coderslab.schoolmenagersoft.repository.InventoryRepository;
import pl.coderslab.schoolmenagersoft.web.dto.InventoryDto;

import java.util.List;
import java.util.Optional;

public class InventoryServiceImpl implements InventoryService{

    private InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    @Override
    public Group addInventory(InventoryDto inventoryDto) {
        return null;
    }

    @Override
    public List<InventoryDto> findAllInventories() {
        return null;
    }

    @Override
    public Optional<Inventory> getInventory(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteInventoryById(Long id) {

    }

    @Override
    public void updateInventory(Inventory inventory) {

    }
}
