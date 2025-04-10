package shoppingmallProject.class0408.HW0408;

public class CartItem {

	Product product = new Product();
	int quantity;
	int totalPrice;

	public void calcTotalPrice() {
		this.totalPrice = quantity * product.price;
	}

}
