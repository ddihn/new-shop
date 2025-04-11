package shoppingmallProject.class0408.HW0408;

public class Admin {
	// 상품의 추가, 삭제, 수정 권한

	public void printAdminAction() {
		while (true) {
			System.out.println("\n--------------------------< 관리자 메뉴 >--------------------------\n");
			System.out.println("1. 전체 상품 보기 | 2. 상품 등록 | 3. 상품 삭제 | 4. 상품 정보 수정 | 5. 작업 종료");
			System.out.print("번호 선택 : ");
			String adminInput = Config.scanner.next();

			switch (adminInput) {
			case "1":
				Config.productManager.printAllProduct();
				break;

			case "2":
				registerProduct();
				break;

			case "3":
				Config.productManager.printAllProduct();
				removeProduct();
				break;

			case "4":
				Config.productManager.printAllProduct();
				modifyProduct();
				break;

			case "5":
				System.out.println("\n[ 성공 ] 관리자 작업을 종료합니다. 일반 회원으로 다시 입장합니다.");
				return;

			default:
				System.out.println("[ 실패 ] 잘못된 입력입니다. 다시 선택해주세요.");
				break;
			}
		}
	}

	public void registerProduct() {
		if (Config.productCnt >= Config.MAX_PRODUCT_CNT) {
			System.out.println("\n[ 실패 ] 등록 가능한 상품 수를 초과해 상품 등록이 불가합니다.");
			return;
		}

		System.out.println("\n--------------------------< 상품 등록 >--------------------------\n");
		System.out.println("[ 안내 ] 최대 " + Config.MAX_PRODUCT_CNT + "건의 상품을 등록할 수 있습니다. ( 그만 등록하려면 0 )");
		while (true) {

			System.out.println("현재 등록된 상품 수 : " + Config.productCnt);

			Product newProduct = new Product();
			Config.scanner.nextLine(); // 버퍼 비우기

			System.out.print("상품 이름 : ");
			newProduct.productName = Config.scanner.nextLine();

			if (newProduct.productName.equals("0")) {
				System.out.println("[ 안내 ] 상품 등록을 중단합니다.");
				return;
			}

			System.out.print("상품 가격( 원 단위, 숫자만 입력 ) : ");
			newProduct.price = Config.scanner.nextInt();

			newProduct.productId = Config.productCnt;
			Config.productManager.product[Config.productCnt] = newProduct;
			Config.productCnt++;

			System.out.println("\n[ 성공 ] 상품 등록이 완료되었습니다.");
		}
	}

	public void removeProduct() {
		if (checkProductListEmpty())
			return;

		System.out.println("\n--------------------------< 상품 삭제 >--------------------------\n");
		System.out.print("삭제할 상품 번호 : ");
		int removeProductId = Config.scanner.nextInt();
		int removeIdx = removeProductId - 1;

		if (removeIdx < 0 || removeIdx >= Config.productCnt) {
			System.out.println("[ 실패 ] 일치하는 상품을 찾지 못했습니다.");
			return;
		}

		while (true) {
			System.out.println(removeProductId + "번 상품을 정말 삭제할까요? (y/n)");
			System.out.print(">> ");
			String answer = Config.scanner.next();

			if (answer.equals("y")) {
				// 인덱스 값으로 변환하기 위해 1빼줌
				for (int i = removeIdx; i < Config.productCnt - 1; i++) {
					Config.productManager.product[i] = Config.productManager.product[i + 1];
					Config.productManager.product[i].productId = i;
				}

				Config.productManager.product[Config.productCnt - 1] = null;
				Config.productCnt--;
				System.out.println("\n[ 성공 ] 상품 삭제가 완료되었습니다.");
				return;

			} else if (answer.equals("n")) {
				System.out.println("\n[ 안내 ] 상품 삭제를 취소했습니다.");
				return;

			} else {
				System.out.println("\n[ 실패 ] 잘못된 입력입니다. 다시 입력해주세요.(y/n)");
			}
		}
	}

	public void modifyProduct() {
		if (checkProductListEmpty())
			return;
		System.out.println("\n< 상품 정보 수정 >\n");

		while (true) {
			System.out.print("수정할 상품 번호 : ");
			int modifyProductId = Config.scanner.nextInt();
			int modifyIdx = modifyProductId - 1;

			if (modifyIdx < 0 || modifyIdx >= Config.productCnt) {
				System.out.println("[ 실패 ] 잘못된 입력입니다. 다시 입력해주세요.");
			} else {
				Config.scanner.nextLine();
				System.out.print("상품 이름 : ");
				Config.productManager.product[modifyIdx].productName = Config.scanner.nextLine();

				System.out.print("상품 가격( 원 단위, 숫자만 입력 ) : ");
				Config.productManager.product[modifyIdx].price = Config.scanner.nextInt();

				System.out.println("\n[ 성공 ] 상품 수정이 완료되었습니다.");
				return;
			}
		}
	}

	public boolean checkProductListEmpty() {
		if (Config.productCnt == 0) {
			return true;
		}
		return false;
	}
}
