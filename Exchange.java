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

    public void run(){
        synchronized(i1){

            Thread.yield();
            synchronized(returnedItem){
                System.out.println("Exchange: Order then Return...");
                Thread order = new Order(this.i1, this.c1, this.transactionNumber, 1);
                order.start();
                Thread return1 = new Return(this.returnedItem, this.c1, this.transactionNumber, 1);
                return1.start();
            }

        }
    }
}
