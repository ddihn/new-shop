package shoppingmallProject.class0408.HW0408;

public class User {
	// 새 주문 생성
	// 장바구니 가지고 있음

	String name;
	OrderManage orderManager;

	public void printUserAction() {
		while (true) {
			System.out.println("\n--------------------------< 장보기 메뉴 >--------------------------\n");
			System.out.println("1. 상품 전체 출력 | 2. 장바구니 담기 | 3. 장바구니 확인 | 4. 구매하기 | 5. 나가기");
			System.out.print("번호 선택 : ");
			String adminInput = Config.scanner.next();

			if (adminInput.equals("1")) {
				ProductManage manager = new ProductManage();
				manager.printAllProduct();
			} else if (adminInput.equals("2")) {
				// 담는 행동이 끝날 때까지 담아야지 ㅡㅡ 하나 담고 끝내는 게 아니라
				Config.cart.selectProduct();
			} else if (adminInput.equals("3")) {
				Config.cart.printCartItem();
			} else if (adminInput.equals("4")) {
				Config.cart.orderCartItem();
			} else if (adminInput.equals("5")) {
				System.out.print("\n[ 성공 ] 쇼핑을 종료합니다. 안녕히 가십시오. 또 오세요!");
				return;
			} else {
				System.out.print("\n[ 실패 ] 잘못된 입력입니다. 다시 선택해주세요.");
			}
		}
	}
}
