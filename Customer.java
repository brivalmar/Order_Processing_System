import java.util.ArrayList;

/**
    Briley Marchetti
**/

public class Customer{

  private String firstName;
  private String lastName;
  private String billingAddress;
  private String shippingAddress;
  private String paymentMethod;
  // Anything based around the 'shopping cart' will be left out until everything works functionally
  //private ArrayList<InventoryItem> itemCart;

  public Customer(String firstName, String lastName, String billingAddress, String shippingAddress, String paymentMethod){   //, ArrayList itemCart){
    this.firstName = firstName;
    this.lastName = lastName;
    this.billingAddress = billingAddress;
    this.shippingAddress = shippingAddress;
    this.paymentMethod = paymentMethod;
    //this.itemCart = new ArrayList<InventoryItem>();
  }

  // Getters
  public String getFirstName(){
      return firstName;
  }
  public String getLastName(){
      return lastName;
  }
  public String getBillingAddress(){
      return billingAddress;
  }
  public String getShippingAddress(){
      return shippingAddress;
  }
  public String getPaymentMethod(){
      return paymentMethod;
  }

  // Setters
  public void setFirstName(String newFirstName){
      this.firstName = newFirstName;
  }
  public void setLastName(String newLastName){
      this.lastName = newLastName;
  }
  public void setBillingAddress(String newBillingAddress){
      this.billingAddress = newBillingAddress;
  }
  public void setShippingAddress(String newShippingAddress){
      this.shippingAddress = newShippingAddress;
  }

  // public ArrayList getItemCart(){
  //     return itemCart;
  // }
  //
  // // Mutators
  // public ArrayList addInventoryItemToCart(Customer c1, InventoryItem i1){
  //     ArrayList<InventoryItem> cart = c1.getItemCart();
  //     cart.add(i1);
  //     return cart;
  // }

}
