package com.rapideact.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rapideact.model.entity.UserDto;

public class UserDao {

	private static String dbURL = "jdbc:mariadb://localhost:3306/furuki";

	private static String user = "furuki";

	private static String password = "furuki";

	public UserDto findUser(String id, String pass) {
		UserDto imUser = new UserDto();

		try {
			Class.forName(org.mariadb.jdbc.Driver.class.getName());

			String sql = "select * from im_user where user_id = ? and password = ?";

			try (Connection con = DriverManager.getConnection(dbURL, user, password);
					PreparedStatement pst = con.prepareStatement(sql);) {

				pst.setString(1, id);
				pst.setString(2, pass);

				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					imUser = new UserDto(rs.getString("user_id"), rs.getString("user_name"), rs.getString("password"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return imUser;

	}
	
	
	

}
