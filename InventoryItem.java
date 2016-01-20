package OrderProcessingSystem;

/**
  Briley Marchetti
**/

public class InventoryItem{

  private int itemNumber;
  private String itemName;
  private int itemQuantity;
  private String productDescription;
  private double itemPrice;


//InventoryItem i2 = new InventoryItem(1, )
  public InventoryItem(int itemNumber, String itemName, int itemQuantity, String productDescription, double itemPrice){
    this.itemNumber = itemNumber;
    this.itemName = itemName;
    this.itemQuantity = itemQuantity;
    this.productDescription = productDescription;
    this.itemPrice = itemPrice;
  }


  // Getters
  public int getItemNumber(){
      return itemNumber;
  }
  public String getItemName(){
      return itemName;
  }
  public int getItemQuantity(){
      return itemQuantity;
  }
  public String getProductDescription(){
      return productDescription;
  }
  public double getItemPrice(){
      return itemPrice;
  }

  // Maybe add a setters for all of these...will do later
  public int changeItemNumber(int newItemNumber){
      return newItemNumber;
  }
  public String changeName(String newItemName){
      return newItemName;
  }


  //Mutators
  public void incrementQuantity(InventoryItem i1){
      int quantity = i1.getItemQuantity();
      quantity++;
  }
  public void decrementQuantity(InventoryItem i1){
      int quantity = i1.getItemQuantity();
      quantity--;
  }


}
