package daoservice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mysql.jdbc.Util;

import daoservice.ItemDaoInterface;
import daoservice.PurchaseDao;
import entity.Customer;
import entity.Item;
import exceptions.DaoException.CustomerDaoException;
import exceptions.DaoException.ItemDaoAlreadyExistsException;
import exceptions.DaoException.ItemDaoException;
import exceptions.DaoException.PurchasingDaoException;
import utility.DBConnection;

public class PurchaseInfoDao implements PurchaseDao {
	Scanner scanner = new Scanner(System.in);
	DBConnection db = new DBConnection();
	@Override
	public Customer getPurchaseDetails() throws ItemDaoException, CustomerDaoException {
		// TODO Auto-generated method stub
		int custId = getCustomerId();
		System.out.println("Enter the no of item Purchase");
		int num= scanner.nextInt();
		List<Item> ls = new ArrayList<Item>();
		for (int i = 0; i < num; i++) {
			System.out.println("Enter the details related to item"+(i+1));
			int itemId = getItemId();
			int quntity = getQuantity(itemId);
			float totalPrice = getTotal(quntity,getPrice(itemId));
			Item it = new Item(itemId,quntity,totalPrice);
			ls.add(it);
		}
		return new Customer(custId,ls);
		
		
	}

	private float getTotal(int quntity, float price) {
		// TODO Auto-generated method stub
		return quntity*price;
	}

	private float getPrice(int itemId) throws ItemDaoException {
		// TODO Auto-generated method stub
		ItemDaoInterface interface1 = new Itemdao();
		Connection conn  =null;
		Statement st =null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			rs= st.executeQuery("select priceperitem from items where itemid = "+itemId);
			rs.next();
			return rs.getInt("priceperitem");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
	}

	private int getQuantity(int itemId) throws ItemDaoException {
		// TODO Auto-generated method stub
		ItemDaoInterface interface1 = new Itemdao();
		System.out.println("Enter the quantity required ");
		int quantity= scanner.nextInt();
		Connection conn  =null;
		Statement st =null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			rs= st.executeQuery("select totalquantity from items where itemid = "+itemId);
			rs.next();
			if(rs.getInt("totalquantity")>=quantity) {
				interface1.updateQuantity((rs.getInt("totalquantity")-quantity),itemId);
				return quantity;
			}else {
				throw new ItemDaoException("Quantity less the request");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
	}

	private int getItemId() throws ItemDaoException {
		// TODO Auto-generated method stub
		System.out.println("enter the id of item");
		int id = scanner.nextInt();
		Connection conn  =null;
		Statement st =null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			rs= st.executeQuery("select * from items where itemid = "+id);
			rs.next();
			return id;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
	}

	private int getCustomerId() throws CustomerDaoException {
		// TODO Auto-generated method stub
		System.out.println("enter the id of customer");
		int id = scanner.nextInt();
		Connection conn  =null;
		Statement st =null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			rs= st.executeQuery("select * from Customer where id = "+id);
			rs.next();
			return id;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CustomerDaoException("customer not found");
		}
	}

	@Override
	public boolean addTOPurchaseInfo(Customer c) throws PurchasingDaoException {
		// TODO Auto-generated method stub
		Connection conn  =null;
		Statement st =null;
//		PreparedStatement preparedStatement =null;
			 try {
				conn = db.getConnection();
				String sql = "insert into purchaseinfo values(?,?,?,?,?)";
				Iterator<Item> ci = c.getItem().iterator();
				while (ci.hasNext()) {
					Item c2 = ci.next();
					PreparedStatement preparedStatement = conn.prepareStatement(sql);
					preparedStatement.setInt(1, c2.getId());
					preparedStatement.setInt(2, c.getId());
					preparedStatement.setFloat(3, c2.getTotalprice());
					preparedStatement.setInt(4, c2.getQuantity());
					java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					preparedStatement.setDate(5, date);
					int i = preparedStatement.executeUpdate();
					db.closePrepareStatement(preparedStatement);
					
				}
			}catch (SQLIntegrityConstraintViolationException e) {
				// TODO: handle exception
				 e.printStackTrace();
					throw new PurchasingDaoException("Item/ customer not in database");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new PurchasingDaoException("Item info database not inserted");
			}
			return false;
	}

	@Override
	public void getShopingReport() throws ItemDaoException {
		// TODO Auto-generated method stub

		System.out.println("Shoping reports are: ");
		Connection conn  =null;
		Statement st =null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			rs= st.executeQuery("select * from purchaseinfo");
			float total =0;
			while(rs.next()) {
				System.out.println(" Customer id "+rs.getInt("custid") +" item id "+rs.getInt("itemid")+" quantity "+rs.getInt("quantitytaken")+" price "+rs.getFloat("totalprice")+" date of shoping "+rs.getDate("date"));
				total+=rs.getFloat("totalprice");
			}
			System.out.println("total purchasing price :"+ total);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
		
	}

}
