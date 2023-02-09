package dbc4;
import java.sql.*;

public class MemberList3 {
	public static void main(String[] args) {
		try {
			Connection conn=DBConnec1.getConnection();
			String sql="SELECT M_SEQ,M_USERID,M_PWD,M_EMAIL,M_HP,M_REGISTDATE,"
					+ "M_POINT FROM TB_MEMBER ORDER BY M_SEQ DESC";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			System.out.println("번호\t아이디\t비밀번호\t이메일\t\t핸드폰번호\t\t가입일자"
					+ "\t\t\t포인트");
			while(rs.next()) {
				for(int i=1; i<=7; i++)
					System.out.println(rs.getString(i)+"\t");
				System.out.println();
			}
			rs.close();
			stmt.close();
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			try {
				DBConnec1.close();
			}catch(SQLException e) {
			}
		}
	}
}