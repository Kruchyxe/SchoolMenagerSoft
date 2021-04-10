package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.schoolmenagersoft.service.UserService;
import pl.coderslab.schoolmenagersoft.web.dto.UserRegisterDto;

@Controller
@RequestMapping("/registration")
public class UserRegisterController {

    private UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }

    @GetMapping()
    public String showRegisterForm(){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegisterDto userRegisterDto){
        userService.save(userRegisterDto);
        return "redirect:/registration?success";

    }



}
