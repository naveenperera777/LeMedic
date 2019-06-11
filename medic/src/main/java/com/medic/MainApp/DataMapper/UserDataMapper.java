package com.medic.MainApp.DataMapper;
import com.medic.MainApp.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataMapper implements RowMapper<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserDataMapper.class);

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        logger.info("userdatamapper {}" , resultSet.toString());

        User user = new User();
        user.setUser_id(resultSet.getString("id"));
        user.setFirst_name(resultSet.getString("firstname"));
        user.setLast_name(resultSet.getString("lastname"));
        user.setGender(resultSet.getString("gender"));
//        user.setDob(resultSet.getDate("dob"));
        user.setNic(resultSet.getString("nic"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(resultSet.getString("role"));
        return user;
    }
}
