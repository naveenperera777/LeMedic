package com.medic.MainApp.Services;

import com.medic.MainApp.DAO.UserDAO;
import com.medic.MainApp.Models.User;
import com.medic.MainApp.Response.MedicResponse;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {


    private final UserDAO userDAO;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers(){

        return userDAO.getAllUsers();
    }

    public List getUserById(String id){
        return userDAO.getUserById(id);
    }

    public void saveUser(User user){
        logger.info("saveusers -service {}" ,user.getUser_id());
        userDAO.saveUser(user);
    }

    public void updateUser(User user){
        logger.info("Service--updateUsers--> ",user);
        userDAO.updateUser(user);
    }

    public void deleteUser(String id){
        logger.info("Service--deleteUser-->{}",id);
        userDAO.deleteUser(id);
    }

    public String getme(MedicResponse str){
        return "new";
    }






}
