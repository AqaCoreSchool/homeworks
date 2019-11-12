package homework;

public class Product {

    private String productName;
    private float price;

    public Product(String name, Float price) {
        setName(name);
        setPrice(price);
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }
}
