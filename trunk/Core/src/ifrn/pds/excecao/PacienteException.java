package ifrn.pds.excecao;

public class PacienteException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PacienteException(){
		super("O usuario e senha não foram encontrdos !! ");
	}

}
