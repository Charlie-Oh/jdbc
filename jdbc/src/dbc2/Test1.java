package dbc2;
import java.sql.*;


public class Test1 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String id="test";
			String pass="1111";
			String tname="dept";
			String sql="insert into "+tname+"(deptno,dname,loc) values(50,'개발','서울')";
			Connection conn=DriverManager.getConnection(url,id,pass);

			PreparedStatement ps;
			ResultSet rs=null;
			
			ps=conn.prepareStatement(sql);

				ps.executeUpdate();
				System.out.println(sql+"문 실행 완료!");
				System.out.println("추가 OK");

			rs.close(); ps.close(); conn.close();
		} catch(ClassNotFoundException e) {
			System.out.println("예외 : 드라이버 로드 실패 "+e.getMessage());
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("예외 : "+e.getMessage());
			e.printStackTrace();
		}
	}
}