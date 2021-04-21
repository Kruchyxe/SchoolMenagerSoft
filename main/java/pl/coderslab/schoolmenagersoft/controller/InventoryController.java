package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.schoolmenagersoft.service.InventoryService;
import pl.coderslab.schoolmenagersoft.web.dto.GroupDto;
import pl.coderslab.schoolmenagersoft.web.dto.InventoryDto;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/inventories")
public class InventoryController {

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping()
    public String inventoriesList(Model model){
        model.addAttribute("inventory", inventoryService.findAllInventories());
        return "inventories";
    }

    @GetMapping("/addinventory")
    public String showAddGroupForm(Model model){
        model.addAttribute("inventory", new InventoryDto());
        return "addinventory";
    }

    @PostMapping("/addinventory")
    public String addNewEmployee(@Valid @ModelAttribute("inventory") InventoryDto inventoryDto , BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addinventory";
        }
        inventoryService.addInventory(inventoryDto);
        return "redirect:/groups";
    }

    @GetMapping("/detailsinventory")
    public String showDetailForm(long id, Model model) {
        model.addAttribute("inventory", inventoryService.getInventory(id).orElseThrow(EntityNotFoundException::new));
        return "detailsinventory";
    }

    @GetMapping("/deleteinventory")
    public String deleteGroup(Long id){
        inventoryService.deleteInventoryById(id);
        return "redirect:/inventories";
    }
}
