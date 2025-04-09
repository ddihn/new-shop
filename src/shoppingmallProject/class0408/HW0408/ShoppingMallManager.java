package shoppingmallProject.class0408.HW0408;

// 여기서 일반 회원인지 관리자인지 바로 객체 할당해서 넘겨줘

// 근데 그럼 누군지 항상 객체 자체가 올라와있어야 되는거 아닌가? 그냥 할까?

public class ShoppingMallManager {
	// admin 입장시 확인할 비밀번호
	final String ADMIN_PW = "kopo1234";
	// 비밀번호 입력 기회는 3회, 초과 시 일반 회원으로 입장
	final int MAX_CHANCE = 3;

	public void getUserData() {

		System.out.println("[ 직원 ] 어서오세요!");
		System.out.println("[ 직원 ] 성함을 알려주시면 쇼핑몰 입장을 도와드리겠습니다.");
		System.out.print("[ 고객님 ] ");
		String name = Config.scanner.next();
		System.out.println();

		// 이름 전역으로 저장
		Config.name = name;

		// 일반 회원인지 관리자인지 체크
		checkAdmin(name);
	}

	// 들어온 사람이 user인지 admin인지 확인하는 메소드
	public void checkAdmin(String name) {

		while (true) {
			System.out.println("[ 직원 ] 반갑습니다. " + name + "님! 관리자로 로그인할까요, 회원으로 입장할까요? (관리자: 0, 회원: 1 입력)");
			System.out.print("[ " + name + "님 ] ");
			String userInput = Config.scanner.next();
			if (userInput.equals("0")) {
				// 비밀번호 입력 기회는 3회
				int loginChance = 0;
				while (loginChance < MAX_CHANCE) {
					System.out.println("[ 직원 ] 관리자로 접근하려면 비밀번호를 입력하세요.");
					System.out.print("비밀번호 : ");
					String checkPw = Config.scanner.next();
					if (checkPw.equals(ADMIN_PW)) {
						Config.isAdmin = true;
						System.out.println("[ 직원 ] 관리자로 로그인 합니다.");
						return;
					} else {
						Config.isAdmin = false;
						System.out.println("\n[ 안내 | 비밀번호가 틀렸습니다. 다시 입력해주세요. ( 오류 횟수:" + (loginChance + 1) + "번 ) ]\n");
						// 비밀번호 오류 횟수 증가
						loginChance++;
					}
				}
				System.out.println("[ 직원 ] 관리자 계정으로 접근할 수 없습니다. 일반 회원으로 입장합니다.");
				return;
			} else if (userInput.equals("1")) {
				Config.isAdmin = false;
				System.out.println("[ 직원 ] 일반 회원으로 입장합니다.");
				return;
			} else {
				System.out.println("[ 직원 ] 잘못된 입력입니다. 다시 입력해주세요. ( 관리자: 0, 회원: 1 입력 )");
			}
		}
	}

}
