// Basically totally unnecesary at this point

/**
    Briley Marchetti
**/


// This needs to be fixed to work better with Order...they are really the same thing.
public class Purchase extends Order{

    public Purchase(InventoryItem i1, Customer c1, int transactionNumber, int quantityOfOrder){
        super(i1, c1, transactionNumber, quantityOfOrder);
    }

    // Maybe redundant...need to rethink.

    // public int inventoryItemSold(InventoryItem i1, int quantityOfOrder){
    //     int existingItemQuantity = i1.getItemQuantity();
    //     int newItemQuantity = existingItemQuantity - quantityOfOrder;
    //     return newItemQuantity;
    // }
}
