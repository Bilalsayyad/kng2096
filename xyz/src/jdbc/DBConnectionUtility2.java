
package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
public class DBConnectionUtility2 {
	public static void main(String[] args) {
		DBConnectionUtility2 db=new DBConnectionUtility2();
		 DBConnectionUtility2.getConnection();

	}
	private DBConnectionUtility2() {
		System.out.println("cons called.......");

	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	private static ThreadLocal<Connection> tLocal=new ThreadLocal<>();
	private static Connection con;
	synchronized public static Connection getConnection() {
		con=tLocal.get();
		if(con==null) {
			try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/knight","root","root");
			con.setAutoCommit(false);
			tLocal.set(con);
			}catch(Exception e) {
				System.out.println(e);
				
				return null;
			}
		}
		return con;
	}
	synchronized public static void closeConnection(Exception ex,Savepoint sp) {
		con=tLocal.get();
		if(con!=null) {
			try {
				if(ex==null) {
					con.commit();
				}
				else {
					if(sp==null) {
						con.rollback();
					}
					else {
						con.rollback(sp);
						con.commit();
					}
				}
			}catch(Exception e) {
				
				
			}
		}
		tLocal.remove();
	}
}

