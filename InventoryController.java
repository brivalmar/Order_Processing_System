import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
/**
    Briley Marchetti
**/

public class InventoryController{

    public static void main(String[] args){

        // Some test objects
        InventoryItem first = new InventoryItem(1, "Shirt", 5, "Large", 1.99, 4.99);
        Customer c1 = new Customer("John", "Smith", "1 Penn Lane", "1 Penn Lane", "DEBIT");
        Transaction t1 = new Order(first, c1, 001, 2);

        ArrayList<InventoryItem> itemList = readItemList();
        //System.out.println("Here: " + itemList.get(0));
        writeOutInventoryItems(itemList);
    }


    // So far...read in from 'inventoryItem.txt' to establish ArrayList of items.
    public static ArrayList<InventoryItem> readItemList(){
        ArrayList<InventoryItem> itemList = new ArrayList<InventoryItem>();
        try{
            File file = new File("inventoryItem.txt");
            Scanner readIn = new Scanner(file);

            // Parses line by line of text file to create an InventoryItem and adds it to an ArrayList
            while(readIn.hasNext()){

                int itemNumber = readIn.nextInt();
                //System.out.println(itemNumber);

                String itemName = readIn.next();
                //System.out.println(itemName);

                int itemQuantity = readIn.nextInt();
                //System.out.println(itemQuantity);

                String productDescription = readIn.next();
                //System.out.println(productDescription);

                double unitCost = readIn.nextDouble();
                //System.out.println(unitCost);

                double price = readIn.nextDouble();
                //System.out.println(price);

                //Space for testing purposes. Will not be logging all of this.
                //System.out.println();

                itemList.add(new InventoryItem(itemNumber, itemName, itemQuantity, productDescription, unitCost, price));
            }

            readIn.close();

        } catch(FileNotFoundException f1){
            System.out.println("File not found.");
        }

        //TEST FUNCTIONALITY OF ADDING INVENTORY ITEMS
        System.out.println("Print names: ");
        for(int i = 0; i < itemList.size(); i++){
            System.out.println(itemList.get(i).getItemName());
        }
        return itemList;
    }


    // Write Inventory ArrayList to a text file
    public static void writeOutInventoryItems(ArrayList<InventoryItem> itemList){
        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("inventoryWriteOut.txt")))){

            for(int i = 0; i < itemList.size(); i++){
                bufferedWriter.write(Integer.toString(itemList.get(i).getItemNumber()));
                bufferedWriter.newLine();

                bufferedWriter.write(itemList.get(i).getItemName());
                bufferedWriter.newLine();

                bufferedWriter.write(Integer.toString(itemList.get(i).getItemQuantity()));
                bufferedWriter.newLine();

                bufferedWriter.write(itemList.get(i).getProductDescription());
                bufferedWriter.newLine();

                bufferedWriter.write(Double.toString(itemList.get(i).getUnitCost()));
                bufferedWriter.newLine();

                bufferedWriter.write(Double.toString(itemList.get(i).getItemPrice()));
                bufferedWriter.newLine();
            }

			System.out.println("Done writing!");

		} catch (IOException e){
			e.printStackTrace();
		}
    }

}
