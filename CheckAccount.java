package cuentasBancarias;

public class CheckAccount extends BankAccount   {
	  private int checkNumber;
	  private int numGirados;
	  private int numCobrados;
/** NUEVE = OCHO + [{checkNumber -> atributo de tipo entero, visibilidad privada,
 * 					numGirados -> atributo de tipo entero, visibilidad privada,
 * 					numCobrados -> atributo de tipo entero, visibilidad privada}]
 * 
 */
	  private boolean sobregiro;
	  private float valorAutorizado;
	  private float sobregiroUsado;

	  public CheckAccount (float initialBalance)     {
		  super(initialBalance);
		  checkNumber=0;
		  numGirados=0;
		  numCobrados=0;
	      accountType='C';
	      sobregiro= false;
	      valorAutorizado=0;
	      sobregiroUsado= 0;
		  
	  }
	  public boolean deductFees(float fee)           {
		  boolean normalFee= super.withdraw(fee);
		  return normalFee?true:false;
	  }	
	  
	  public boolean autorizarSobregiro()	{
		  if (balance > super.getMinBalance()) {
			  sobregiro=true;
			  valorAutorizado=balance - super.getMinBalance();
			  return sobregiro;
		  } else return sobregiro;
		  
	  }
	  
	  public float valorAutorizado() {
		  return valorAutorizado;
	  }
	  
	  public float valorUsado() {
		  return sobregiroUsado;
	  }
	  
	  public boolean sobregiroAutorizado() {
		  return sobregiro;
	  }
	  
	  public boolean withdraw(float amount)	{
		  float minBalance=super.getMinBalance();
		  boolean normalWithdraw= super.withdraw(amount);
		  if (!normalWithdraw) {
			  if (sobregiro && amount > (balance-minBalance +valorAutorizado - sobregiroUsado)) {
				 float resto = balance -minBalance;
				 sobregiroUsado =sobregiroUsado + amount - resto;
				 return true;
/** DIEZ = NUEVE + [{sobregiro -> atributo de tipo boolean, visibilidad privada, 
 * 					valorAutorizado -> atributo de tipo flotante, visibilidad privada,
 * 					sobregiroUsado -> atributo de tipo flotante, visiblidad privada,
 * 					deductFees -> método que deduce la tarifa de la cuenta de la clase BanckAccount}] */
				 
			  } else {
				  if (sobregiro)
					  System.out.println("sobregiro autorizado es insuficiente.");
				  else
					  System.out.println("sobregiro NO autorizado.");
				  return false;
			  }		  
		  
		  } else return true;
	  } 
	  
	  public void girarCheck(float amount) {
		  checkNumber = checkNumber +1;
		  numGirados=numGirados+1;
		  		  	  
	  }
	  
	  public boolean cobrarCheck(float amount, int number) {
		  boolean cobrado= this.withdraw(amount); 
		  if (cobrado) {
			  numCobrados=numCobrados +1;
			  return true;
		  }  else 
			  return false;
	  }
	  
	  public void deposit(float depositAmount)  {
		  if (!sobregiro)
			  super.deposit(depositAmount);
		  else { if(sobregiroUsado>0) {
			  		if(depositAmount >= sobregiroUsado ) {
			  			super.deposit(depositAmount-sobregiroUsado);
			  			sobregiroUsado=0;
			  		} else {
			  			sobregiroUsado=sobregiroUsado - depositAmount;
			  		}
			  		  			
		  		} else {
		  			super.deposit(depositAmount);
		  		}
			  
		  }
		  
	  }


}
// ONCE