package com.medic.MainApp.DAO;

import com.medic.MainApp.DataMapper.UserDataMapper;
import com.medic.MainApp.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);


    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql , new UserDataMapper());
    }

    public List getUserById(String id){
        String sql = "SELECT * FROM users WHERE id=?";
        return jdbcTemplate.query(sql, new String[]{id} , new UserDataMapper());
    }

    public void saveUser(User user){
       logger.info("UserDAO -> {}",user.getUser_id() ,user.getFirst_name(),user.getLast_name(),user.getGender(),user.getNic(),user.getEmail(),user.getRole());
        String sql = "INSERT INTO users (id , firstname , lastname , gender , nic , email ,role) VALUES (?,?,?,?,?,?,?)";
         jdbcTemplate.update(sql , user.getUser_id() ,user.getFirst_name(),user.getLast_name(),user.getGender(),user.getNic(),user.getEmail(),user.getRole());

    }

    public void updateUser(User user){
        logger.info("UserDAO--updateUser---> " , user.getUser_id() ,user.getFirst_name(),user.getLast_name(),user.getGender(),user.getNic(),user.getEmail(),user.getRole());
        String sql = "UPDATE users SET id=?,firstname=? , lastname=? , gender=? , nic=?, email=? ,role=? WHERE id=?";
        jdbcTemplate.update(sql, user.getUser_id() ,user.getFirst_name(),user.getLast_name(),user.getGender(),user.getNic(),user.getEmail(),user.getRole(),user.getUser_id());
    }

    public void deleteUser(String id){
        logger.info("UserDAO--deleteUser--> {}" ,id);
        String sql = "DELETE FROM users WHERE id=?";
        jdbcTemplate.update(sql ,id);
    }
}

