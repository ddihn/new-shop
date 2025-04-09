package shoppingmallProject.class0408.HW0408;

public class ProductManage {
    public final int MAX_PRODUCT_CNT = 500;
    // 전체 상품의 목록을 출력해야겠고
    // 전체 상품 목록에서 특정 상품 검색
    // 상품을 가격 순으로 정렬

    // 현재 상품의 수
    int productCnt = 0;
    Product[] product = new Product[MAX_PRODUCT_CNT];

    public void printAllProduct() {

	if (productCnt == 0) {
	    System.out.println("[ 안내 ] 등록된 상품이 없습니다.");
	} else {
	    System.out.println("[ 안내 ] 등록된 모든 상품의 정보를 출력합니다.\n");
	    // 출력 포맷을 일정하게 설정
	    System.out.println("[상품 번호]\t[상품명]\t\t[가격]");
	    System.out.println("------------------------------------------------------------");
	    for (int i = 0; i < this.productCnt; i++) {
		System.out.println("[" + (this.product[i].productId + 1) + "]\t\t" + this.product[i].productName
			+ "\t\t" + this.product[i].price + "원");

		System.out.println("------------------------------------------------------------");
	    }
	}
    }
}