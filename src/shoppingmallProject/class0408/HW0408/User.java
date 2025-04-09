package shoppingmallProject.class0408.HW0408;

public class User {
	// 새 주문 생성
	// 장바구니 가지고 있음
	// 여러 주문도 생성 가능

	String name;
	OrderManage orderManager;
	CartItem items;

	public void printUserAction() {
		System.out.println("--------------------------장보기 메뉴--------------------------");
		System.out.println("1. 상품 전체 출력 | 2. 장바구니 담기 | 3. 장바구니 확인 | 4. 구매하기 | 5. 나가기");
		System.out.print("번호 선택 : ");
		String adminInput = Config.scanner.next();

		if (adminInput.equals("1")) {

		} else if (adminInput.equals("2")) {

		} else if (adminInput.equals("3")) {

		} else if (adminInput.equals("4")) {
			return;
		} else {
			System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
		}
	}
}
