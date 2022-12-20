package com.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public class LoginServiceRepositoryImpl implements LoginServiceRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void signUpUser(User user) {

		int rowCount = jdbcTemplate.update("Insert into user(email,password,dob) values(?,?,?)", user.getEmail(),
				user.getPassword(), user.getDob());
		System.out.println("Rows INserted " + rowCount);

	}

	@Override
	public User getUser(String email) {
		RowMapper<User> userRowMapper = (rs, row) -> {
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			return user;
		};
		List<User> users = jdbcTemplate.query("Select * from user where email = ?", userRowMapper, email);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}

}
