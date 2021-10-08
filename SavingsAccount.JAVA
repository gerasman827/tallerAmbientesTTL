package cuentasBancarias;

public  class SavingsAccount extends BankAccount {
	  private float totalInterest;
	  public SavingsAccount (float initialBalance)   {
		  super(initialBalance);
	      accountType='S';
	      totalInterest=0;
/** DOCE */
	  }


	  public void creditInterest (float interestRate)  {
	       totalInterest= totalInterest+ balance* interestRate;
	       super.deposit(balance* interestRate);
	  }
}
