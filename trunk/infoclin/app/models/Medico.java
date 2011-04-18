package models;

public class Medico {
	
	private String nome;
	private String crm;
	private int codigo;
	private String email;
	private String cpf;
	private String rg;
	
	public Medico(String nome, String crm, int codigo, String email,
			String cpf, String rg) {
		super();
		this.nome = nome;
		this.crm = crm;
		this.codigo = codigo;
		this.email = email;
		this.cpf = cpf;
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
}
