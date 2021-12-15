import java.io.*;
import java.util.ArrayList;

public class Initialise {

    //A static variable that holds the path to the text file for the products
    static File productsFile = new File("C:/Users/Deanl/Desktop/Products.txt");

    //Checks to see if the file exists or not. If it does not exist then
    //the file will be created.

    //Without this the application will crash if the text file is not present.
    public void createFileIfNotExists(){
        try {
            if (!productsFile.isFile()) {
                productsFile.createNewFile();
            }
        }
        catch(IOException ioEx){
            System.out.println("Encountered an error trying to create text file");
            ioEx.printStackTrace();
        }
    }

    /**
     *
     * @param products An arraylist of product objects
     * @throws IOException if writing to the text file fails
     */
    public static void writeData(ArrayList<Product> products) {
        try {
            //creates a new FileWriter object that will be used to write information to the file provided to it (productsFile)
            FileWriter writer = new FileWriter(productsFile);

            //iterate over the arraylist of products that has been passed into the method. For Each.
            for (Product p : products) {
                //Similar to sout this will write the below string to the text file. Separating each value with a comma.
                writer.write(p.productID + "," + p.productManufacturer + "," + p.productName
                        + "," + p.productPrice + "," + p.productStock);
                //add a new line so each product is on its own line and not all on one big line.
                writer.write("\n");
            }
            //close the connection to the file.
            writer.close();
        } catch (IOException ioex) {
            System.out.println("Failed to write to file");
            ioex.printStackTrace();
        }
    }

    /**
     *
     * @param file The file that is to be read
     * @return an ArrayList of Strings that has been read in to the program from the text file.
     * @throws IOException if reading from the text file fails.
     */
    public ArrayList<String> readFile(File file) {
        //This is the first instance where we try to use the text file, as such we check if it exists first.
        createFileIfNotExists();
        //A new arraylist to store each line of the text file.
        ArrayList<String> lines = new ArrayList<>();
        try {
            //Create a new FileReader object that will read data from the file provided.
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            //A loop that will continue reading from the text file while there is another line in the file.
            while ((line = br.readLine()) != null) {
                //add the line that has been read to the arraylist.
                lines.add(line);
            }
            //close the connection to the file.
            reader.close();
        } catch (IOException ioex) {
            System.out.println("Failed to read the file");
            ioex.printStackTrace();
        }
        //return the arraylist with the lines read in from the text file.
        return lines;
    }

    /**
     *
     * @param productString - A single line from the text file
     * @return A product object created from the String.
     */
    private Product getProductFromString(String productString) {
        //Create a new product variable.
        Product p;
        //Create an array that will be populated with strings.
        //The line from the text file will be split at each comma found.
        //A string read in from the text file - 12,EVGA,RTX 3090Ti,1300.0,4
        //When this string is split at each comma the array will be populated as below
        //pd = {"12", "EVGA", "RTX 3090Ti", "1300.0", "4"}
        String[] pd = productString.split(",");
        //create a new product object using the constructor from the Product class with the values stored in the pd Array.
        p = new Product(Integer.parseInt(pd[0]), pd[1], pd[2], Double.parseDouble(pd[3]), Integer.parseInt(pd[4]));
        //Return the Product object that has been created.
        return p;
    }

    /**
     *
     * @param productStrings - Takes in the ArrayList of Strings read in from the text file.
     * @return products - Returns an ArrayList of Products after they have been converted from Strings to Products
     */
    public ArrayList<Product> getProducts(ArrayList<String> productStrings) {
        //Create a new ArrayList of type Product
        ArrayList<Product> products = new ArrayList<>();
        //For each String read in from the text file
        for (String s : productStrings) {
            //Create a new product Object using the getProductFromString() method
            //passing in the String currently assigned to 's' in the for each loop.
            //Add the Product object returned from the getProductFromString() method to the ArrayList 'products'
            products.add(getProductFromString(s));
        }
        //Return the ArrayList of Product objects that have been read into the program as Strings
        //and converted into Product objects.
        return products;
    }
}
