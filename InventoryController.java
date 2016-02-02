import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
/**
    Briley Marchetti
**/

public class InventoryController{

    public static void main(String[] args){

        // Call methods to read text files of items and customers
        ArrayList<InventoryItem> itemList = readItemList();
        ArrayList<Customer> customerList = readCustomerList();

        // Tests an order
        Order t1 = new Order(itemList.get(0), customerList.get(0), 001, 2);
        t1.checkAndSubtractInventoryItemQuantity(t1.getInventoryItem());

        // Writes out itemList with new quanitties if adjusted
        writeOutInventoryItems(itemList);
    }



    // Read in from 'inventoryItem.txt' to establish ArrayList of items.
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
            System.out.println("InventoryItem.txt was not found.");
        }

        return itemList;
    }


    // Write Inventory ArrayList to a text file
    public static void writeOutInventoryItems(ArrayList<InventoryItem> itemList){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("inventoryItem.txt")))){

            System.out.println("Writing out itemList to inventoryItem.txt.");

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

			System.out.println("Done writing to inventoryItem.txt!");

		} catch (IOException e){
			e.printStackTrace();
		}
    }


    //Customer input from text file
    public static ArrayList<Customer> readCustomerList(){
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        try{
            File file = new File("customer.txt");
            Scanner readIn = new Scanner(file);

            // Parses line by line of text file to create a Customer and adds it to the Customer ArrayList
            // Customers only have two fields firstName and lastName for now
            while(readIn.hasNext()){

                String customerFirstName = readIn.next();
                // System.out.println(customerFirstName);

                String customerLastName = readIn.next();
                // System.out.println(customerLastName);

                customerList.add(new Customer(customerFirstName, customerLastName));
            }

            readIn.close();

        } catch(FileNotFoundException f1){
            System.out.println("Customer.txt was not found.");
        }
        return customerList;
    }
}
