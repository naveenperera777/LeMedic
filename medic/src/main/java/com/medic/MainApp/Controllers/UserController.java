package com.medic.MainApp.Controllers;
import com.medic.MainApp.Models.User;
import com.medic.MainApp.Response.MedicResponse;
import com.medic.MainApp.Services.UserService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;

@RestController
public class UserController extends ResponseUtils {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService ){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(){
        List users = userService.getAllUsers();
        logger.info("users {}" ,users);
        if (!users.isEmpty()) {
            return successRetrieval(users);
        }
        return FailedRetrieval(users);
    }


}
