package obiektowka.shopping;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product product1 = new Product("X123", "GTX960", 150, 0d);
        Product product2 = new Product("X124", "GTX1050", 2000, 100);
        Product product3 = new Product("X125", "GTX1160Ti", 3000, 0);
        Product discountCoupon = new Product("XCoup", "GTX960");

        List<Product> productsList = new ArrayList<>();

        Basket basket = new Basket();

        basket.addProduct(product1);
        basket.showProductsInfo();

        basket.addProduct(product2);
        basket.showProductsInfo();

        basket.removeProduct(product2);
        basket.showProductsInfo();

        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.showProductsInfo();

        basket.addProduct(discountCoupon);
        basket.showProductsInfo();

    }
}
