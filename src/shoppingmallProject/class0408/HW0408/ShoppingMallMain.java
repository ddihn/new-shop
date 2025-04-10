package shoppingmallProject.class0408.HW0408;

public class ShoppingMallMain {

	public static void main(String[] args) {
		// 장바구니, 등록된 상품이 있는지 체크하는 메소드
		// 우리가 상품을 사는 과정
		// 사람이 쇼핑몰가서 물건을 보고, 고르고, 장바구니에 담고, 결제
		// 1. 장보러 왔습니다.
		ShoppingMallManager manager = new ShoppingMallManager();
		manager.getUserData();
		manager.enterMall();
	}
}
