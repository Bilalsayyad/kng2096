package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtility {
	public static void main(String[] args) {
		DBConnectionUtility db=new DBConnectionUtility();
		DBConnectionUtility.getConnection();
	}
DBConnectionUtility() {
	System.out.println("cons called.......");
}
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (Exception e) {
		System.out.println(e);
	}
}
private static ThreadLocal<Connection>tlocal=new ThreadLocal<>();
private static Connection con;

public static Connection getConnection()  {
	con=tlocal.get();
	if(con==null) {
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost/xyz","root","root");
		con.setAutoCommit(false);
		tlocal.set(con);
	} catch (SQLException e) {
	
		e.printStackTrace();
		return null;
	}
	}return con;
}
}
