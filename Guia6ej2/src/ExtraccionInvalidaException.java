
public class ExtraccionInvalidaException extends Exception {
	private DatoInvalido invalido;

	public ExtraccionInvalidaException(DatoInvalido invalido) {
		super();
		this.invalido = invalido;
	}
	
	
}
