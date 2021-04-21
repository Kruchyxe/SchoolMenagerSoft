package pl.coderslab.schoolmenagersoft.service;

import org.springframework.beans.BeanUtils;
import pl.coderslab.schoolmenagersoft.model.Inventory;
import pl.coderslab.schoolmenagersoft.repository.InventoryRepository;
import pl.coderslab.schoolmenagersoft.web.dto.InventoryDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    @Override
    public Inventory addInventory(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory(inventoryDto.getInventoryType(), inventoryDto.getMerchandiseNumber(),
                inventoryDto.getQuantity(), inventoryDto.getInvoiceNumber(), inventoryDto.getPurchaseDate(),
                inventoryDto.getPrice(), inventoryDto.getAssigmentToPerson(), inventoryDto.getAssigmentToClass(),
                inventoryDto.getMerchandiseLiquidationDate(), inventoryDto.getMethodOfGoodsDisposal(),
                inventoryDto.getPersonResponsibleForLiquidation());
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<InventoryDto> findAllInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();
        List<InventoryDto> inventoryDto = StreamSupport
                .stream(inventories.spliterator(), false)
                .map(inventory -> {
                    InventoryDto dto = new InventoryDto();
                    BeanUtils.copyProperties(inventory, dto);
                    return dto;
                })
                .collect(Collectors.toList());
        return inventoryDto;
    }

    @Override
    public Optional<Inventory> getInventory(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public void deleteInventoryById(Long id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }
}
