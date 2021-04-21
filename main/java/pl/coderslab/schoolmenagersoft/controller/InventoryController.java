package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.schoolmenagersoft.service.InventoryService;

@Controller
@RequestMapping("/inventories")
public class InventoryController {

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping()
    public String employeesList(Model model){
        model.addAttribute("inventory", inventoryService.findAllInventories());
        return "inventories";
    }
}
