package com.rapideact.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.rapideact.model.entity.ItemDto;

public class ItemUpdDao {

	private static String dbURL = "jdbc:mariadb://localhost:3306/furuki";

	private static String user = "furuki";

	private static String password = "furuki";

	public ItemDto findItem(String id) {

		ItemDto selectedDto = new ItemDto();

		try {
			Class.forName(org.mariadb.jdbc.Driver.class.getName());

			String sql = "select * from im_item where item_id =" + id;

			try (Connection con = DriverManager.getConnection(dbURL, user, password);
					PreparedStatement pst = con.prepareStatement(sql);) {

				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					selectedDto.setId(rs.getInt("id"));
					selectedDto.setItem_id(rs.getString("item_id"));
					selectedDto.setItem_name(rs.getString("item_name"));
					selectedDto.setPrice(rs.getInt("price"));
					selectedDto.setRelease_date(rs.getDate("release_date"));
					selectedDto.setComment(rs.getString("comment"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return selectedDto;
	}

	public String updateItem(String item_id,
	String item_name,int price, Date release_date, String comment)throws SQLException{
		ItemDto oldItem = findItem(item_id);
		
		try {
			Class.forName(org.mariadb.jdbc.Driver.class.getName());
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		StringBuffer columns = new StringBuffer(255);
		
		if(item_id != null && item_id.equals(oldItem.getItem_id())) {
			columns.append("item_id = '" + item_id + "'");
		}
		if(item_name != null && item_name.equals(oldItem.getItem_name())) {
			if(columns.length() > 0) {
				columns.append(",");
			}
			columns.append("item_name = '" + item_name + "'");
		}
		
		if(String.valueOf(price) != null && String.valueOf(price).equals(oldItem.getPrice())) {
			if(columns.length() > 0) {
				columns.append(",");
			}
			columns.append("price = '" + price + "'");
		}
		
		if(release_date != null && release_date.equals(oldItem.getPrice())) {
			if(columns.length() > 0) {
				columns.append(",");
			}
			columns.append("release_date = '" + release_date + "'");
		}
		
		if(comment != null && comment.equals(oldItem.getPrice())) {
			if(columns.length() > 0) {
				columns.append(",");
			}
			columns.append("comment = '" + comment + "'");
		}
		
		

		if(columns.length() < 0) {
			String sqlString = "update im_item SET" + columns.toString() + "WHERE item_id = "+ item_id;
			System.out.println(sqlString);
			PreparedStatement pst = con.prepareStatement(sqlString);
            pst.executeQuery(sqlString);
			
			
					
		}else {
			
		}
		return "success";
	}

}
