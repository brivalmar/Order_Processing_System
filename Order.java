import java.io.*;
import java.sql.*;
/**
    Briley Marchetti
**/

public class Order extends Transaction{

    protected int quantityOfOrder;

    public Order(InventoryItem i1, Customer c1, int transactionNumber, int quantityOfOrder){
        super(i1, c1, transactionNumber);
        this.quantityOfOrder = quantityOfOrder;
    }

    // Getters
    public InventoryItem getInventoryItem(){
        return this.i1;
    }
    public Customer getCustomer(){
        return this.c1;
    }
    public int getTransactionNumber(){
        return this.transactionNumber;
    }
    public void setQuantityOfOrder(int newQuantityOfOrder){
        this.quantityOfOrder = newQuantityOfOrder;
    }

    // Check quantity to make sure purchase can go through
    public void run(){
        synchronized(this.i1){
            try{
                Thread.sleep(100);
            } catch(InterruptedException e){
                System.out.println("Interrupt in Order.");
            }
            //System.out.println("\nItem ordered by customer.");
            System.out.println("\n    Trans Num: " + this.getTransactionNumber() + " \n");
            sellItem(i1, quantityOfOrder);
        }
    }

    //Printing to the console slows this down way too much
    public void sellItem(InventoryItem i1, int quantityOfOrder){
        if(i1.getItemQuantity() >= this.quantityOfOrder){

            i1.setItemQuantity(i1.getItemQuantity() - this.quantityOfOrder);

            // Print transactions to a text file...
            //this.writeTransaction();

            //Updates Table
            try{
                DatabaseConnector db = new DatabaseConnector();
                db.updateInventoryItem(i1.getItemNumber(), i1.getItemQuantity());
            } catch(SQLException sql1){
                sql1.printStackTrace();
            }

        }else{
            System.out.println("Sorry, we are currently out of " + i1.getItemName() + ". Unable to make sale.");
        }
    }

    // Writes Order transactions to a text file for storage.
    // Exhanges instantiate Orders and Returns respectively...thus writing out in the same manner
    public void writeTransaction(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("listOfTransactions.txt"), true))){
            bufferedWriter.write("Transaction: " + this.getTransactionNumber() + "\n");
            bufferedWriter.write("    Type: ORDER \n");
            bufferedWriter.write("    Inventory Item: " + this.i1.getItemName() + ", " + this.i1.getProductDescription() + "\n    Quantity: " + this.quantityOfOrder + "\n");
            bufferedWriter.write("    Customer: " + this.c1.getFirstName() + " " + this.c1.getLastName() + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
