package daoservice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import daoservice.ItemDaoInterface;
import entity.Item;
import exceptions.DaoException.DatabaseConnectivityException;
import exceptions.DaoException.ItemDaoAlreadyExistsException;
import exceptions.DaoException.ItemDaoException;
import utility.DBConnection;

public class Itemdao  implements ItemDaoInterface{
	Scanner scanner = new Scanner(System.in);
	DBConnection db = new DBConnection();
	@Override
	public boolean addToItemDaoToDatabase(Item it) throws ItemDaoAlreadyExistsException {
		// TODO Auto-generated method stub
		Connection conn  =null;
		Statement st =null;
		PreparedStatement preparedStatement =null;
			 try {
				conn = db.getConnection();
				String sql = "insert into Items values(?,?,?,?)";
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, it.getId());
				preparedStatement.setString(2, it.getName());
				preparedStatement.setFloat(3, it.getPrice());
				preparedStatement.setInt(4, it.getQuantity());
				int i = preparedStatement.executeUpdate();
				if(i>0) {
					return true;
				}else
					return false;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ItemDaoAlreadyExistsException("Item code already");
			}
	}

	@Override
	public Item getItemDatabase() throws ItemDaoException {
		// TODO Auto-generated method stub
		Connection conn  =null;
		Statement st =null;
		ResultSet rs = null;
		System.out.println("Enter the item id");
		int id = scanner.nextInt();
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			rs= st.executeQuery("select * from items where itemid="+id);
			rs.next();
			return new Item(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
	}

	@Override
	public boolean UpadateItemDatabase(Item itemup) throws ItemDaoException {
		// TODO Auto-generated method stub
		Connection conn  =null;
		Statement st =null;
		System.out.println("enter the new quantity");
		int quantity = scanner.nextInt();
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			System.out.println("Update items set totalquantity="+quantity+" where itemid ="+itemup.getId()+";");
			int temp= st.executeUpdate("Update items set totalquantity="+quantity+" where itemid="+itemup.getId());
			if(temp>0) {
				return true;
			}else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
	}

	@Override
	public boolean deletedItemDatabase(Item itemup) throws ItemDaoException {
		Connection conn  =null;
		Statement st =null;
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			System.out.println("delete from items where itemid = "+itemup.getId()+";");
			int temp= st.executeUpdate("delete from items where itemid = "+itemup.getId());
			if(temp>0) {
				return true;
			}else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
	}

	@Override
	public boolean updateQuantity(int i, int itemId) throws ItemDaoException {
		// TODO Auto-generated method stub
		Connection conn  =null;
		Statement st =null;
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			System.out.println("Update items set totalquantity="+i+" where itemid ="+itemId+";");
			int temp= st.executeUpdate("Update items set totalquantity="+i+" where itemid="+itemId);
			if(temp>0) {
				return true;
			}else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
	}

	@Override
	public void display() throws ItemDaoException {
		// TODO Auto-generated method stub
		System.out.println("Shoping reports are: ");
		Connection conn  =null;
		Statement st =null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			st= conn.createStatement();
			rs= st.executeQuery("select * from items");
			while(rs.next()) {
				System.out.println(" item id "+rs.getInt("itemid")+" name of item "+rs.getString("name")+" price of item "+rs.getFloat("priceperitem")+" total quantity left "+rs.getInt("totalquantity"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ItemDaoException("Item not found");
		}
	}

	

}
