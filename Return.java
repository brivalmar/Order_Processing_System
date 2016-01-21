
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
        return i1;
    }
    public Customer getCustomer(){
        return c1;
    }
    public int getTransactionNumber(){
        return transactionNumber;
    }

    // Maybe redundant...need to rethink.

    // public int inventoryItemReturn(InventoryItem i1){
    //     int existingItemQuantity = i1.getItemQuantity();
    //     int newItemQuantity = existingItemQuantity + this.returnQuantity;
    //     return newItemQuantity;
    // }
}
