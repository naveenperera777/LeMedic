package com.medic.MainApp.Controllers;
import com.medic.MainApp.DTO.Login;
import com.medic.MainApp.Models.User;
import com.medic.MainApp.Services.UserService;
import com.medic.MainApp.Utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController extends ResponseUtils {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService ){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Login login){
        List user = userService.login(login);
        if (user.isEmpty()){
            return FailedRetrieval(user);
        }
        return successRetrieval(user);
    }

    @PostMapping("/login/reset")
    public void resetPassword(@RequestBody Login login){
       userService.resetPassword(login);
    }

    //Get details of all users
    @GetMapping("/users")
    public ResponseEntity getAllUsers(){
        List users = userService.getAllUsers();
        logger.info("users {}" ,users);
        if (!users.isEmpty()) {
            ResponseEntity responseEntity = successRetrieval(users);
            return responseEntity;
        }
        return unauthorized(users);
    }

    //Get details of a user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity getUserById(@PathVariable String id){
        List user = userService.getUserById(id);
        logger.info("user {}" , user);
        if (user != null){
            ResponseEntity responseEntity = successRetrieval(user);
            return responseEntity;
        }
        return FailedRetrieval(user);
    }

    //Save a user in the Database
    @PostMapping("/users/add")
    public void saveUser(@RequestBody User user){
        logger.info("userSave----->", user);
        userService.saveUser(user);
}

    //Update a user in the Database
    @PutMapping("/users/update/{id}")
    public void updateUser(@RequestBody User user, @PathVariable String id){
       // logger.info("UserController--UpdateUser---->" , user);
        userService.updateUser(user);
    }

    //Delete a user in the Database
    @DeleteMapping("users/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        logger.info("UserController--DeleteUser {}", id);
        List user = userService.getUserById(id);
        logger.info("UserController--DeleteUserObject---> {}", user);
        if (!user.isEmpty()) {
            userService.deleteUser(id);
            return successDelete();
          }
        return userNotFound(id);

    }


}
