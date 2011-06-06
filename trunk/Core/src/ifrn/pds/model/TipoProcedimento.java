package ifrn.pds.model;

public class TipoProcedimento {
	
	
	private String nome;
	
	public TipoProcedimento(){
		
	}
	
	public TipoProcedimento(String nome){
		this.nome = nome;
	}
	
	public void setTipoProcedimento(String nome){
		this.nome=nome;
	}
	
	public String getTipoProcedimento(){
		return nome;
	}
	
	public String toString() {
		return nome;
	}
	
	
}
