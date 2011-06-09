package models;

public class Endereco {

		private int id;
		private String rua;
		private int numero;
		private String bairro;
		private String complemento;
		private String cidade;
		private String estado;
		private int cep;

		public Endereco() {

		}

		public Endereco(String rua, int numero, String bairro, String complemento,
				String cidade, String estado, int cep) {
			this.rua = rua;
			this.numero = numero;
			this.bairro = bairro;
			this.complemento = complemento;
			this.cidade = cidade;
			this.estado = estado;
			this.cep = cep;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public String getRua() {
			return rua;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getNumero() {
			return numero;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getBairro() {
			return bairro;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCep(int cep) {
			this.cep = cep;
		}

		public int getCep() {
			return cep;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getEstado() {
			return estado;
		}

		public int getId() {
			return id;
		}


}
