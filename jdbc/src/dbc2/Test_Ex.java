package dbc2;
//PreparedStatement객체 이용해서 코드 작성
//데이터 추가하기
//테이블 : dept 
//추가할 데이터 : 부서번호: 50, 부서명:  '개발', 위치:  '서울'
import java.sql.*;

public class Test_Ex {
   public static void main(String[] args) {
//      1. 드라이버 준비
      String driver = "oracle.jdbc.driver.OracleDriver";
//      2. 데이터베이스 연결객체 생성
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "TEST";
      String pw = "1111";
      Connection conn = null;
//      3. 명령문 담을 객체
      PreparedStatement ps = null;
      
      try {
//      1. 드라이버 준비
         Class.forName(driver);
//      2. 데이터베이스 연결객체 생성
         conn = DriverManager.getConnection(url, user, pw);
//      3. 명령문 담을 객체
//테이블 : dept 
//추가할 데이터 : 부서번호: 50, 부서명:  '개발', 위치:  '서울'
         String sql = "INSERT INTO DEPT (deptno, dname, loc)"
               + " VALUES (?, ?, ?)";
         ps = conn.prepareStatement(sql);
//      4. 명령문 객체 실행 전 바인드변수값 설정하기
         ps.setInt(1,50);
         ps.setString(2, "개발");
         ps.setString(3, "서울");         
//      5. 명령문 실행
         int rowcnt = ps.executeUpdate();
         
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            ps.close();
            conn.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
            
   }
}