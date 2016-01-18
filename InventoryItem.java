package OrderProcessingSystem;

/**
  Briley Marchetti
**/

public class InventoryItem{

  private int itemNumber;
  private int quantity;
  private String productDescription;

  public InventoryItem(int itemNumber, int quantity, String productDescription){
    this.itemNumber = itemNumber;
    this.quantity = quantity;
    this.productDescription = productDescription;
  }
}
