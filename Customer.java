
/**
    Briley Marchetti
**/

// Anything based around the 'shopping cart' will be left out until everything works functionally


public class Customer{

  private int customerID;
  private String firstName;
  private String lastName;
  // private String billingAddress;
  // private String shippingAddress;
  // private String paymentMethod;
  // private ArrayList<InventoryItem> itemCart;

  public Customer(int customerID, String firstName, String lastName){ //, String billingAddress, String shippingAddress, String paymentMethod){   //, ArrayList itemCart){
    this.customerID = customerID;
    this.firstName = firstName;
    this.lastName = lastName;
    // this.billingAddress = billingAddress;
    // this.shippingAddress = shippingAddress;
    // this.paymentMethod = paymentMethod;
    //this.itemCart = new ArrayList<InventoryItem>();
  }

  // Getters
  public int getCustomerID(){
      return this.customerID;
  }
  public String getFirstName(){
      return this.firstName;
  }
  public String getLastName(){
      return this.lastName;
  }
  // public String getBillingAddress(){
  //     return this.billingAddress;
  // }
  // public String getShippingAddress(){
  //     return this.shippingAddress;
  // }
  // public String getPaymentMethod(){
  //     return this.paymentMethod;
  // }

  // Setters
  public void setFirstName(String newFirstName){
      this.firstName = newFirstName;
  }
  public void setLastName(String newLastName){
      this.lastName = newLastName;
  }
  // public void setBillingAddress(String newBillingAddress){
  //     this.billingAddress = newBillingAddress;
  // }
  // public void setShippingAddress(String newShippingAddress){
  //     this.shippingAddress = newShippingAddress;
  // }
}
