package dbc4;
import java.sql.*;

public class DBConnec1 {
	private static Connection connec;
	private DBConnec1() {}
	public static Connection getConnection() throws ClassNotFoundException,
	SQLException{
		if(connec==null) {//dbConn이 null이면 Connection 객체 생성
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="test";
			String pw="1111";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connec=DriverManager.getConnection(url,user,pw);
		}
		return connec;
	}
	
	//DB연결 해제(닫기)
	public static void close() throws SQLException{
		if(connec!=null) {
			if(!connec.isClosed()) {
				connec.close();
			}
		}
	}
}