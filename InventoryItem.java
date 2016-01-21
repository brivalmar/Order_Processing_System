
/**
    Briley Marchetti
**/

public class InventoryItem{

  private int itemNumber;
  private String itemName;
  private int itemQuantity;
  private String productDescription;
  private double itemPrice;

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
  public void setItemNumber(int newItemNumber){
      this.itemNumber = newItemNumber;
  }
  public void setName(String newItemName){
      this.itemName = newItemName;
  }
  public void setItemQuantity(int newItemQuantity){   // i1.setQuantity(i1.getItemQuantity + quantityAdjustmentValue);
      this.itemQuantity = newItemQuantity;
  }
  public void setProductDescription(String newProductDescription){
      this.productDescription = newProductDescription;
  }
  public void setItemPrice(int newItemPrice){
      this.itemPrice = newItemPrice;
  }

}
