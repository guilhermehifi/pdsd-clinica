
package ifrn.pds.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.NoResultException;
import ifrn.pds.dao.Dao;


public class ServicoAdministrador  {
	
	private Dao dao = Dao.getDao();

	public ServicoAdministrador(){
		
	}
	
	
	public boolean isDisponivel(String usuario){
		
		try {
			dao.findByExample("Usuario", "usuario", "'"+usuario+"'");
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public Administrador efetuarLogin(String usuario, String senha) {
		try {
			Usuario u = dao.findByExample("Usuario", "usuario", "'"
					+ usuario + "'");
			if (u != null) {
				Administrador a = dao.findByExample("Administrador", "id_usuario", new Integer(u.getId()).toString());
				if(a.getUsuario().getSenha().equals(senha))
					return a;
			}
		} catch (NoResultException e) {
			return null;
		}
		return null;
	}
	
	public void cadastrarAdministrador(String usuario, String senha, String nome, Date nascimento, String sexo, int telefone, 
			String email, int cpf, int rg, String rua,
			int numero, String complemento, String bairro, int cep, String cidade, String estado,
			int idConvenio, int numeroConvenio) {

		Endereco endereco = new Endereco(rua, numero, bairro, complemento, cidade, estado, cep);
		Usuario u = new Usuario(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
		u.setEndereco(endereco);

		Administrador a = new Administrador();
		a.setUsuario(u);

		dao.persist(a);
	}


	public void cadastrarMedico(Medico medico) {
		dao.persist(medico);
	}

	
	public void cadastrarPaciente(String usuario, String senha, String nome, Date nascimento, String sexo, int telefone, 
			String email, int cpf, int rg, String rua,
			int numero, String complemento, String bairro, int cep, String cidade, String estado,
			int idConvenio, int numeroConvenio) {
		Endereco endereco = new Endereco(rua, numero, bairro, complemento, cidade, estado, cep);
		Usuario u = new Usuario(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
		u.setEndereco(endereco);
		
		Convenio convenio = dao.findById("Convenio", idConvenio);
		
		Paciente paciente = new Paciente(convenio, u, numeroConvenio);
		Calendar c = new GregorianCalendar();
		c.setTime(nascimento);
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH ) + 1);
		paciente.setNascimento(nascimento);
		
		dao.persist(paciente);
		
		Prontuario prontuario = new Prontuario();
		prontuario.setPaciente(paciente);
		dao.persist(prontuario);
	}

	public void cadastrarAtendente(String usuario, String senha, String nome, Date nascimento, String sexo, int telefone, 
			String email, int cpf, int rg, String rua,
			int numero, String complemento, String bairro, int cep, String cidade, String estado,
			int idConvenio, int numeroConvenio) {
		Endereco endereco = new Endereco(rua, numero, bairro, complemento, cidade, estado, cep);
		Usuario u = new Usuario(senha, usuario, endereco, nome, cpf, rg, sexo, telefone, email);
		u.setEndereco(endereco);
		
		Convenio convenio = dao.findById("Convenio", idConvenio);
		
		Paciente paciente = new Paciente(convenio, u, numeroConvenio);
		Calendar c = new GregorianCalendar();
		c.setTime(nascimento);
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH ) + 1);
		paciente.setNascimento(nascimento);
		
		dao.persist(paciente);
		
		Prontuario prontuario = new Prontuario();
		prontuario.setPaciente(paciente);
		dao.persist(prontuario);
	}
	
	
	public void cadastrarTipoProcedimento(String nome){
		TipoProcedimento tipo = new TipoProcedimento();
		tipo.setNome(nome);
		dao.persist(tipo);
	}
	
	public void cadastrarEspecialidade(Especialidade e) {
		dao.persist(e);
	}

	public void cadastrarConvenio(String nome) {
		Convenio c = new Convenio();
		c.setNome(nome);
		dao.persist(c);
	}

	
	public Administrador[] listarAdministrador() {
		Administrador [] lista = (Administrador [])dao.findAll("Administrador").toArray();
		return lista;
	}

	
	public Medico[] listarMedico() {
		List<Medico> medicos = dao.findAll("Medico");
		int qtd = medicos.size();
		Medico [] m = new Medico[qtd];
		for(int i=0; i<medicos.size(); i++){
			m[i]= medicos.get(i);
		}
		return m;
	}

	
	public Paciente[] listarPaciente() {
		Paciente [] lista = (Paciente [])dao.findAll("Medico").toArray();
		return lista;
	}

	
	public Atendente[] listarAtendente() {
		
		Atendente [] lista = (Atendente [])dao.findAll("Atendente").toArray();
		return lista;
	}

	
	public Procedimento[] listarProcedimento() {
		
		Procedimento [] lista = (Procedimento[])dao.findAll("Procedimento").toArray();
		return lista;
	}

	
	public Especialidade[] listarEspecialidade() {
		
		Especialidade [] lista = (Especialidade[])dao.findAll("Especialidade").toArray();
		return lista;
	}

	
	public Convenio[] listarConvenio() {
		Convenio [] lista = (Convenio[])dao.findAll("Convenio").toArray();
		return lista;
	}
	
	public void excluirPaciente(Paciente p){
		dao.remove(p);
	}
	

}

