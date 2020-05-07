
public class DatoInvalido {
	double extraccion_solicitada;
	double saldo;
	
	DatoInvalido(double saldo,double extraccion_solicitada){
		this.extraccion_solicitada = extraccion_solicitada;
		this.saldo = saldo;
	}

	public double getExtraccion_solicitada() {
		return extraccion_solicitada;
	}

	public double getSaldo() {
		return saldo;
	}
	
	
}
