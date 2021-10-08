package cuentasBancarias;
/** CINCO =  TRES + [{
 * 					setAccountNumber -> método que modica el numero de cuenta de la clase BanckAccount,
 * 					setMinBalance -> método  estático que modifica el valor de la cuenta de la clase BanckAccount,
 * 					lastAccountNumber, atributo estático de tipo entero, visibilidad privada,
 * 					minBalance, atributo estático de tipo flotante, visibilidad privada}] */
public class BankAccount {

	  protected float balance;
	  protected int accountNumber;
	  protected char accountType;

	  private static int lastAccountNumber;
	  private static float minBalance;
	  
	  // class methods

	  static void setAccountNumber(int accountNumber) {
		  lastAccountNumber = accountNumber;
/** SEIS = CINCO + [{
 * 	
 * 					balance -> atributo de tipo flotante, visibilidad protegida,
 * 					accountNumber -> atributo de tipo entero, visibilidad protegida
 * 					accountType -> atributo de tipo carácter, visibilidad protegida }] */
	  }
	  static void setMinBalance(float newMinBalance) {
		  minBalance=newMinBalance;
	  }
/**
 * SIETE = SEIS 
 *  */	  
	  static int newAccountNumber() {
		  return lastAccountNumber++;
	  }
	  
	  static public float getMinBalance()	{
		  return minBalance;
	  }
	  
	  public BankAccount(float initialBalance)      {
	    if(initialBalance >= minBalance) {
	    	balance = initialBalance;
		    accountNumber = newAccountNumber() + 1;
		    accountType=' ';
	    } else System.out.println("Not enough initialAmount");

	  }

	  // instance methods
	  public void deposit(float depositAmount)    {
	    balance += depositAmount;
	  }

	  public boolean withdraw(float withdrawAmount)   {
	    if (withdrawAmount > balance - getMinBalance()){
	      if (withdrawAmount > balance)
	    	  System.out.println("Balance not enough to maintain minimal balance");
	      else
	    	  System.out.println("Insufficient Funds!!!");
	      return false;
	    } else {
	      balance -= withdrawAmount;
	      return true;
	    }
	  }

	  public int getNumber()          {
	    return accountNumber;
	  }

	  public float getBalance()      {
	    return balance;
	  }
}

