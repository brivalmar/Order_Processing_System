package OrderProcessingSystem;

/**
  Briley Marchetti
**/

public abstract class Transaction{

  protected InventoryItem i1;
  protected Customer c1;
  protected int transactionNumber;

  public Transaction(InventoryItem i1, Customer c1, int transactionNumber){
    this.i1 = i1;
    this.c1 = c1;
    this.transactionNumber = transactionNumber;
  }

  // Make sure the customer has valid payment method...doesn't really matter at this stage
  public boolean checkPaymentMethod(Customer c1){
      if(c1.getPaymentMethod().toLowerCase().equals("debit")){
          return true;
      }else{
          System.out.println("Sorry. You do not have a valid form of payment.");
          return false;
      }
  }
}
