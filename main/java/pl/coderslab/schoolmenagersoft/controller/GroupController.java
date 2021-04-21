package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.schoolmenagersoft.model.Employee;
import pl.coderslab.schoolmenagersoft.model.Group;
import pl.coderslab.schoolmenagersoft.service.GroupService;
import pl.coderslab.schoolmenagersoft.web.dto.EmployeeDto;
import pl.coderslab.schoolmenagersoft.web.dto.GroupDto;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping()
    public String employeesList(Model model){
        model.addAttribute("group", groupService.findAllGroups());
        return "groups";
    }

    @GetMapping("/addgroup")
    public String showAddGroupForm(Model model){
        model.addAttribute("group", new GroupDto());
        return "addgroup";
    }

    @PostMapping("/addgroup")
    public String addNewEmployee(@Valid @ModelAttribute("group") GroupDto groupDto , BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addgroup";
        }
        groupService.addGroup(groupDto);
        return "redirect:/groups";
    }

    @GetMapping("/deletegroup")
    public String deleteGroup(Long id){
        groupService.deleteGroupById(id);
        return "redirect:/groups";
    }

    @GetMapping("/detailsgroup")
    public String showDetailForm(long id, Model model) {
        model.addAttribute("group", groupService.getGroup(id).orElseThrow(EntityNotFoundException::new));
        return "detailsgroup";
    }

    @GetMapping("/editgroup")
    public String showEditEmployeeForm(long id, Model model) {
        model.addAttribute("group", groupService.getGroup(id));
        return "editgroup";
    }

    @PostMapping("/editgroup")
    public String editEmployee(@Valid Group group, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "editgroup";
        }
        groupService.updateGroup(group);
        return "redirect:/groups";
    }
}
