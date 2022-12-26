package com.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.User;
import com.utils.HashAndSaltGenerator;

@Repository
public class LoginServiceRepositoryImpl implements LoginServiceRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
    
	@Autowired
	HashAndSaltGenerator hashAndSaltGenerator;

	@Override
	public User getUser(String email) {
		RowMapper<User> userRowMapper = (rs, row) -> {
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
			return user;
		};
		List<User> users = jdbcTemplate.query("Select * from user where email = ?", userRowMapper, email);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public void signUpUser(String email, String password, String dob) throws Exception {
		String[] saltAndHashStringsArr = hashAndSaltGenerator.getHexAndSaltStrings(password);
		jdbcTemplate.update("Insert into user(email,hashString,dob,saltString) values(?,?,?,?)", email,
				saltAndHashStringsArr[1], dob, saltAndHashStringsArr[0]);

	}

}
