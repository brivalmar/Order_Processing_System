import java.util.ArrayList;
/**
    Briley Marchetti
**/

public class InventoryController{
    public static void main(String[] args){

        InventoryItem first = new InventoryItem(1, "Shirt", 5, "Large", 1.99, 4.99);
        Customer c1 = new Customer("John", "Smith", "1 Penn Lane", "1 Penn Lane", "DEBIT");
        Transaction t1 = new Order(first, c1, 001, 2);

        // Creates an inventory object...logging occurs through readItemList().
        ArrayList<InventoryItem> itemList = new ArrayList<InventoryItem>();
        Inventory inv = new Inventory(itemList);
        inv.readItemList();
        itemList = inv.getItemList();
    }

}
