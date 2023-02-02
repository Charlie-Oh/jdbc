package dbc2;
import java.sql.*;

public class Test {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String id="test";
			String pass="1111";
			String tname="TB_TEST";
			Connection conn=DriverManager.getConnection(url,id,pass);
			System.out.println("데이터베이스 연결 성공");
			
			System.out.println("1111");
			PreparedStatement ps;
			ResultSet rs=null;
			System.out.println("2222");
			String sql="select count(*) as cnt from USER_TABLES where "+
					"TABLE_NAME = ? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, tname);
			System.out.println("3333");
			rs=ps.executeQuery();
			
			int cnt=0;
			System.out.println("4444");
			while(rs.next()) {
				System.out.println("5555");
				cnt=rs.getInt("cnt");
			}
			if(cnt<=0) {
				sql="create table "+tname+" (test1 varchar2(10) PRIMARY KEY,"+
						"test2 number NOT NULL)";
				ps.executeUpdate(sql);
				System.out.println(sql+"문 실행 완료!");
				System.out.println("테이블 생성 OK");
			} else {
				System.out.println("테이블이 이미 생성되어 있습니다.");
			}
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
