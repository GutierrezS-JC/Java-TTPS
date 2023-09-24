package ttps.clasesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class MySQLAccess {
	
	private static boolean initialized = false;
	
	private static void initialize () throws SQLException {
		if(!initialized) {
			DriverManager.registerDriver(new Driver());
			initialized = true;
		}
	}
	
	
	public static Connection getDBConnection () throws ClassNotFoundException, SQLException {
		Connection connect = null;
		initialize();
		
	    try {
	    	String usr = "root";
	    	String pass = "935root935";
	    	connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", usr, pass);	    	
	    } catch (SQLException ex) {
	        // handle any errors
	        System.out.println(ex);
	    }
		return connect;
	}
}
