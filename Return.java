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

    public void setReturnQuantity(int newReturnQuantity){
        this.returnQuantity = newReturnQuantity;
    }

    public void run(){
        synchronized(i1){
            System.out.println("\nReturning Item to inventory.");
            returnItem(i1, returnQuantity);
        }
    }

    public void returnItem(InventoryItem i1, int returnQuantity){
        if(this.returnQuantity != 0){
            i1.setItemQuantity(i1.getItemQuantity() + returnQuantity);
            System.out.println("Return: \n  Trans Number: " + this.transactionNumber + "\n  Item Number: " + i1.getItemNumber()+ "\n  New Quantity: " + (i1.getItemQuantity()));

            // Print transactions to a text file...
            this.writeTransaction();

        } else{
            System.out.println("No return made.");
        }
    }

    // Writes Return transactions to the same text file as Orders.
    public void writeTransaction(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("listOfTransactions.txt"), true))){
            bufferedWriter.write("Transaction: " + this.getTransactionNumber() + "\n");
            bufferedWriter.write("    Type: RETURN \n");
            bufferedWriter.write("    Inventory Item: " + this.i1.getItemName() + ", " + this.i1.getProductDescription() + "\n    Quantity: " + this.returnQuantity + "\n");
            bufferedWriter.write("    Customer: " + this.c1.getFirstName() + " " + this.c1.getLastName() + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
