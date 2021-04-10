package pl.coderslab.schoolmenagersoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    public String registerUserAccount(@ModelAttribute("user")UserRegisterDto userRegisterDto){
        userService.save(userRegisterDto);
        return "redirect:/registration?success";

    }
}
