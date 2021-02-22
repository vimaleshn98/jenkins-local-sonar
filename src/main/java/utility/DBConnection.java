package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopmanagement?autoReconnect=true&useSSL=false","root","vi@7349216534");
			System.out.println(con);
		return con;
	}

	public boolean checkTable(Connection con, String string) {
		boolean tExists = false;
	    try (ResultSet rs = con.getMetaData().getTables(null, null, string, null)) {
	        while (rs.next()) { 
	            String tName = rs.getString("TABLE_NAME");
	            if (tName != null && tName.equals(string)) {
	                tExists = true;
	                break;
	            }
	        }
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	    return tExists;
	}

	public void closeConnection(Connection conn) {
		// TODO Auto-generated method stub
		try {
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeStatement(Statement st) {
		// TODO Auto-generated method stub
		try {
			if(st!=null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closePrepareStatement(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			if(preparedStatement!=null)
				preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
