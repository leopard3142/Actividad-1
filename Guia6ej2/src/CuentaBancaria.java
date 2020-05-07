

public class CuentaBancaria {
	private static CuentaBancaria instance = null;
	double saldo;
	String titular;
	
	
	
	public CuentaBancaria(String titular) {
		super();
		this.saldo = 0;
		this.titular = titular;
	}

	public void depositar(double cantidad) throws DepositoInvalidoException{
		if(cantidad>0)
			this.saldo+=cantidad;
		else
			throw new DepositoInvalidoException(cantidad);
	}
	
	public void extraer(double cantidad)throws ExtraccionInvalidaException{
		if(cantidad<saldo)
			saldo-=cantidad;
		else {
			DatoInvalido dato = new DatoInvalido(this.saldo,cantidad);
			throw new ExtraccionInvalidaException(dato);
		}
	}

	@Override
	public String toString() {
		return "Titular: "+ this.titular + " Saldo: "+this.saldo;
	}
	
}
