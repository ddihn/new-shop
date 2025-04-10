package shoppingmallProject.class0408.HW0408;

import java.util.Scanner;

public class Config {
	// 스캐너 클래스
	public static Scanner scanner = new Scanner(System.in);

	// 회원인지 관리자인지를
	public static boolean isAdmin = false;

	// 이름
	public static String name;

	// 최대 등록 가능한 상품 수
	public static final int MAX_PRODUCT_CNT = 500;

	// 현재 상품의 수

	public static int productCnt = 0;

	// 상품 관리
	public static ProductManage productManager = new ProductManage();

	public static CartManage cart = new CartManage();

	// 최대한 static 안 쓸 수 있는 것들은 빼보기
}
