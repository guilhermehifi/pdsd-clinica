package models;

public class Paciente {

	public int id;
	public String usuario;
	public String senha;
	
	public Paciente(){
		
	}
	
	public void setUsuario(String usuario){
		this.usuario=usuario;
	}
	public void setSenha(String senha){
		this.senha=senha;
	}
	
	public String getUsuario(){
		return usuario;
	}
	public String getSenha(){
		return senha;
	}

	
}
