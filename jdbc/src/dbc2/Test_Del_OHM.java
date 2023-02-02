package dbc2;
import java.sql.*;

/*삭제
PreparedStatement객체 사용
테이블명:DEPT
부서번호가 50인 데이터 삭제
*/
public class Test_Del_OHM {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="TEST";
		String pwd="1111";
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pwd);
			String sql="DELETE FROM DEPT WHERE DEPTNO=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,50);
			int rowcnt=ps.executeUpdate();
			if(rowcnt>=1) {
				System.out.println(rowcnt+"개 행이 정상적으로 삭제가 확정되었습니다.");
			}else {
				System.err.println("삭제할 사항이 없습니다.");
			}
		} catch(ClassNotFoundException e) {
			System.err.println("ClassNotFoundException : 변경에 실패하였습니다. \n 재시도하십시오.");
		} catch(SQLException e) {
			System.err.println("SQLException : 변경에 실패하였습니다. \n 재시도하십시오.");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
