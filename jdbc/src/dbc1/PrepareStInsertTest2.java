package dbc1;
import java.sql.*;

public class PrepareStInsertTest2 {
	private Connection con;
	private PreparedStatement ps;
	
	public PrepareStInsertTest2(int empno,String ename,double sal) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			User user=new User();
			Connection con=DriverManager.getConnection(user.getUrl(),
					user.getUser(),user.getPwd());
			System.out.println("DB 연결 성공");
			
			String sql="update emp set ename=?,sal=? where empno=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,ename);
			ps.setDouble(2,sal);
			ps.setInt(3,empno);
			int result=ps.executeUpdate();
			System.out.println("처리된 레코드 개수: "+result);
			ps.close(); con.close();
		} catch(ClassNotFoundException e) {
			System.out.println(e+"=> 드라이버 로드 실패");
		} catch(SQLException e) {
			System.out.println(e+"=> Sql 예외 ");
		} catch(Exception e) {
			System.out.println(e+"=> 일반 예외");
		}
	}
		public static void main(String[] args) {
			new PrepareStInsertTest2(1,"JavaPris",500);
	}
}
