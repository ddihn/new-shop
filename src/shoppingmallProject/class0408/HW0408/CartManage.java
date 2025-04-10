package shoppingmallProject.class0408.HW0408;

public class CartManage {

	CartItem[] cart = new CartItem[Config.MAX_PRODUCT_CNT];
	int cartItemCnt = 0;
	int quantity;

	public void selectProduct() {

		System.out.println("[ 안내 ] 장바구니에 담을 상품 번호와 개수를 입력해주세요.");
		System.out.print("상품 번호 >> ");
		// TODO: 상품 번호 체크 로직부분도 함수화?
		int selectedProductId = Config.scanner.nextInt();
		System.out.print("상품 개수 >> ");
		quantity = Config.scanner.nextInt();
		cart[cartItemCnt] = new CartItem();
		cart[cartItemCnt].quantity = quantity;
		addItemToCart(selectedProductId);
	}

	public void addItemToCart(int selectedProductId) {
		int idxId = selectedProductId - 1;
		if (idxId < 0 || idxId > Config.productCnt) {
			System.out.println("[ 실패 ] 유효한 상품 번호가 아닙니다.");
		} else {
			cart[cartItemCnt].product = Config.productManager.product[idxId];
			cartItemCnt++;
			System.out.println(
					"[ 성공 ] " + Config.productManager.product[idxId].productName + " " + quantity + "개를 장바구니에 담았습니다.");
		}
	}

	public void printCartItem() {
		int cartTotalPrice = 0;
		System.out.println("[ 안내 ] 장바구니에 담긴 상품을 출력합니다.\n");
		System.out.println("------------------------------------------------------------");
		System.out.println("[상품 번호]\t[상품명]\t\t[개수]\t\t[총 가격]");
		System.out.println("------------------------------------------------------------");
		for (int i = 0; i < cartItemCnt; i++) {
			System.out.println("[" + (cart[i].product.productId + 1) + "]\t\t" + cart[i].product.productName + "\t\t"
					+ cart[i].quantity + "개\t\t" + Config.cart.cart[i].totalPrice + "원");
			cartTotalPrice += Config.cart.cart[i].totalPrice;
			System.out.println("------------------------------------------------------------");
		}
		System.out.println("예상 결제액: " + cartTotalPrice);
	}

	public void orderCartItem() {
		// TODO: 성공하면 장바구니를 비워야 함
		System.out.println("--------------------------< 상품 구매 >--------------------------");
		System.out.println("[ 안내 ] 장바구니에 담긴 상품들을 구매합니다.");
		printCartItem();
		while (true) {
			System.out.println("구매창으로 이동할까요? (y : 이동 /n : 선택 화면 복귀)");
			System.out.print(">> ");
			String answer = Config.scanner.next();

			if (answer.equals("y")) {
//				Order order = new Order();
				System.out.println("[ 성공 ] 상품 구매가 완료되었습니다.");
				return;

			} else if (answer.equals("n")) {
				System.out.println("[ 성공 ] 상품을 구매하지 않습니다. 선택 화면으로 복귀합니다.");
				return;

			} else {
				System.out.println("[ 실패 ] 잘못된 입력입니다. 다시 입력해주세요.(y/n)");
			}
		}

	}

	// TODO: 장바구니의 내용 변경 ( 개수 빼는 대로 장바구니에서 빼주고 개수 넘게 빼면 다뺀다고 해주고 )

}
