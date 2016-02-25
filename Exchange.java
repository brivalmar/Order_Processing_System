import java.io.*;

/**
    Briley Marchetti
**/

public class Exchange extends Transaction{

    protected InventoryItem returnedItem;

    public Exchange(InventoryItem i1, Customer c1, int transactionNumber, InventoryItem returnedItem){
        super(i1, c1, transactionNumber);
        this.returnedItem = returnedItem;
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
    public InventoryItem getReturnedItem(){
        return this.returnedItem;
    }

    //Printing to the console slows this down way too much
    public void run(){

        InventoryItem[] item = new InventoryItem[2];
        if(i1.getItemNumber() < returnedItem.getItemNumber()){
            item[0] = i1;
            item[1] = returnedItem;
        }else{
            item[0] = returnedItem;
            item[1] = i1;
        }

        synchronized(item[0]){

            Thread.yield();

            synchronized(item[1]){

                this.writeTransaction();
                //System.out.println("Exchange: Order then Return...");
                Order order = new Order(this.i1, this.c1, this.transactionNumber, 1);
                order.sellItem(i1, 1);
                Return return1 = new Return(this.returnedItem, this.c1, this.transactionNumber, 1);
                return1.returnItem(returnedItem, 1);

            }
        }
    }

    public void writeTransaction(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("listOfTransactions.txt"), true))){
            bufferedWriter.write("Transaction: " + this.getTransactionNumber() + "\n");
            bufferedWriter.write("    Type: EXCHANGE \n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
