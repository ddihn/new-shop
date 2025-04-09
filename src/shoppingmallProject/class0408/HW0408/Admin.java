package shoppingmallProject.class0408.HW0408;

public class Admin {

	ProductManage productManager = new ProductManage();

	// 상품의 추가, 삭제, 수정
	public void printAdminAction() {
		while (true) {
			System.out.println("\n--------------------------관리자 메뉴--------------------------");
			System.out.println("1. 상품 등록 | 2. 상품 삭제 | 3. 상품 정보 수정 | 4. 작업 종료");
			System.out.print("번호 선택 : ");
			String adminInput = Config.scanner.next();

			if (adminInput.equals("1")) {
				registerProduct();
			} else if (adminInput.equals("2")) {
				productManager.printAllProduct();
				removeProduct();
			} else if (adminInput.equals("3")) {
				productManager.printAllProduct();
				modifyProduct();
			} else if (adminInput.equals("4")) {
				System.out.println("관리자 작업을 종료합니다. 쇼핑몰을 나갑니다.");
				return;
			} else {
				System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			}
		}
	}

	public void registerProduct() {
		if (productManager.productCnt < productManager.MAX_PRODUCT_CNT) {
			System.out.println("\n--------------------------상품 등록--------------------------");
			System.out.println("[ 안내 ] 최대 " + productManager.MAX_PRODUCT_CNT + "건의 상품을 등록할 수 있습니다. 현재 등록된 상품 수 : "
					+ productManager.productCnt);

			productManager.product[productManager.productCnt] = new Product();

			Config.scanner.nextLine(); // 개행 제거용
			System.out.print("상품 이름 : ");
			productManager.product[productManager.productCnt].productName = Config.scanner.nextLine();
			System.out.print("상품 가격( 원 단위, 숫자만 입력 ) : ");
			productManager.product[productManager.productCnt].price = Config.scanner.nextInt();
			// product 등록 순서대로 id값 부여
			productManager.product[productManager.productCnt].productId = productManager.productCnt;
			productManager.productCnt++; // 등록 후 상품 수 증가

			System.out.println("[ 완료 ] 상품 등록이 완료되었습니다.");
		} else {
			System.out.println("등록 가능한 상품 수를 초과해 상품 등록이 불가합니다.");
		}
	}

	public void removeProduct() {
		if (productManager.productCnt == 0) {
			return;
		} else {
			System.out.println("\n[ 상품 삭제 ]");
			System.out.print("삭제할 상품 번호 : ");
			int removeProductId = Config.scanner.nextInt();
			int removeIdx = removeProductId - 1;

			if (removeIdx < 0 || removeIdx > productManager.productCnt) {
				System.out.println("일치하는 상품을 찾지 못했습니다.");
				return;
			}

			while (true) {
				System.out.println(removeProductId + "번 상품을 정말 삭제할까요? (y/n)");
				System.out.print(">> ");
				String answer = Config.scanner.next();

				if (answer.equals("y")) {
					// 인덱스 값으로 변환하기 위해 1빼줌
					for (int i = removeIdx; i < productManager.productCnt - 1; i++) {
						productManager.product[i] = productManager.product[i + 1];
						productManager.product[i].productId = i;
					}

					productManager.product[productManager.productCnt - 1] = null;
					productManager.productCnt--;
					System.out.println("[ 완료 ] 상품 삭제가 완료되었습니다.");
					return;

				} else if (answer.equals("n")) {
					System.out.println("[ 완료 ] 상품을 삭제하지 않습니다.");
					return;

				} else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.(y/n)");
				}
			}
		}
	}

	public void modifyProduct() {
		if (productManager.productCnt == 0) {
			return;
		} else {
			System.out.println("[ 상품 정보 수정 ]");

			while (true) {
				System.out.print("수정할 상품 번호 : ");
				int modifyProductId = Config.scanner.nextInt();
				modifyProductId--;

				if (modifyProductId < 0 || modifyProductId >= productManager.productCnt) {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				} else {
					Config.scanner.nextLine();
					System.out.print("상품 이름 : ");
					productManager.product[modifyProductId].productName = Config.scanner.nextLine();
					System.out.print("상품 가격( 원 단위, 숫자만 입력 ) : ");
					productManager.product[modifyProductId].price = Config.scanner.nextInt();

					System.out.println("[ 완료 ] 상품 수정이 완료되었습니다.");
					return;
				}
			}
		}
	}
}
