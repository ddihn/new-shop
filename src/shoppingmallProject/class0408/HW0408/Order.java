package shoppingmallProject.class0408.HW0408;

public class Order {

	String orderName;
	String phoneNum;
	String address;

	public void getShippingInfo() {
		System.out.println("------------------------< 배송 정보 입력 >------------------------\n");

		// 주문자 성함
		System.out.println("[ 안내 ] 주문자 성함을 입력해주세요.");
		System.out.print(">> ");
		this.orderName = Config.scanner.nextLine();

		// 연락처
		System.out.println("\n[ 안내 ] 연락처를 입력해주세요.");
		System.out.print(">> ");
		this.phoneNum = Config.scanner.nextLine();

		// 주소
		System.out.println("\n[ 안내 ] 배송받을 주소를 입력해주세요.");
		System.out.print(">> ");
		this.address = Config.scanner.nextLine();
	}

	public void checkRightShippingInfo() {
		while (true) {
			System.out.println("------------------------< 배송 정보 확인 >------------------------\n");
			System.out.println("[ 안내 ] 입력하신 배송 정보가 맞는지 확인해주세요. (맞으면 y / 재입력은 n)");
			printShippingInfo();
			System.out.print(">> ");
			String answer = Config.scanner.nextLine();
			if (answer.equals("y")) {
				return;
			} else if (answer.equals("n")) {
				Config.scanner.nextLine();
				getShippingInfo();
			} else {
				System.out.println("[ 실패 ] 잘못된 입력입니다. 다시 입력해주세요. ( y / n 중 입력)");
			}
		}
	}

	public void printShippingInfo() {
		System.out.println("주문자 성함 : " + this.orderName);
		System.out.println("연락처 : " + this.phoneNum);
		System.out.println("배송 주소: " + this.address);
	}
}
