import java.util.ArrayList;

/**
    Briley Marchetti
**/

public class RunThread implements Runnable{

    public RunThread(){
        this.run();
    }

    public void run(){
        // Call methods to read text files of items and customers
        ArrayList<InventoryItem> itemList = InventoryController.readItemList();
        ArrayList<Customer> customerList = CustomerController.readCustomerList();

        // Tests an array of orders...
        int totalTests = 5;
        for(int i = 0; i < totalTests; i++){
            int randNum1 = (int) Math.floor(Math.random() * itemList.size());
            int randNum2 = (int) Math.floor(Math.random() * customerList.size());
            int randNum3 = (int) Math.floor((Math.random() * 6) + 1);

            Order[] orders = new Order[totalTests];
            orders[i] = new Order(itemList.get(randNum1), customerList.get(randNum2), (i + 1), randNum3);
            orders[i].checkAndSubtractInventoryItemQuantity(orders[i].getInventoryItem());
        }

        // Testing Returns and incrementing itemQuantity
        // Return return1 = new Return(itemList.get(1), customerList.get(1), 1, 1);
        // return1.addToInventoryItemQuantity(return1.getInventoryItem());

        // Writes out itemList with new quanitties if adjusted
        InventoryController.writeOutInventoryItems(itemList);
    }
}
