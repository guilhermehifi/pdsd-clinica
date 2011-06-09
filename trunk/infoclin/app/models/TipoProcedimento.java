package models;

import java.io.Serializable;

public class TipoProcedimento implements Serializable{
	
	
	private String nome;
	
	public TipoProcedimento(){
		
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
