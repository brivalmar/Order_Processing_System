import java.util.ArrayList;

/**
    Briley Marchetti
**/

public class MainController{
    public static void main(String[] args) throws InterruptedException{

        ArrayList<InventoryItem> itemList = InventoryController.readItemList();
        ArrayList<Customer> customerList = CustomerController.readCustomerList();

        Thread[] t = new Thread[10000];

        for(int i = 0; i < t.length; i++){
            int itemRandom = (int)(Math.random() * itemList.size());
            int customerRandom = (int)(Math.random() * customerList.size());
            int transNum = i + 1;
            int itemQuant = (int)(Math.random() * 6);
            int secondItemRandom = (int)(Math.random() * itemList.size());

            if(i % 3 == 0){
                t[i] = new Exchange(itemList.get(itemRandom), customerList.get(customerRandom), transNum, itemList.get(secondItemRandom));
            }else if(i % 7 == 0){
                t[i] = new Return(itemList.get(secondItemRandom), customerList.get(customerRandom), transNum, itemQuant);
            }else{
                t[i] = new Order(itemList.get(itemRandom), customerList.get(customerRandom), transNum, itemQuant);
            }
        }

        // t[0] = new Order(itemList.get(0), customerList.get(0), (0 + 1), 1);
        // t[1] = new Return(itemList.get(0), customerList.get(0), (1 + 1), 1);
        // t[2] = new Order(itemList.get(0), customerList.get(0), (2 + 1), 3);
        // t[3] = new Exchange(itemList.get(0), customerList.get(0), (3 +1), itemList.get(1));
        // t[4] = new Order(itemList.get(1), customerList.get(0), (3 + 1), 4);
        // t[5] = new Exchange(itemList.get(1), customerList.get(0), (4 + 1), itemList.get(0));
        // t[6] = new Exchange(itemList.get(0), customerList.get(0), (5 + 1), itemList.get(1));
        // t[7] = new Return(itemList.get(1), customerList.get(0), (6 + 1), 1);

        for(int i = 0; i < t.length; i++){
            t[i].start();
        }

        //InventoryController.writeOutInventoryItems(itemList);

    }
}
