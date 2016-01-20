package OrderProcessingSystem;

import java.util.ArrayList;

/**
    Briley Marchetti
**/

public class Inventory{
    // This will implement an ArrayList of InventoryItems

    protected ArrayList<InventoryItem> itemList;

    public Inventory(ArrayList<InventoryItem> itemList){
        this.itemList = new ArrayList<InventoryItem>();
    }
}
