import java.io.*;

/**
    Briley Marchetti
**/

public abstract class Transaction extends Thread{

  protected InventoryItem i1;
  protected Customer c1;
  protected int transactionNumber;

  public Transaction(InventoryItem i1, Customer c1, int transactionNumber){
    this.i1 = i1;
    this.c1 = c1;
    this.transactionNumber = transactionNumber;
  }

  // Getter
  public int getTransactionNumber(){
      return this.transactionNumber;
  }

  // Setter
  public void setTransactionNumber(int newTransactionNumber){
      this.transactionNumber = newTransactionNumber;
  }
}
