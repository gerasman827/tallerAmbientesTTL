package cuentasBancarias;

public  class SavingsAccount extends BankAccount {
	  private float totalInterest;
	  public SavingsAccount (float initialBalance)   {
		  super(initialBalance);
	      accountType='S';
	      totalInterest=0;
/** DOCE = ONCE + [{
 * 			totalInterest -> atributo de tipo flotante, visibilidad privada local a la clase.
 * 			SavingsAccount -> constructor de la clase SavingsAccount
 * 			}]*/
	  }


	  public void creditInterest (float interestRate)  {
	       totalInterest= totalInterest+ balance* interestRate;
	       super.deposit(balance* interestRate);
	  }
}
