import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
    Briley Marchetti
**/

public class InventoryController{

    // Read in from 'inventoryItem.txt' to establish ArrayList of items.
    public static ArrayList<InventoryItem> readItemList(){
        System.out.println("Reading itemList.");
        ArrayList<InventoryItem> itemList = new ArrayList<InventoryItem>();
        try{
            File file = new File("inventoryItem.txt");
            Scanner readIn = new Scanner(file);

            // Parses line by line of text file to create an InventoryItem and adds it to an ArrayList
            while(readIn.hasNext()){
                int itemNumber = readIn.nextInt();
                String itemName = readIn.next();
                int itemQuantity = readIn.nextInt();
                String productDescription = readIn.next();
                double unitCost = readIn.nextDouble();
                double price = readIn.nextDouble();

                itemList.add(new InventoryItem(itemNumber, itemName, itemQuantity, productDescription, unitCost, price));
            }

            readIn.close();

        } catch(FileNotFoundException f1){
            System.out.println("InventoryItem.txt was not found.");
        }
        System.out.println("Done reading itemList.\n");
        return itemList;
    }


    // Write Inventory ArrayList to a text file
    public static void writeOutInventoryItems(ArrayList<InventoryItem> itemList){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("inventoryItem.txt")))){

            System.out.println("\nWriting out itemList to inventoryItem.txt.");

            for(int i = 0; i < itemList.size(); i++){
                bufferedWriter.write(Integer.toString(itemList.get(i).getItemNumber()) + "\n");
                bufferedWriter.write(itemList.get(i).getItemName() + "\n");
                bufferedWriter.write(Integer.toString(itemList.get(i).getItemQuantity()) + "\n");
                bufferedWriter.write(itemList.get(i).getProductDescription() + "\n");
                bufferedWriter.write(Double.toString(itemList.get(i).getUnitCost()) + "\n");
                bufferedWriter.write(Double.toString(itemList.get(i).getItemPrice()) + "\n");
            }

			System.out.println("Done writing to inventoryItem.txt!");

		} catch (IOException e){
			e.printStackTrace();
		}
    }
}
