
public class DepositoInvalidoException extends Exception {
	private double cantidadInvalida;

	DepositoInvalidoException(double cantidadInvalida){
		this.cantidadInvalida = cantidadInvalida;
	}

	public double getCantidadInvalida() {
		return cantidadInvalida;
	}
	
	
}
