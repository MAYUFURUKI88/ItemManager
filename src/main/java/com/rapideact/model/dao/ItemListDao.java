package com.rapideact.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rapideact.model.entity.ItemDto;

public class ItemListDao {

	private static String dbURL = "jdbc:mariadb://localhost:3306/furuki";

	private static String user = "furuki";

	private static String password = "furuki";

	public ArrayList<ItemDto> getItemList() {
		ArrayList<ItemDto> list = new ArrayList<ItemDto>();

		try {
			Class.forName(org.mariadb.jdbc.Driver.class.getName());

			String sql = "select * from im_item";

			try (Connection con = DriverManager.getConnection(dbURL, user, password);
					PreparedStatement pst = con.prepareStatement(sql);) {

				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					ItemDto itemd = new ItemDto();
					itemd.setId(rs.getInt("id"));
					itemd.setItem_id(rs.getString("item_id"));
					itemd.setItem_name(rs.getString("item_name"));
					itemd.setPrice(rs.getInt("price"));
					itemd.setRelease_date(rs.getDate("release_date"));
					itemd.setComment(rs.getString("comment"));
					list.add(itemd);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}
