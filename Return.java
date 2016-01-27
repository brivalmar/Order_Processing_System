
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

    public boolean addToInventoryItemQuantity(InventoryItem i1){
        if(i1.getItemQuantity() >= this.returnQuantity){
            return true;
        }else{
            System.out.println("Sorry, we are currently out of " + i1.getItemName());
            return false;
        }
    }


    // Maybe redundant...need to rethink.

    // public int inventoryItemReturn(InventoryItem i1){
    //     int existingItemQuantity = i1.getItemQuantity();
    //     int newItemQuantity = existingItemQuantity + this.returnQuantity;
    //     return newItemQuantity;
    // }
}
