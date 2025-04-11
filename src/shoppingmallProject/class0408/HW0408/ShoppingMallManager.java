package shoppingmallProject.class0408.HW0408;

public class ShoppingMallManager {

	final String ADMIN_PW = "kopo1234"; // admin 입장 시 확인할 비밀번호
	final int MAX_CHANCE = 3; // 비밀번호 입력 기회

	public void startShopping() {
		String username = getUserData();
		User user = new User(username);

		if (Config.isAdmin == true) { // 관리자 권한이 true이면 관리자 모드, 아니면 일반 모드로 실행
			Admin admin = new Admin();
			admin.printAdminAction();
		}
		user.printUserAction();
	}

	public String getUserData() {
		greeting();
		System.out.println("[ 직원 ◟(∗❛ᴗ❛∗)◞ ] 어서오세요! 성함을 알려주시면 쇼핑몰 입장을 도와드리겠습니다.");
		System.out.print("[ 고객님 ◟( ˘ ³˘)◞ ] ");
		String name = Config.scanner.nextLine();
		System.out.println();

		// 일반 회원인지 관리자인지 체크
		checkAdmin(name);

		return name;
	}

	public void checkAdmin(String name) {

		while (true) {
			System.out.println("[ 직원 <(_ _)> ] 반갑습니다. " + name + "님! 관리자로 로그인할까요, 회원으로 입장할까요? (관리자: 0, 회원: 1 입력)");
			System.out.print("[ " + name + "님 ] ");
			String userInput = Config.scanner.next();
			Config.scanner.nextLine();

			if (userInput.equals("0")) {
				// 비밀번호 입력 기회는 3회
				int loginChance = 0;
				while (loginChance < MAX_CHANCE) {
					System.out.println("[ 직원 ◟(∗❛ᴗ❛∗)◞ ] 관리자 모드로 접근하려면 비밀번호를 입력하세요.");
					System.out.print("비밀번호 : ");
					String checkPw = Config.scanner.nextLine();
					if (checkPw.equals(ADMIN_PW)) {
						Config.isAdmin = true;
						System.out.print("\n[ 성공 ٩(•◡•)۶ ] 관리자 모드로 진입합니다.");
						return;
					} else {
						Config.isAdmin = false;
						System.out.println(
								"\n[ 안내 Σ(￣□￣;) ] 비밀번호가 틀렸습니다. 다시 입력해주세요. ( 오류 횟수:" + (loginChance + 1) + "번 ) \n");
						// 비밀번호 오류 횟수 증가
						loginChance++;
					}
				}
				System.out.print("\n[ 실패 Σ(￣□￣;) ] 관리자 계정으로 접근할 수 없습니다. 일반 회원으로 입장합니다.");
				return;
			} else if (userInput.equals("1")) {
				Config.isAdmin = false;
				System.out.print("\n[ 직원 ◟(∗❛ᴗ❛∗)◞ ] 일반 회원으로 입장합니다.");
				return;
			} else {
				System.out.print("\n[ 실패 Σ(￣□￣;) ] 잘못된 입력입니다. 다시 입력해주세요. ( 관리자: 0, 회원: 1 입력 )");
			}
		}
	}

	public void greeting() {

		final String RESET = "\u001B[0m";
		final String ORANGE = "\u001B[38;5;226m";

		System.out.println(ORANGE + "*******************************************************");
		System.out.println("*   __        __   _                                  *");
		System.out.println("*   \\ \\      / /__| | ___ ___  _ __ ___   ___         *");
		System.out.println("*    \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\        *");
		System.out.println("*     \\ V  V /  __/ | (_| (_) | | | | | |  __/        *");
		System.out.println("*      \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|        *");
		System.out.println("*                                                     *");
		System.out.println("*******************************************************" + RESET);
	}

}
