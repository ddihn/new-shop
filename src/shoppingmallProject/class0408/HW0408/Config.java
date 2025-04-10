package shoppingmallProject.class0408.HW0408;

import java.util.Scanner;

public class Config {
	// 상수
	public static final int MAX_PRODUCT_CNT = 500;

	// 공용 객체
	public static final Scanner scanner = new Scanner(System.in);
	public static final ProductManage productManager = new ProductManage();
	public static final CartManage cart = new CartManage();

	// 유저 권한 확인
	public static boolean isAdmin = false;

	// 등록된 상품 수
	public static int productCnt = 0;

}
