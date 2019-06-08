package com.medic.MainApp.Controllers;
import com.medic.MainApp.Models.User;
import com.medic.MainApp.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return users;
    }


}
