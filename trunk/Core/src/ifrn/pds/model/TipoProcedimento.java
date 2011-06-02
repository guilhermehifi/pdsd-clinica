package ifrn.pds.model;

public enum TipoProcedimento {
	CONSULTA("consulta"),
	EXAME("exame");
	
	private String nome;
	
	private TipoProcedimento(String nome){
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
}
