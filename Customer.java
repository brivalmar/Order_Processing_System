package OrderProcessingSystem;

/**
  Briley Marchetti
**/

public class Customer{

  private String firstName;
  private String lastName;
  private String billingAddress;
  private String shippingAddress;

  public Customer(String firstName, String lastName, String billingAddress, String shippingAddress){
    this.firstName = firstName;
    this.lastName = lastName;
    this.billingAddress = billingAddress;
    this.shippingAddress = shippingAddress;

  }

}
