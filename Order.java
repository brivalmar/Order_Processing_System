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

            // Print transactions to a text file...
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("listOfTransactions.txt"), true))){
                bufferedWriter.write("Transaction: " + this.getTransactionNumber() + "\n");
                bufferedWriter.write("    Type: ORDER");
                bufferedWriter.write("    Inventory Item: " + this.i1.getItemName() + ", " + this.i1.getProductDescription() + "\n    Quantity: " + this.quantityOfOrder + "\n");
                bufferedWriter.write("    Customer: " + this.c1.getFirstName() + " " + this.c1.getLastName() + "\n");
            }catch (IOException e){
    			e.printStackTrace();
    		}

        }else{
            System.out.println("Sorry, we are currently out of " + i1.getItemName() + ". Unable to make sale.");
        }
    }

}
