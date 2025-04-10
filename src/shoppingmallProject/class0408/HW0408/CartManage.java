package shoppingmallProject.class0408.HW0408;

public class CartManage {

	CartItem[] cart = new CartItem[Config.MAX_PRODUCT_CNT];
	int cartItemCnt = 0;

	public void selectProduct() {
		Config.productManager.printAllProduct();

		while (true) {
			System.out.println("[ 안내 ] 장바구니에 담을 상품 번호와 개수를 입력해주세요. ( 그만 담으려면 0 입력 )");
			System.out.print("상품 번호 >> ");
			int selectedProductId = Config.scanner.nextInt();

			if (selectedProductId == 0) {
				System.out.println("[ 안내 ] 상품 담기를 종료합니다.");
				return;
			}

			if (!isValidProductId(selectedProductId)) {
				System.out.println("[ 실패 ] 유효한 상품 번호가 아닙니다.");
				continue;
			}

			System.out.print("상품 개수 >> ");
			int quantity = Config.scanner.nextInt();

			sumDuplicateProduct(selectedProductId, quantity);
		}
	}

	public boolean isValidProductId(int productId) {
		return productId > 0 && productId <= Config.productCnt;
	}

	public void sumDuplicateProduct(int productId, int quantity) {
		int idxId = productId - 1;
		for (int i = 0; i < cartItemCnt; i++) {
			if (cart[i].product.productId == idxId) {
				cart[i].quantity += quantity;
				cart[i].calcTotalPrice();
				System.out.println("[ 안내 ] " + Config.productManager.product[idxId].productName + " " + quantity
						+ "개를 장바구니에 담았습니다.\n");
				return;
			}
		}
		addItemToCart(productId, quantity);
	}

	public void addItemToCart(int selectedProductId, int quantity) {
		int idxId = selectedProductId - 1;

		cart[cartItemCnt] = new CartItem();
		cart[cartItemCnt].product = Config.productManager.product[idxId];
		cart[cartItemCnt].quantity = quantity;
		cart[cartItemCnt].calcTotalPrice();
		cartItemCnt++;

		System.out.println(
				"[ 성공 ] " + Config.productManager.product[idxId].productName + " " + quantity + "개를 장바구니에 담았습니다.\n");
	}

	public void orderCartItem() {
		System.out.println("--------------------------< 상품 구매 >--------------------------");
		printCartItem();

		while (true) {
			System.out.println("\n구매창으로 이동할까요? ( y : 이동 / n : 선택 화면 복귀 )");
			System.out.print(">> ");
			String answer = Config.scanner.next();

			if (answer.equals("y")) {
				Order order = new Order();

				order.getShippingInfo();
				order.checkRightShippingInfo();

				System.out.println("[ 성공 ] 상품 구매가 완료되었습니다.");
				Config.cart.clearCart();
				return;
			} else if (answer.equals("n")) {
				System.out.println("[ 성공 ] 상품을 구매하지 않습니다. 선택 화면으로 복귀합니다.");
				return;
			} else {
				System.out.println("[ 실패 ] 잘못된 입력입니다. 다시 입력해주세요. ( y / n 중 입력)");
			}
		}
	}

	public void printCartItem() {
		if (checkCartEmpty())
			return;

		int cartTotalPrice = 0;

		System.out.println("[ 안내 ] 장바구니에 담긴 상품을 출력합니다.\n");
		printLine();
		System.out.println("[상품 번호]\t[상품명]\t\t[개수]\t\t[총 가격]");
		printLine();

		for (int i = 0; i < cartItemCnt; i++) {
			System.out.println("[" + (cart[i].product.productId + 1) + "]\t\t" + cart[i].product.productName + "\t\t"
					+ cart[i].quantity + "개\t\t" + cart[i].totalPrice + "원");
			cartTotalPrice += cart[i].totalPrice;
		}

		printLine();
		System.out.println("예상 결제액: " + cartTotalPrice + "원");
	}

	public void clearCart() {
		for (int i = 0; i < cartItemCnt; i++) {
			cart[i] = null;
		}
		cartItemCnt = 0;
	}

	public boolean checkCartEmpty() {
		if (Config.cart.cartItemCnt == 0) {
			System.out.println("[ 안내 ] 장바구니에 상품이 없습니다.");
			return true;
		}
		return false;
	}

	public void printLine() {
		System.out.println("----------------------------------------------------------------");
	}

}
