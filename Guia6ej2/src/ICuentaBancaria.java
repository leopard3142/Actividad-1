

public interface ICuentaBancaria {

	void depositar(double cantidad) throws DepositoInvalidoException;
	void extraer(double cantidad) throws ExtraccionInvalidaException;
	void getsaldo();
}
