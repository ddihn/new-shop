package shoppingmallProject.class0408.HW0408;

public class CartProcess {

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

	public void clearCart() {
		for (int i = 0; i < cartItemCnt; i++) {
			cart[i] = null;
		}
		cartItemCnt = 0;
	}

}
