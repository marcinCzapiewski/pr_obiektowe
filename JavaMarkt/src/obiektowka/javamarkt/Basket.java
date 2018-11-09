package obiektowka.shopping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalDouble;

public class Basket {
    private ArrayList<Product> productsList;
    private double cost;

    Basket() {
        productsList = new ArrayList<Product>();
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void addProduct(Product product) {
        productsList.add(product);
        setCost();
    }

    public void removeProduct(Product product) {
        productsList.remove(product);
        setCost();
    }

    public Product getCheapestProduct() throws Exception
    {
        if(productsList.isEmpty()) {
            throw new Exception("Empty list");
        }

        Product cheapestProduct = productsList.get(0);
        for(Product product : productsList) {
            if(product.getPrice() < cheapestProduct.getPrice()) {
                cheapestProduct = product;
            }
        }

        return cheapestProduct;
    }

    public Product getMostExpensiveProduct() throws Exception
    {
        if(productsList.isEmpty()) {
            throw new Exception("Empty list");
        }

        Product cheapestProduct = productsList.get(0);
        for(Product product : productsList) {
            if(product.getPrice() < cheapestProduct.getPrice()) {
                cheapestProduct = product;
            }
        }

        return cheapestProduct;
    }

    public void sortByPrice() {
        Collections.sort(productsList, Comparator.comparing(Product::getPrice));
    }

    public void sortByName() {
        Collections.sort(productsList, Comparator.comparing(Product::getName));
    }

    public double getSumOfPrices() {
        double sum = 0;
        for(Product product : productsList) {
            sum += product.getPrice();
        }

        return sum;
    }

    public void showProductsInfo() {
        for(Product product : productsList) {
            System.out.println(product.toString());
        }

        System.out.println("Total cost: " + cost);
    }

    private void applyDiscounts() {
        if(productsList.size() > 2) {
            sortByPrice();
            Product gratis = productsList.get(0);
            gratis.setDiscountPrice(gratis.getPrice());
        }

        Product discountCouponProduct = new Product("XCoup", null);
        Product productToDiscount;
        for(Product product : productsList) {
            if(product.equals(discountCouponProduct)) {
                discountCouponProduct = product;
                for(Product product2 : productsList) {
                    if(product2.getName() == discountCouponProduct.getName()) {
                        product2.setPrice(product2.getPrice() * 0.7);
                    }
                }
            }
        }

        cost = getSumOfPrices();
        if(cost > 300) {
            cost = 0.95 * cost;
        }

        Product mug = new Product("x125", "Kubek firmowy", 0, 0);
        if(cost > 200 && !productsList.contains(mug)) {
            productsList.add(mug);
        } else if (cost < 200 && productsList.contains(mug)) {
            removeProduct(mug);
        }
    }

    public void setCost() {
        cost = getSumOfPrices();
        applyDiscounts();
    }
}
