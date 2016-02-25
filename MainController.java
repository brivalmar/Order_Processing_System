import java.util.ArrayList;

/**
    Briley Marchetti
**/

public class MainController{
    public static void main(String[] args) throws InterruptedException{

        ArrayList<InventoryItem> itemList = InventoryController.readItemList();
        ArrayList<Customer> customerList = CustomerController.readCustomerList();

        Thread[] t = new Thread[1000000];

        //Creates as many threads with random numbers for items, customers...
        for(int i = 0; i < t.length; i++){
            int itemRandom = (int)(Math.random() * itemList.size());
            int customerRandom = (int)(Math.random() * customerList.size());
            int transNum = i + 1;
            int itemQuant = (int)(Math.random() * 6);
            int secondItemRandom = (int)(Math.random() * itemList.size());

            if(i % 7 == 0){
                t[i] = new Exchange(itemList.get(itemRandom), customerList.get(customerRandom), transNum, itemList.get(secondItemRandom));
            }else if(i % 3 == 0){
                t[i] = new Return(itemList.get(secondItemRandom), customerList.get(customerRandom), transNum, itemQuant);
            }else{
                t[i] = new Order(itemList.get(itemRandom), customerList.get(customerRandom), transNum, itemQuant);
            }

            t[i].start();
        }

        //Checks to see if any threads are still running...
        boolean threadsAreAlive;
        do{
            threadsAreAlive = false;
            for(int j = 0; j < t.length; j++){
                threadsAreAlive = t[j].isAlive() || threadsAreAlive;
            }
        } while(threadsAreAlive);

        //Waits until all threads are complete to write back out to inventoryItem.txt
        InventoryController.writeOutInventoryItems(itemList);

    }
}
