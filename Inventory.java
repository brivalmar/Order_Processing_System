import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
/**
    Briley Marchetti
**/

public class Inventory{
    // This will implement an ArrayList of InventoryItems

    protected ArrayList<InventoryItem> itemList;

    public Inventory(ArrayList<InventoryItem> itemList){
        this.itemList = new ArrayList<InventoryItem>();
    }

    // So far...read in from 'inventoryItem.txt' to establish ArrayList of items.
    public void readItemList(){
        try{

            File file = new File("inventoryItem.txt");
            Scanner readIn = new Scanner(file);
            itemList = new ArrayList<InventoryItem>();

            // Parses line by line of text file to create an InventoryItem and adds it to an ArrayList
            while(readIn.hasNext()){

                int itemNumber = (readIn.nextInt());
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
                System.out.println();

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
    }

    // Getter
    public ArrayList<InventoryItem> getItemList(){
        return this.itemList;
    }
}
