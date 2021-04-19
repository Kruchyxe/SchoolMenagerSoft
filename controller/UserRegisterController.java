package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.schoolmenagersoft.service.UserService;
import pl.coderslab.schoolmenagersoft.web.dto.UserRegisterDto;

import javax.validation.Valid;

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
    public String registerUserAccount(@Valid @ModelAttribute("user") UserRegisterDto userRegisterDto , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration";
        }
        userService.save(userRegisterDto);
        return "redirect:/login";

    }



}
