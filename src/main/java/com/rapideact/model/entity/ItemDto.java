package com.rapideact.model.entity;

import java.io.Serializable;
import java.util.Date;

public class ItemDto implements Serializable {
	
	private int id;
	private String item_id;
	private String item_name;
	private int price;
	private Date release_date;
	private String comment;
	
	public ItemDto() {
		
	}
	
	public ItemDto(int id, String item_id, String item_name, int price, Date release_date, String comment) {
		this.id = id;
		this.item_id = item_id;
		this.item_name = item_name;
		this.price = price;
		this.release_date = release_date;
		this.comment = comment;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
