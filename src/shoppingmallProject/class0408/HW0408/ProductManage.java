package shoppingmallProject.class0408.HW0408;

public class ProductManage {

	Product[] product = new Product[Config.MAX_PRODUCT_CNT];

	public void selectProductView() {
		if (checkProductListEmpty())
			return;

		System.out.println("\n[ 안내 ] 전체 상품을 어떻게 보여드릴까요?\n1. 상품 등록 순 | 2. 가격 낮은 순 | 3. 상품 검색");
		System.out.print(">> ");
		int select = Config.scanner.nextInt();
		switch (select) {
		case 1:
			printAllProduct();
			break;

		case 2:
			printSortedProduct();
			break;

		case 3:
			searchProductName();
			break;

		default:
			System.out.println("[ 안내 ] 잘못된 입력입니다. 상품을 등록 순으로 출력합니다.");
			break;
		}

	}

	public void printAllProduct() {

		if (checkProductListEmpty())
			return;
		System.out.println("\n[ 안내 ] 등록된 모든 상품의 정보를 출력합니다.\n");
		// 출력 포맷을 일정하게 설정
		System.out.println("[상품 번호]\t[상품명]\t\t[가격]");
		System.out.println("------------------------------------------------------------");
		for (int i = 0; i < Config.productCnt; i++) {
			System.out.println("[" + (Config.productManager.product[i].productId + 1) + "]\t\t"
					+ Config.productManager.product[i].productName + "\t\t" + Config.productManager.product[i].price
					+ "원");

			System.out.println("------------------------------------------------------------");
		}
	}

	public void printSortedProduct() {
		if (checkProductListEmpty())
			return;

		System.out.println("[ 안내 ] 상품을 가격 낮은 순으로 정렬합니다.\n");

		Product[] sortedProducts = new Product[Config.productCnt];
		for (int i = 0; i < Config.productCnt; i++) {
			sortedProducts[i] = Config.productManager.product[i];
		}

		for (int i = 0; i < Config.productCnt - 1; i++) {
			for (int j = 0; j < Config.productCnt - 1 - i; j++) {
				if (sortedProducts[j].price > sortedProducts[j + 1].price) {
					Product temp = sortedProducts[j];
					sortedProducts[j] = sortedProducts[j + 1];
					sortedProducts[j + 1] = temp;
				}
			}
		}

		System.out.println("------------------------------------------------------------");
		for (int i = 0; i < Config.productCnt; i++) {
			System.out.println("[" + (sortedProducts[i].productId + 1) + "]\t\t" + sortedProducts[i].productName
					+ "\t\t" + sortedProducts[i].price + "원");
			System.out.println("------------------------------------------------------------");
		}
	}

	public void searchProductName() {
		boolean isFound = false;

		if (checkProductListEmpty())
			return;

		System.out.println("[ 안내 ] 찾는 상품의 이름을 검색하세요.");
		System.out.print(">> ");
		Config.scanner.nextLine();
		String productName = Config.scanner.nextLine();

		System.out.println("[상품 번호]\t[상품명]\t\t[가격]");
		System.out.println("------------------------------------------------------------");

		for (int i = 0; i < Config.productCnt; i++) {
			if (Config.productManager.product[i].productName.contains(productName)) {
				isFound = true;
				System.out.println("[" + (Config.productManager.product[i].productId + 1) + "]\t\t"
						+ Config.productManager.product[i].productName + "\t\t" + Config.productManager.product[i].price
						+ "원");
				System.out.println("------------------------------------------------------------");
			}
		}
		if (!isFound) {
			System.out.println("[ 안내 ] 찾는 상품이 없습니다.");
		}
	}

	public boolean checkProductListEmpty() {
		if (Config.productCnt == 0) {
			System.out.println("[ 안내 ] 등록된 상품이 없습니다.");
			return true;
		}
		return false;
	}
}