package dbc4;
import java.sql.*;

public class MemberInsert2 {
	public static void main(String[] args) {
		try {
			Connection conn=DBConnec1.getConnection();
			String userid="tiger";
			String pwd="1111";
			String email="tiger@java.com";
			String hp="010-1111-3333";
			
			//String클래스의 format메소드를 사용하여 보기좋게 작성
			String sql=String.format("INSERT INTO TB_MEMBER(M_SEQ,M_USERID,"
					+ "M_PWD,M_EMAIL,M_HP) "
					+ "VALUES(SEQ_TB_MEMBER.NEXTVAL,'%S','%S','%S','%S')",
					userid,pwd,email,hp);
			
			Statement stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			System.out.println(count+"개 행 입력");
			stmt.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				DBConnec1.close();
			} catch(SQLException e) {
			}
		}
	}
}
