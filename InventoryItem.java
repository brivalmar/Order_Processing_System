
/**
    Briley Marchetti
**/

public class InventoryItem{

  private int itemNumber;
  private String itemName;
  private int itemQuantity;
  private String productDescription;
  private double unitCost;
  private double itemPrice;

  public InventoryItem(int itemNumber, String itemName, int itemQuantity, String productDescription, double unitCost, double itemPrice){
    this.itemNumber = itemNumber;
    this.itemName = itemName;
    this.itemQuantity = itemQuantity;
    this.productDescription = productDescription;
    this.unitCost = unitCost;
    this.itemPrice = itemPrice;
  }

  // Getters
  public int getItemNumber(){
      return this.itemNumber;
  }
  public String getItemName(){
      return this.itemName;
  }
  public int getItemQuantity(){
      return this.itemQuantity;
  }
  public String getProductDescription(){
      return this.productDescription;
  }
  public double getUnitCost(){
      return this.unitCost;
  }
  public double getItemPrice(){
      return this.itemPrice;
  }

  // Setters for InventoryItem fields
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
  public void setUnitCost(double cost){
      this.unitCost = cost;
  }
  public void setItemPrice(int newItemPrice){
      this.itemPrice = newItemPrice;
  }

}
