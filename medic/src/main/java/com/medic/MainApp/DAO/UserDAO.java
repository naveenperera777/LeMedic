package com.medic.MainApp.DAO;

import com.medic.MainApp.DataMapper.UserDataMapper;
import com.medic.MainApp.Models.User;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {

            String sql = "SELECT * FROM users";
            return jdbcTemplate.query(sql , new UserDataMapper());




    }
}

