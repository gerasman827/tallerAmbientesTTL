// aplicacion cuentas bancarias
import cuentasBancarias;

/**
 * UNO [paquete de cuentas bancarias, cuenta1, cuenta2 de tipo CheckAccount, visibilidad privada
 * 		cuenta3, cuenta4 de tipo SavingsAccount, visibilidad privada,
 * 		BankAccount -> clase para cuentas de banco,
 * 		setAccountNumber -> método para asignar el número de cuenta de la clase bankAccount, visibilidad pública,
 * 		setMinBalance -> método para modifiacar el valor de la cuenta de la clase bankAccount, visibilidad pública,
 * 		newAccountNumber -> método para cambiar el número de cuenta de la clase bankAccount , visibilidad pública,
 * 		getMinBalance -> método que devuelve el valor de la cuenta de la clase bankAccount, visibilidad pública,
 * 		BankAccount -> constructor de la clase bankAccount, visibilidad pública,
 * 		deposit -> método que modifica el nuevo valor de la cuenta de la clase bankAccount, visibilidad pública,
 * 		withdraw -> Método que permite retirar una cantidad de la cuenta de la clase BanckAccount,visibilidad pública,
 * 		getNumber -> Método que devuelve el número de cuenta de la clase BanckAccount,visibilidad pública,
 * 		getBalance -> Método que devuelve el valor de la cuenta de la clase BankAccount, visibilidad pública,]
 *  */ 
class CuentasBancarias {
  
  private static CheckAccount cuenta1, cuenta2;
  private static SavingsAccount cuenta3,cuenta4;
/**
 * DOS [UNO]
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/** TRES [DOS +{metodo main -> inicializa la clase, 
 * 			variable args, visibilidad pública}]
*/
		int minBalance = 10000;
		BankAccount.setMinBalance(minBalance);
		BankAccount.setAccountNumber(0);

		cuenta1 = new CheckAccount(10000);
		cuenta2 = cuenta1;
		cuenta3 = new SavingsAccount(15000);

                System.out.println(" SALDO MINIMO ");
		double minimo = BankAccount.getMinBalance();
                
                System.out.println(" AUTORIZAR SOBREGIRO");
		cuenta1.withdraw(6000);
		cuenta1.autorizarSobregiro();
	}	
}
/** CUATRO: [TRES + {minBalance -> variable, de tipo entero, visibilidad pública }] */
