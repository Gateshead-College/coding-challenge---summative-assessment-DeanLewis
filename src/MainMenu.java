import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    ArrayList<Product> products = new ArrayList<>();
    private boolean exit = false;

    public void getData() {
        Initialise init = new Initialise();
        products = init.getProducts(init.readFile(Initialise.productsFile));
        while(!exit)
        menu();
    }


    public void menu() {
        System.out.println("Please select an option from the list below:");
        System.out.println("1 - View Products");
        System.out.println("2 - Add a new Product");
        System.out.println("3 - Edit a Product");
        System.out.println("4 - Remove a Product");
        System.out.println("5 - Exit");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {

            case 1:
                displayProducts();
                break;

            case 2:
                addProduct();
                break;

            case 3:
                editProduct();
                break;

            case 4:
                removeProduct();
                break;

            case 5:
                exitApplication();
                break;

            default:
                System.out.println("Invalid input provided, please try again");
                break;
        }
    }

    private void removeProduct() {
        System.out.println("Please select the item you want to remove:");
        int count = 1;
        for (Product p : products) {
            System.out.println(count + " - " + p.productName);
            count++;
        }
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        products.remove(choice - 1);
    }

    private void editProduct() {
        System.out.println("Please enter the ID of the product you want to edit");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        Product editProduct = null;
        for (Product p : products) {
            if (p.productID == id) {
                editProduct = p;
                break;
            }
        }
        System.out.println("Which field do you want to change?");
        System.out.println("1 - ID");
        System.out.println("2 - Manufacturer");
        System.out.println("3 - Name");
        System.out.println("4 - Price");
        System.out.println("5 - Stock");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Please enter the new value:");
        if (editProduct != null) {
            if (choice == 1) {
                editProduct.productID = Integer.parseInt(new Scanner(System.in).nextLine());
            } else if (choice == 2) {
                editProduct.productManufacturer = new Scanner(System.in).nextLine();
            } else if (choice == 3) {
                editProduct.productName = new Scanner(System.in).nextLine();
            } else if (choice == 4) {
                editProduct.productPrice = Double.parseDouble(new Scanner(System.in).nextLine());
            } else if (choice == 5) {
                editProduct.productStock = Integer.parseInt(new Scanner(System.in).nextLine());
            } else {
                System.out.println("Invalid input provided, please try again.");
                editProduct();
            }
        }
        /*
        This section of commented code has been kept to demonstrate how we
        could create a dynamic list of all products currently stocked
        within the business.
         */
//        System.out.println("Please select the product you want to make changes to:");
//        int count = 1;
//        for(Product p : products){
//            System.out.println(count + " - " + p.ProductName);
//            count++;
//        }
    }

    private void addProduct() {
        System.out.println("Please enter the product details.");
        System.out.println("Product ID: ");
        int productID = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Product Manufacturer: ");
        String productManufacturer = new Scanner(System.in).nextLine();
        System.out.println("Product Name: ");
        String productName = new Scanner(System.in).nextLine();
        System.out.println("Product Price: ");
        double productPrice = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.println("Quantity in Stock: ");
        int productStock = Integer.parseInt(new Scanner(System.in).nextLine());
        products.add(new Product(productID, productManufacturer, productName, productPrice, productStock));
    }

    private void exitApplication() {
        Initialise.writeData(products);
        products.clear();
        exit = true;
    }

    private void displayProducts() {
        for (Product p : products) {
            System.out.println("ID: " + p.productID + " - Manufacturer: " + p.productManufacturer + " - Name: " + p.productName
                    + " - Price: " + p.productPrice + " - Current Stock: " + p.productStock);
        }
    }
}
