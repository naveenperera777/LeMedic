package com.medic.MainApp.Services;

import com.medic.MainApp.DAO.UserDAO;
import com.medic.MainApp.Models.User;
import com.medic.MainApp.Response.MedicResponse;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers(){

        return userDAO.getAllUsers();
    }

    public String getme(MedicResponse str){
        return "new";
    }






}
