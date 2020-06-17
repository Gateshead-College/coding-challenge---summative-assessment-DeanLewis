import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {

    File products;

    private void writeToFIle(){
        try {
            products = new File("C:/Users/Deanl/Desktop/products.txt");
            FileWriter writer = new FileWriter(products);
            writer.write("This is a test");
            writer.close();
        }
        catch(IOException IOEx) {
            System.out.println("Failed to write to file");
        }
    }

    public static void main(String[] args) {
        FileWriting fw = new FileWriting();
        fw.writeToFIle();
    }

}
