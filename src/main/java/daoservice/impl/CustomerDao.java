package daoservice.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daoservice.CustomerDaoInterface;
import entity.Customer;
import entity.Item;
import exceptions.DaoException.DataNotFoundException;
import exceptions.DaoException.DatabaseConnectivityException;
import service.GetDetailInterface;
import service.impl.GetDetails;
import utility.DBConnection;

public class CustomerDao implements CustomerDaoInterface {

	public boolean addToCustomerDatabase(Customer customer) throws DatabaseConnectivityException {
		DBConnection db = new DBConnection();
		Connection conn  =null;
		Statement st =null;
		PreparedStatement preparedStatement =null;
			 try {
				conn = db.getConnection();
				String sql = "insert into Customer values(?,?,?)";
				preparedStatement = conn.prepareStatement(sql);
				preparedStatement.setInt(1, customer.getId());
				preparedStatement.setString(2, customer.getName());
				preparedStatement.setString(3, customer.getMobilenum());
//				preparedStatement.setDate(4, customer.getShopingdate());
//				preparedStatement.setInt(5, customer.getTotal());
				int i = preparedStatement.executeUpdate();
				if(i>0) {
					return true;
				}else
					return false;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new  DatabaseConnectivityException("DB not conneted");
			}
			 finally {
				db.closeConnection(conn);
				db.closeStatement(st);
				db.closePrepareStatement(preparedStatement);
			}
	}

	@Override
	public Customer getCustomerByID(int id) throws DataNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Customer getCustomerByID(int id) throws DataNotFoundException {
//		// TODO Auto-generated method stub
//		DBConnection db = new DBConnection();
//		Connection conn  =null;
//		Statement st =null;
//		ResultSet rs = null;
//		try {
//			conn =db.getConnection();
//			st =conn.createStatement();
//			rs = st.executeQuery("select * from customer where id = "+id);
//			rs.next();
//			GetDetailInterface intf =new GetDetails();
////			List<Item> ls = intf.getItemDetails();
////			return new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("phone"),ls);
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new  DataNotFoundException("ID Not Found");
//		}
//		finally {
//			db.closeConnection(conn);
//			db.closeStatement(st);
//		}
//	}
	
}
