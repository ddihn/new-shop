package shoppingmallProject.class0408.HW0408;

import java.util.Scanner;

public class Config {
	// 스캐너 클래스를 전역으로 공유
	public static Scanner scanner = new Scanner(System.in);

	// 회원인지 관리자인지를 전역으로 공유
	public static boolean isAdmin = false;

	// 이름을 전역으로 관리
	public static String name;
}
