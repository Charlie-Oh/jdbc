package dbc4;
import java.sql.*;

public class MemberInsertPstmt4 {
	public static void main(String[] args) {
		try {
			Connection conn=DBConnec1.getConnection();
			String userid="orange";
			String pwd="3333";
			String email="orange@sun.com";
			String hp="010-3333-4444";
			
			String sql="INSERT INTO TB_MEMBER(M_SEQ,M_USERID,"
					+ "M_PWD,M_EMAIL,M_HP) "
					+ "VALUES(SEQ_TB_MEMBER.NEXTVAL,:userid,:pwd,:email,:hp)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, pwd);
			pstmt.setString(3, email);
			pstmt.setString(4, hp);
			int count=pstmt.executeUpdate();
			System.out.println(count+"개 행 입력");
			pstmt.close();
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
