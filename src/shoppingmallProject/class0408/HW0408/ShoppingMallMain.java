package shoppingmallProject.class0408.HW0408;

public class ShoppingMallMain {

	public static void main(String[] args) {
		// 우리가 상품을 사는 과정
		// 사람이 쇼핑몰가서 물건을 보고, 고르고, 장바구니에 담고, 결제
		// 1. 장보러 왔습니다.
		ShoppingMallManager manager = new ShoppingMallManager();
		manager.getUserData(); // 고객의 정보와 관리자인지 아닌지를 받음

		if (Config.isAdmin == true) {
			// admin의 권한을 얻는다.
			Admin admin = new Admin();
			admin.printAdminAction();
		} else {
			// 일반 손님으로서 주문 과정을 거친다.
			User user = new User();
		}
	}
}

