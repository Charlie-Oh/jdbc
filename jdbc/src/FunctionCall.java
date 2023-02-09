import java.sql.*;

public class FunctionCall {
	public static void main(String[] args) {
		try {
			// 데이터베이스 드라이버를 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection 객체 생성
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe", "test", "1111");
			CallableStatement cstmt = con.prepareCall("{?=call TEST_FUNC(?)}");
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, "TURNER");
			// ?에 값 바인딩
			cstmt.execute();
			System.out.println(cstmt.getString(1));

			// 다 사용한 객체 닫기
			cstmt.close();
			
			PreparedStatement ps=con.prepareStatement("select test_func(?) from dual");
			ps.setString(1, "TURNER");
			ResultSet rs=ps.executeQuery();
			rs.next();
			System.out.println(rs.getString(1));
			rs.close();
			ps.close();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
