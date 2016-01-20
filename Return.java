package OrderProcessingSystem;

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

    public int inventoryItemReturn(InventoryItem i1, int returnQuantity){
        int existingItemQuantity = i1.getItemQuantity();
        int newItemQuantity = existingItemQuantity + returnQuantity;
        return newItemQuantity;
    }
}
