package shoppingmallProject.class0408.HW0408;

public class User {

	String name;

	public User(String name) {
		this.name = name;
	}

	public void printUserAction() {
		while (true) {
			System.out.println("\n--------------------------< 장보기 메뉴 >--------------------------\n");
			System.out.println("1. 전체 상품 보기 | 2. 장바구니 담기 | 3. 장바구니 확인 | 4. 구매하기 | 5. 나가기");
			System.out.print("번호 선택 : ");
			String adminInput = Config.scanner.next();

			switch (adminInput) {
			case "1":
				ProductManage manager = new ProductManage();
				manager.selectProductView();
				break;
			case "2":
				Config.cart.selectProduct();
				break;
			case "3":
				Config.cart.printCartItem();
				break;
			case "4":
				Config.cart.orderCartItem();
				break;
			case "5":
				System.out.print("\n[ 성공 <(_ _)> ] 쇼핑을 종료합니다. " + name + "님, 안녕히 가시고 또 들러주세요!\n");
				adios();
				return;
			default:
				System.out.print("\n[ 실패 Σ(￣□￣;) ] 잘못된 입력입니다. 다시 선택해주세요.");
				break;
			}

		}
	}

	public void adios() {

		final String RESET = "\u001B[0m";
		final String CYAN = "\u001B[38;5;51m";

		System.out.println(CYAN + "*******************************************************");
		System.out.println("*                ____   __   __  ______               *");
		System.out.println("*               | __ )  \\ \\ / / | ____|               *");
		System.out.println("*               |  _ \\   \\ \\//  |  _|                 *");
		System.out.println("*               | |_) |   | |   |  ___                *");
		System.out.println("*               |____/    |_|   |_____|               *");
		System.out.println("*******************************************************" + RESET);

	}
}
