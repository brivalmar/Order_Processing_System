package OrderProcessingSystem;

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
        return i1;
    }
    public Customer getCustomer(){
        return c1;
    }
    public int getTransactionNumber(){
        return transactionNumber;
    }

    // Check quantity to make sure purchase can go through
    public boolean checkInventoryItemQuantity(InventoryItem i1){
        if(i1.getItemQuantity() > 0){
            return true;
        }else{
            System.out.println("Sorry, we are currently out of " + i1.getItemName());
            return false;
        }
    }
}
