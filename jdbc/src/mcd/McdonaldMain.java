package mcd;

import java.sql.SQLException;
import java.util.*;

public class McdonaldMain {

	public static void main(String[] args) throws SQLException {
		McdonaldSVC mcdonaldSVC = new McdonaldSVC();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===== 맥도날드 프로그램 =====");
			System.out.println("1. 상품 등록");
			System.out.println("2. 상품 수정");
			System.out.println("3. 상품 삭제");
			System.out.println("4. 전체 목록");
			System.out.println("5. 상품 주문");
			System.out.println("6. 상세 상품 검색");
			System.out.println("7. 주문 조회");
			System.out.println("8. 주문 정보 수정");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴를 선택해주세요 : ");

			int menu = Integer.parseInt(sc.next());
			switch (menu) {
			case 1:
				mcdonaldSVC.addItem(sc);
				mcdonaldSVC.con.commit();
				mcdonaldSVC.con.close();
				break;
			case 2:
				mcdonaldSVC.updateItem(sc);
				mcdonaldSVC.con.commit();
				mcdonaldSVC.con.close();
				break;
			case 3:
				mcdonaldSVC.deleteItem(sc);
				mcdonaldSVC.con.commit();
				mcdonaldSVC.con.close();
				break;
			case 4:
				mcdonaldSVC.showItem();
				break;
			case 5:
				mcdonaldSVC.showList(sc);
				mcdonaldSVC.con.commit();
				mcdonaldSVC.con.close();
				break;
			case 6:
				mcdonaldSVC.searchItem(sc);
				break;
			case 7:
				mcdonaldSVC.getOrderInfo(sc);
				break;
			case 8:
				mcdonaldSVC.showOrder(sc);
				mcdonaldSVC.con.commit();
				mcdonaldSVC.con.close();
				break;
			case 9:
				System.out.println("프로그램이 종료 되었습니다.");
				return;
			default:
				System.out.println("명령 입력이 잘못되었습니다. 다시 입력해주세요.");
			}
		}

	}
}
