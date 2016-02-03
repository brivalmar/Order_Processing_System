import java.io.*;

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

    // Check quantity to make sure purchase can go through
    public void checkAndSubtractInventoryItemQuantity(InventoryItem i1){
        if(i1.getItemQuantity() >= this.quantityOfOrder){
            i1.setItemQuantity(i1.getItemQuantity() - this.quantityOfOrder);

            //Print transactions to the console
            System.out.println("Transaction: " + this.getTransactionNumber());
            System.out.println("    Inventory Item: " + this.i1.getItemName() + ", " + this.i1.getProductDescription() + "\n    Quantity: " + this.quantityOfOrder);
            System.out.println("    Customer: " + this.c1.getFirstName() + " " + this.c1.getLastName() + "\n");

        }else{
            System.out.println("Sorry, we are currently out of " + i1.getItemName() + ". Unable to make sale.");
        }
    }

}
