package mcd;

import java.sql.*;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.*;

public class McdonaldSVC {

	Connection con;

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test";
			String pw = "1111";
			con = DriverManager.getConnection(url, user, pw);
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러2");
		}
		return con;
	}

	public void searchItem(Scanner sc) throws SQLException {

		getConnection();
		showItem();
		System.out.println("상품번호를 입력해주세요.");
		System.out.print("상품번호 => ");
		int search = sc.nextInt();
		McdonaldVO mcdonaldVO = getSearchItem(search);
		System.out.println(mcdonaldVO);

		showIngreVO(search);

		con.close();
	}

	private McdonaldVO getSearchItem(int search) throws SQLException {
		McdonaldVO mcdonaldVO = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tbl_burger where prod_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, search);
			rs = ps.executeQuery();
			if (rs.next()) {
				int prodNum = rs.getInt("prod_num");
				String searchId = rs.getString("prod_name");
				int price = rs.getInt("price");
				String prod_info = rs.getString("prod_info");
				String value = rs.getString("value");
				mcdonaldVO = new McdonaldVO(prodNum, searchId, price, prod_info, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
		}
		return mcdonaldVO;
	}

	public McdonaldVO getMcdonaldVO(Scanner sc) {
		System.out.println("=== 상품 등록 ===");
		System.out.print("상품번호 : ");
		int prod_num = sc.nextInt();
		System.out.print("상품명 : ");
		String prod_name = sc.next();
		System.out.print("상품가격 : ");
		int price = sc.nextInt();

		sc.nextLine();
		System.out.print("상품정보 : ");
		String prod_info = sc.nextLine();
		System.out.print("상품종류 : ");
		String value = sc.next();

		McdonaldVO mcdonaldVO = new McdonaldVO(prod_num, prod_name, price, prod_info, value);
		return mcdonaldVO;
	}

	public void addItem(Scanner sc) throws SQLException {
		getConnection();
		McdonaldVO mcdVO = getMcdonaldVO(sc);
		PreparedStatement ps = null;
		String sql = "insert into tbl_burger values (?, ?, ?, ?, ?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mcdVO.getItemId());
			ps.setString(2, mcdVO.getItemName());
			ps.setInt(3, mcdVO.getPrice());
			ps.setString(4, mcdVO.getItemInfo());
			ps.setString(5, mcdVO.getItemType());

			int count = ps.executeUpdate();

			insertIngreVO(sc, mcdVO.getItemId());

			if (count > 0) {
				System.out.println("상품 등록 완료");
			} else
				System.out.println("상품 등록 실패");

		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			System.out.println("에러1");

		} finally {
			ps.close();

		}

	}

	public void showItem() throws SQLException {
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_burger";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println("\t 상품번호 \t 상품명");

			while (rs.next()) {
				System.out.println("\t" + rs.getInt("prod_num") + "\t" + rs.getString("prod_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러3");
		} finally {
			rs.close();
			ps.close();
		}
	}

	private McdonaldVO getMcdonaldItemId(int prod_num) throws SQLException {
		McdonaldVO mcdonaldVO = null;
		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_burger WHERE prod_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, prod_num);
			rs = ps.executeQuery();
			if (rs.next()) {
				int dbId = rs.getInt("prod_num");
				String prod_name = rs.getString("prod_name");
				int price = rs.getInt("price");
				String prod_info = rs.getString("prod_info");
				String value = rs.getString("value");
				mcdonaldVO = new McdonaldVO(dbId, prod_name, price, prod_info, value);
			}

			System.out.println(mcdonaldVO);

			showIngreVO(prod_num);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			con.close();
		}
		return mcdonaldVO;
	}

	public void updateItem(Scanner sc) throws SQLException {

		showItem();

		System.out.println("수정할 상품의 상품번호를 입력하세요.");
		System.out.print("상품번호 : ");
		int prod_num = sc.nextInt();

		McdonaldVO mcdonaldVO = getMcdonaldItemId(prod_num);

		System.out.println("수정할 데이터를 입력하세요.");
		System.out.println("원래 상품명 : " + mcdonaldVO.getItemName());
		System.out.print("수정할 상품명 : ");
		String prod_name = sc.next();

		System.out.println("원래 상품가격 : " + mcdonaldVO.getPrice());
		System.out.print("수정할 상품가격 : ");
		int price = sc.nextInt();

		System.out.println("원래 상품정보 : " + mcdonaldVO.getItemInfo());
		System.out.print("수정할 상품정보 : ");
		String prod_info = sc.next();

		System.out.println("원래 상품종류 : " + mcdonaldVO.getItemType());
		System.out.print("수정할 상품종류 : ");
		String sel123 = (sc.nextLine());
		String value = sc.nextLine();

		mcdonaldVO.setItemName(prod_name);
		mcdonaldVO.setPrice(price);
		mcdonaldVO.setItemInfo(prod_info);
		mcdonaldVO.setItemType(value);

		int count = updateItem(mcdonaldVO);

		updateIngreVO(sc, prod_num);

		if (count > 0) {
			System.out.println("상품 수정 완료");
		} else {
			System.out.println("상품 수정 실패");
		}

	}

	private int updateItem(McdonaldVO mcdonaldVO) throws SQLException {
		int updateCount = 0;
		getConnection();
		PreparedStatement ps = null;

		String sql = "UPDATE tbl_burger SET prod_name = ?, price = ?, prod_info = ?, value = ?" + " WHERE prod_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mcdonaldVO.getItemName());
			ps.setInt(2, mcdonaldVO.getPrice());
			ps.setString(3, mcdonaldVO.getItemInfo());
			ps.setString(4, mcdonaldVO.getItemType());
			ps.setInt(5, mcdonaldVO.getItemId());
			updateCount = ps.executeUpdate();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			System.out.println("수정 실패");
		} finally {
			ps.close();
		}
		return updateCount;
	}

	public void deleteItem(Scanner sc) throws SQLException {
		System.out.println("삭제할 상품번호를 입력하세요.");
		System.out.print("상품번호 : ");
		int id = sc.nextInt();

		deleteIngre(id);
		int count = deleteBurgerItem(id);

		if (count > 0) {
			System.out.println("상품 삭제 완료");
		} else {
			System.out.println("상품 삭제 실패");
		}
	}

	public int deleteBurgerItem(int prod_num) throws SQLException {
		int deleteCount = 0;
		con = getConnection();
		PreparedStatement ps = null;

		try {
			String sql = "DELETE from tbl_burger WHERE prod_num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, prod_num);
			deleteCount = ps.executeUpdate();

		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			ps.close();
		}
		return deleteCount;
	}

	public int deleteIngre(int id) throws SQLException {
		con = getConnection();
		PreparedStatement ps = null;

		try {
			String sql = "DELETE from TBL_INGREDIENT WHERE PROD_NUM = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			con.rollback();
			System.out.println("영양정보삭제오류");
			e.printStackTrace();
		} finally {
			ps.close();
			con.close();
		}
		return id;
	}

	public IngreVO showIngreVO(int num) throws SQLException {
		IngreVO ingreVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TBL_INGREDIENT WHERE prod_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				double p_num = rs.getDouble("PROD_NUM");
				double gram = rs.getDouble("GRAM");
				double ml = rs.getDouble("ML");
				double kcal = rs.getDouble("KCAL");
				double sugar = rs.getDouble("SUGER");
				double protein = rs.getDouble("PROTEIN");
				double fat = rs.getDouble("FAT");
				double natrium = rs.getDouble("NATRIUM");
				double caffeine = rs.getDouble("CAFFEINE");
				ingreVO = new IngreVO(p_num, gram, ml, kcal, sugar, protein, fat, natrium, caffeine);
			}

			System.out.println(ingreVO);

		} catch (Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
		}
		return ingreVO;
	}

	public IngreVO getIngreVO(Scanner sc, int itemId) {
		System.out.println("영양정보를 입력합니다.");

		double p_num = (double)itemId;

		System.out.println("중량(g)을 입력해주세요");
		double gram = Double.parseDouble(sc.next());

		System.out.println("중량(ml)을 입력해주세요");
		double ml = Double.parseDouble(sc.next());

		System.out.println("열량을 입력해주세요");
		double kcal = Double.parseDouble(sc.next());

		System.out.println("당을 입력해주세요");
		double sugar = Double.parseDouble(sc.next());

		System.out.println("단백질을 입력해주세요");
		double protein = Double.parseDouble(sc.next());

		System.out.println("포화지방을 입력해주세요");
		double fat = Double.parseDouble(sc.next());

		System.out.println("나트륨을 입력해주세요");
		double natrium = Double.parseDouble(sc.next());

		System.out.println("카페인을 입력해주세요");
		double caffeine = Double.parseDouble(sc.next());

		IngreVO ingreVO = new IngreVO(p_num, gram, ml, kcal, sugar, protein, fat, natrium, caffeine);
		return ingreVO;
	}

	public void insertIngreVO(Scanner sc, int itemId) throws SQLException {
		IngreVO ingreVO = getIngreVO(sc, itemId);
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO TBL_INGREDIENT VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, ingreVO.getP_num());
			pstmt.setDouble(2, ingreVO.getGram());
			pstmt.setDouble(3, ingreVO.getMl());
			pstmt.setDouble(4, ingreVO.getKcal());
			pstmt.setDouble(5, ingreVO.getSugar());
			pstmt.setDouble(6, ingreVO.getProtein());
			pstmt.setDouble(7, ingreVO.getFat());
			pstmt.setDouble(8, ingreVO.getNatrium());
			pstmt.setDouble(9, ingreVO.getCaffeine());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println(" 영양정보 등록을 완료하였습니다 ");
			} else {
				System.out.println("영양정보 등록을 실패하였습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//				con.commit();
			pstmt.close();
		}
	}

	public void updateIngreVO(Scanner sc, int itemId) throws SQLException {
		int p_num = itemId;
		IngreVO ingreVO = getIngreVO(sc, p_num);
		con = getConnection();
		PreparedStatement pstmt = null;

		String sql = "UPDATE TBL_INGREDIENT SET GRAM = ?, ML = ?, KCAL = ?, SUGER = ?, PROTEIN = ?"
				+ ", FAT = ?, NATRIUM = ?, CAFFEINE = ? WHERE prod_NUM = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, ingreVO.getGram());
			pstmt.setDouble(2, ingreVO.getMl());
			pstmt.setDouble(3, ingreVO.getKcal());
			pstmt.setDouble(4, ingreVO.getSugar());
			pstmt.setDouble(5, ingreVO.getProtein());
			pstmt.setDouble(6, ingreVO.getFat());
			pstmt.setDouble(7, ingreVO.getNatrium());
			pstmt.setDouble(8, ingreVO.getCaffeine());
			pstmt.setDouble(9, ingreVO.getP_num());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				System.out.println("영양정보 등록을 완료하였습니다 ");
			} else {
				System.out.println("영양정보 등록을 실패하였습니다. ");
			}
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			System.out.println("수정 실패");
		} finally {
			pstmt.close();
		}
	}

	public void getOrderInfo(Scanner sc) throws SQLException {
		getConnection();
		PreparedStatement pstmt = null;

		System.out.println("주문정보를 조회합니다");
		System.out.println("주문번호를 입력해주세요");
		System.out.println("전체 주문내역 조회시 0을 입력해주세요");
		int num = sc.nextInt();
		if (num != 0) {
			showOrderInfo(num);

		} else {
			showOrderInfoAll();
		}
		con.close();
	}

	public void showOrderInfo(int num) {
		con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_order where order_no = ?";
		try {
			NumberFormat nfm = NumberFormat.getInstance();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String str = nfm.format(rs.getInt("tot_price"));
				System.out.println("주문번호: " + rs.getInt("ORDER_NO") + "\n고객명: " + rs.getString("NAME") + "\n연락처: "
						+ rs.getString("PHNUM") + "\n주소: " + rs.getString("ADRESS") + "\n주문정보: "
						+ rs.getString("ORDER_INFO") + "\n주문금액: " + str + "원" + "\n취소여부: " + rs.getString("CANCLE_YN")
						+ "\n주문일자: " + rs.getString("order_time") + "\n주문수량: " + rs.getInt("count"));
			} else {
				System.out.println("주문내역이 없습니다. 다시 확인해주세요.\n초기화면으로 돌아갑니다.");
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("개별출력예외처리");
			e.printStackTrace();
		}
	}

	public void showOrderInfoAll() {
		con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from tbl_order";

		try {
			NumberFormat nfm = NumberFormat.getInstance();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String str = nfm.format(rs.getInt("tot_price"));
				System.out.println("\n" + "주문번호: " + rs.getInt("order_no") + "\n고객명: " + rs.getString("name")
						+ "\n연락처: " + rs.getString("phnum") + "\n주소: " + rs.getString("ADRESS") + "\n주문정보: "
						+ rs.getString("order_info") + "\n주문금액: " + str + "원" + "\n취소여부: " + rs.getString("cancle_yn")
						+ "\n주문일자: " + rs.getString("order_time") + "\n주문수량: " + rs.getInt("count")
						+ "\n---------------------");

			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.out.println("주문정보 전체출력 예외처리");
			e.printStackTrace();
		}
	}

	public void showList(Scanner sc) throws SQLException {
		System.out.println("1. 전체메뉴");
		System.out.println("2. 단품");
		System.out.println("3. 세트");
		System.out.println("4. McCafe");
		System.out.println("5. 음료");
		System.out.print("메뉴를 선택해주세요 : ");

		int menu = Integer.parseInt(sc.next());
		switch (menu) {
		case 1:
			showItemList();
			userSelect(sc);
			break;
		case 2:
			showSingleList();
			userSelect(sc);
			break;
		case 3:
			showSetList();
			userSelect(sc);
			break;
		case 4:
			showCafeList();
			userSelect(sc);
			break;
		case 5:
			showDrinkList();
			userSelect(sc);
			break;
		default:
			System.out.println("명령 입력이 잘못되었습니다. 다시 입력해주세요.");
		}
	}

	public void userSelect(Scanner sc) throws SQLException {
		System.out.println("주문하실 상품 번호를 입력해주세요.");
		System.out.println("상품번호 입력 : ");
		int sel = Integer.parseInt(sc.next());

		System.out.println("주문수량 입력 : ");
		int sel0 = Integer.parseInt(sc.next());

		System.out.print("이름 입력 : ");
		String sel1 = (sc.next());

		sc.nextLine();
		System.out.print("주소 입력 : ");
		 String sel2 = (sc.nextLine());

		System.out.print("전화번호 입력 : ");
		String sel3 = (sc.next());

		getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		NumberFormat nfm = NumberFormat.getInstance();

		String sql = "insert into tbl_order (order_no, order_info, name, phnum, adress, count,tot_price,order_time)"
				+ " values(seq_order_no.nextval, (select prod_name from tbl_burger where prod_num=" + sel + " )," + "'"
				+ sel1 + "',  '" + sel3 + "', '" + sel2 + "','" + sel0 + "', (select price*" + sel0
				+ " from tbl_burger where prod_num=" + sel + ") ,sysdate)";
		try {
			int a=1;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			String sql2 = "select * from tbl_order where phnum='" + sel3 + "'";
			rs = stmt.executeQuery(sql2);
			rs.next();
			String str = nfm.format(rs.getInt("tot_price"));
			System.out.println("\n주문번호 : " + rs.getInt("order_no") + "\t" + "주문자명 : " + rs.getString("name") + "\t\t"
					+ "연락처 : " + rs.getString("phnum") + "\n" + "주소 : " + rs.getString("adress") + " \t" + "주문상품 : "
					+ rs.getString("order_info") + "\t" + "주문수량 : " + rs.getInt("count") + "\t" + "총 주문 금액 : " + str
					+ "원" + "\n" + "주문취소여부 : " + rs.getString("cancle_yn") + "\t" + "주문시간 : "
					+ rs.getString("order_time"));
			System.out.println("\n★성공적으로 상품을 추가하였습니다.\n추가 주문하시겠습니까?");
			System.out.println("1. 추가주문");
			System.out.println("2. 주문완료");
			System.out.print("메뉴를 선택해주세요 : ");

		
			while(a==1){
				int menu = Integer.parseInt(sc.next());
				switch(menu) {
				case 1:
					System.out.println("1. 전체메뉴");
					System.out.println("2. 단품");
					System.out.println("3. 세트");
					System.out.println("4. McCafe");
					System.out.println("5. 음료");
					System.out.print("메뉴를 선택해주세요 : ");
					int reMenu = Integer.parseInt(sc.next());
					switch (reMenu) {
					case 1:
						showItemList();
						break;
					case 2:
						showSingleList();
						break;
					case 3:
						showSetList();
						break;
					case 4:
						showCafeList();
						break;
					case 5:
						showDrinkList();
						break;
					default:
						System.out.println("명령 입력이 잘못되었습니다. 다시 입력해주세요.");
					}
					//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					System.out.println("주문하실 상품 번호를 입력해주세요.");
					System.out.println("상품번호 입력 : ");
					int reSel = Integer.parseInt(sc.next());

					System.out.println("주문수량 입력 : ");
					int reSel0 = Integer.parseInt(sc.next());
//					stmt = con.createStatement();

					String sql5 = "insert into tbl_order (order_no, order_info, name, phnum, adress, count,tot_price,order_time)"
							+ " values(seq_order_no.currval, (select prod_name from tbl_burger where prod_num=" + reSel + " )," + "'"
							+ sel1 + "',  '" + sel3 + "', '" + sel2 + "','" + reSel0 + "', (select price*" + reSel0
							+ " from tbl_burger where prod_num=" + reSel + ") ,sysdate)";
					
					stmt.executeQuery(sql5);
					String sql4 = "select * from tbl_order where phnum='" + sel3 + "'";
					System.out.println("★성공적으로 상품을 추가하였습니다.\n추가 주문하시겠습니까?");
					rs = stmt.executeQuery(sql4);
					System.out.println("주문번호 : " + rs.getInt("order_no") + "\t" + "주문자명 : " + rs.getString("name") + "\t\t"
							+ "연락처 : " + rs.getString("phnum") + "\n" + "주소 : " + rs.getString("adress") + " \t" + "주문상품 : "
							+ rs.getString("order_info") + "\t" + "주문수량 : " + rs.getInt("count") + "\t" + "총 주문 금액 : " + str
							+ "원" + "\n" + "주문취소여부 : " + rs.getString("cancle_yn") + "\t" + "주문시간 : "
							+ rs.getString("order_time"));
					break;
				case 2:
					System.out.println("★주문이 완료되었습니다.\n 감사합니다.ദ്ദി*ˊᗜˋ*) \n");
					if(1==1) {a=2;}
					break;
				default:
					System.out.println("명령 입력이 잘못되었습니다. 다시 입력해주세요.");
				}
			}
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			System.out.println("주문에러");
		} finally {
			rs.close();
			stmt.close();
		}
	}

	
//		
//		getConnection();
//		Statement stmt = null;
//		ResultSet rs = null;
//		NumberFormat nfm = NumberFormat.getInstance();
//		
//		String sql = "insert into tbl_order (order_no, order_info, name, phnum, adress, count,tot_price,order_time)"
//				+ " values(seq_order_no.nextval, (select prod_name from tbl_burger where prod_num=" + sel + " )," + "'"
//				+ sel + "',  '" + sel3 + "', '" + userSelect.sel2 + "','" + sel0 + "', (select price*" + sel0
//				+ " from tbl_burger where prod_num=" + sel + ") ,sysdate)";

	public void showSingleList() throws SQLException {
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_burger where value='single'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("\t 상품번호 \t 상품명 \t 가격 ");
			while (rs.next()) {
				System.out.println(
						"\t" + rs.getInt("prod_num") + "\t" + rs.getString("prod_name") + "\t" + rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();
		}
	}

	public void showSetList() throws SQLException {
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_burger where value='set'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("\t 상품번호 \t 상품명 \t 가격 ");
			while (rs.next()) {
				System.out.println(
						"\t" + rs.getInt("prod_num") + "\t" + rs.getString("prod_name") + "\t" + rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();
		}
	}

	public void showCafeList() throws SQLException {
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_burger where value='mccafe'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("\t 상품번호 \t 상품명 \t 가격 ");
			while (rs.next()) {
				System.out.println(
						"\t" + rs.getInt("prod_num") + "\t" + rs.getString("prod_name") + "\t" + rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();
		}
	}

	public void showDrinkList() throws SQLException {
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_burger where value='drink'";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("\t 상품번호 \t 상품명 \t 가격 ");
			while (rs.next()) {
				System.out.println(
						"\t" + rs.getInt("prod_num") + "\t" + rs.getString("prod_name") + "\t" + rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();
		}
	}

	public void showItemList() throws SQLException {
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_burger";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("\t 상품번호 \t 상품명 \t 가격 ");
			while (rs.next()) {
				System.out.println(
						"\t" + rs.getInt("prod_num") + "\t" + rs.getString("prod_name") + "\t" + rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			con.close();
		}
	}

	public void showOrder(Scanner sc) throws SQLException {
		System.out.println("1.주문수정");
		System.out.println("2.주문취소");

		int order = Integer.parseInt(sc.next());
		switch (order) {

		case 1:
			changeOrderList(sc);
			break;
		case 2:
			cancleOrder(sc);
			break;
		default:
			System.out.println("잘 못 입력하셨습니다.\n메뉴를 다시 선택해주세요.");
		}
	}

	public void changeOrderList(Scanner sc) throws SQLException {

		System.out.println("수정할 주문 번호를 입력해주세요.");
		System.out.print("주문번호 : ");
		int order = sc.nextInt();

		OrderVO ordervo = getArticle(order);

		System.out.println("수정할 데이터를 입력하세요.");
		System.out.println("이름 : " + ordervo.getName());
		System.out.print("수정할 이름 : ");
		String name = sc.next();
		System.out.println("기존 연락처 : " + ordervo.getPhnum());
		System.out.print("수정할 연락처 : ");
		String phnum = sc.next();
		System.out.println("기존 주소 : " + ordervo.getAddress());

		sc.nextLine();
		System.out.print("수정할 주소 : ");
		String adress = sc.nextLine();
		ordervo.setName(name);
		ordervo.setPhnum(phnum);
		ordervo.setAddress(adress);

		int count = getOrdernum(ordervo);
		if (count > 0) {
			System.out.println("수정 완료");
		} else {
			System.out.println("수정 실패");
		}
	}

	private int getOrdernum(OrderVO ordervo) throws SQLException {
		int updateCount = 0;
		getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE tbl_order SET name = ?, phnum = ?, adress = ?, order_info = ?, count = ?, tot_price = ?, order_time = ?, cancle_yn = ?  WHERE order_no = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ordervo.getName());
			ps.setString(2, ordervo.getPhnum());
			ps.setString(3, ordervo.getAddress());
			ps.setString(4, ordervo.getOrder_info());
			ps.setInt(5, ordervo.getOrder_count());
			ps.setInt(6, ordervo.getTot_price());
			ps.setDate(7, ordervo.getOrder_time());
			ps.setString(8, ordervo.getCancle_yn());
			ps.setInt(9, ordervo.getOrder_no());

			updateCount = ps.executeUpdate();

		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			System.out.println("주문 수정 실패");
		} finally {
			ps.close();
		}
		return updateCount;
	}

	private OrderVO getArticle(int order_no) throws SQLException {
		OrderVO orderVO = null;
		getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM tbl_order WHERE order_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int dbId = rs.getInt("order_no");
				String name = rs.getString("name");
				String phnum = rs.getString("phnum");
				String adress = rs.getString("adress");
				String order_info = rs.getString("order_info");
				int count = rs.getInt("count");
				int tot_price = rs.getInt("tot_price");
				Date order_time = rs.getDate("order_time");
				String cancle_yn = rs.getString("cancle_yn");

				orderVO = new OrderVO(dbId, name, phnum, adress, order_info, count, tot_price, order_time, cancle_yn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
		}
		return orderVO;
	}
//		 

	public void cancleOrder(Scanner sc) throws SQLException {

		System.out.println("취소하실 주문번호를 입력해주세요.\n주문번호 : ");
		int yn = Integer.parseInt(sc.next());

		getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String sql = "update tbl_order set cancle_yn = ? where order_no = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "y");
			ps.setInt(2, yn);
			int count = ps.executeUpdate();

			if (count > 0) {
				System.out.println("주문취소가 완료되었습니다.");

			} else {
				System.out.println("주문취소에 실패하였습니다.\n다시 입력해주세요.");
				showOrder(sc);
			}

		} catch (Exception e) {
			con.rollback();
			System.out.println("주문취소에러");
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}

}
