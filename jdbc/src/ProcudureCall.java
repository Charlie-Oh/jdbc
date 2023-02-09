import java.sql.*;

public class ProcudureCall {

	public static void main(String[] args) {
		try {
			// 데이터베이스 드라이버를 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection 객체 생성
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe", "test", "1111");
			// 프로시저를 실행할 수 있는 Statement 객체 생성
			CallableStatement cstmt = con.prepareCall("{call res()}");
			// 프로시저 실행
			cstmt.executeQuery();
			// 다 사용한 객체 닫기
			cstmt.close();
			con.close();
			System.out.println("프로시저 호출 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
