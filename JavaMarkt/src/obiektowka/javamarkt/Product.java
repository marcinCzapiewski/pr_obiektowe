package obiektowka.shopping;

public class Product {
    private String code;
    private String name;
    private double price;
    private double discountPrice;

    Product(String code, String name, double price, double discountPrice) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [code=" + code + ", name=" + name + ", price=" + price + ", discountPrice=" + discountPrice
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (code != null ? !code.equals(product.code) : product.code != null) return false;

        return true;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

}