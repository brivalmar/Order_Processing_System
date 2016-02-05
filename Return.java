import java.io.*;

/**
    Briley Marchetti
**/

public class Return extends Transaction{

    protected int returnQuantity;

    public Return(InventoryItem i1, Customer c1, int transactionNumber, int returnQuantity){
        super(i1, c1, transactionNumber);
        this.returnQuantity = returnQuantity;
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

    public void addToInventoryItemQuantity(InventoryItem i1){
        if(this.returnQuantity != 0){
            i1.setItemQuantity(i1.getItemQuantity() + this.returnQuantity);

            // Print transactions to a text file...
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("listOfTransactions.txt"), true))){
                bufferedWriter.write("Transaction: " + this.getTransactionNumber() + "\n");
                bufferedWriter.write("    Type: RETURN \n");
                bufferedWriter.write("    Inventory Item: " + this.i1.getItemName() + ", " + this.i1.getProductDescription() + "\n    Quantity Returned: " + this.returnQuantity + "\n");
                bufferedWriter.write("    Customer: " + this.c1.getFirstName() + " " + this.c1.getLastName() + "\n");
            }catch (IOException e){
    			e.printStackTrace();
    		}

        } else{
            System.out.println("No return made.");
        }

    }


    // Maybe redundant...need to rethink.

    // public int inventoryItemReturn(InventoryItem i1){
    //     int existingItemQuantity = i1.getItemQuantity();
    //     int newItemQuantity = existingItemQuantity + this.returnQuantity;
    //     return newItemQuantity;
    // }
}
