package OrderProcessingSystem;

/**
    Briley Marchetti
**/

public class Purchase extends Order{

    public Purchase(InventoryItem i1, Customer c1, int transactionNumber, int quantityOfOrder){
        super(i1, c1, transactionNumber, quantityOfOrder);
    }

    public int inventoryItemSold(InventoryItem i1, int quantityOfOrder){
        int existingItemQuantity = i1.getItemQuantity();
        int newItemQuantity = existingItemQuantity - quantityOfOrder;
        return newItemQuantity;
    }


}
