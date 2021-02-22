package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private int id;
	private String name;
	private String mobilenum;
	private java.sql.Date shopingdate;
	private int total;
	List<Item> items = new ArrayList<Item>();
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getTotal() {
		return total;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	List<Item> item = new ArrayList<Item>();
	public Customer() {
	
    }

	public Customer(int id, String name, String mobilenum) {
		super();
		this.id = id;
		this.name = name;
		this.mobilenum = mobilenum;
	}

	public Customer(int id, String name, String mobilenum, List<Item> ls) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.name = name;
		this.mobilenum = mobilenum;
		this.item =ls;
	}

	public Customer(int custId, List<Item> ls) {
		// TODO Auto-generated constructor stub
		this.id =custId;
		this.item=ls;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMobilenum() {
		return mobilenum;
	}

	public java.sql.Date getShopingdate() {
		return shopingdate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	public void setShopingdate(java.sql.Date shopingdate) {
		this.shopingdate = shopingdate;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, mobilenum=%s, shopingdate=%s]", id, name, mobilenum,
				shopingdate);
	}
	
}

