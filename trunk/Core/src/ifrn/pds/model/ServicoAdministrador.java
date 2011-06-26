package ifrn.pds.model;

import javax.persistence.NoResultException;

import ifrn.pds.dao.Dao;


public class ServicoAdministrador  {
	
	private Dao<Administrador> administradorDao;
	private Dao<Atendente> atendenteDao;
	private Dao<Medico> medicoDao;
	private Dao<Paciente> pacienteDao;
	private Dao<Procedimento> procedimentoDao;
	private Dao<Especialidade> especialidadeDao;
	private Dao<Convenio> convenioDao;
	private Dao<Usuario> usuarioDao;

	public boolean isDisponivel(String usuario){
		usuarioDao = new Dao<Usuario>();
		try {
			usuarioDao.findByExample("Usuario", "usuario", "'"+usuario+"'");
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public void cadastrarAdministrador(Administrador adm) {
		administradorDao = new Dao<Administrador>();
		administradorDao.persist(adm);
	}


	public void cadastrarMedico(Medico medico) {
		medicoDao = new Dao<Medico>();
		medicoDao.persist(medico);
	}

	
	public void cadastrarPaciente(Paciente paciente) {
		pacienteDao = new Dao<Paciente>();
		pacienteDao.persist(paciente);
	}

	public void cadastrarAtendente(Atendente atendente) {
		atendenteDao = new Dao<Atendente>();
		atendenteDao.persist(atendente);
	}
	
	public void cadastrarProcedimento(Procedimento pr) {
		procedimentoDao = new Dao<Procedimento>();
		procedimentoDao.persist(pr);
	}


	public void cadastrarEspecialidade(Especialidade e) {
		especialidadeDao = new Dao<Especialidade>();
		especialidadeDao.persist(e);
	}

	
	public void cadastrarConvenio(Convenio c) {
		convenioDao = new Dao<Convenio>();
		convenioDao.persist(c);
	}

	
	public Administrador[] listarAdministrador() {
		administradorDao = new Dao<Administrador>();
		Administrador [] lista = (Administrador [])administradorDao.findAll("Administrador").toArray();
		return lista;
	}

	
	public Medico[] listarMedico() {
		medicoDao = new Dao<Medico>();
		Medico [] lista = (Medico [])medicoDao.findAll("Medico").toArray();
		return lista;
	}

	
	public Paciente[] listarPaciente() {
		pacienteDao = new Dao<Paciente>();
		Paciente [] lista = (Paciente [])pacienteDao.findAll("Medico").toArray();
		return lista;
	}

	
	public Atendente[] listarAtendente() {
		atendenteDao = new Dao<Atendente>();
		Atendente [] lista = (Atendente [])atendenteDao.findAll("Atendente").toArray();
		return lista;
	}

	
	public Procedimento[] listarProcedimento() {
		procedimentoDao = new Dao<Procedimento>();
		Procedimento [] lista = (Procedimento[])procedimentoDao.findAll("Procedimento").toArray();
		return lista;
	}

	
	public Especialidade[] listarEspecialidade() {
		especialidadeDao = new Dao<Especialidade>();
		Especialidade [] lista = (Especialidade[])especialidadeDao.findAll("Especialidade").toArray();
		return lista;
	}

	
	public Convenio[] listarConvenio() {
		convenioDao = new Dao<Convenio>();
		Convenio [] lista = (Convenio[])convenioDao.findAll("Convenio").toArray();
		return lista;
	}
	
	public void excluirPaciente(Paciente p){
		pacienteDao = new Dao<Paciente>();
		pacienteDao.remove(p);
		
	}
	


}
