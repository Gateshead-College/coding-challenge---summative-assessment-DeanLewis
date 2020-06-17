public class Product {

    public int productID;
    public String productManufacturer;
    public String productName;
    double productPrice;
    int productStock;

    public Product(int productID, String productManufacturer, String productName, double productPrice, int productStock) {
        this.productID = productID;
        this.productManufacturer = productManufacturer;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}
