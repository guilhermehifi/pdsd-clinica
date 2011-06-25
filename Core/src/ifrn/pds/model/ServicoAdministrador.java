package ifrn.pds.model;

import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoAdministrador;

public class ServicoAdministrador implements IServicoAdministrador {
	private Dao<Administrador> administradorDao = new Dao<Administrador>();
	private Dao<Atendente> atendenteDao = new Dao<Atendente>();
	private Dao<Medico> medicodaDao = new Dao<Medico>();
	private Dao<Paciente> pacienteDao = new Dao<Paciente>();
	private Dao<Procedimento> procedimentoDao = new Dao<Procedimento>();
	private Dao<Especialidade> especialidadeDao = new Dao<Especialidade>();
	private Dao<Convenio> convenioDao = new Dao<Convenio>();

	@Override
	public void cadastrarAdministrador(Administrador adm) {
		administradorDao.persist(adm);
	}

	@Override
	public void cadastrarMedico(Medico medico) {
		medicodaDao.persist(medico);
	}

	@Override
	public void cadastrarPaciente(Paciente paciente) {
		pacienteDao.persist(paciente);
	}

	@Override
	public void cadastrarAtendente(Atendente atendente) {
		atendenteDao.persist(atendente);
	}

	@Override
	public void cadastrarProcedimento(Procedimento pr) {
		procedimentoDao.persist(pr);
	}

	@Override
	public void cadastrarEspecialidade(Especialidade e) {
		especialidadeDao.persist(e);
	}

	@Override
	public void cadastrarConvenio(Convenio c) {
		convenioDao.persist(c);
	}

	@Override
	public Administrador[] listarAdministrador() {
		return null;
	}

	@Override
	public Medico[] listarMedico() {
		return null;
	}

	@Override
	public Paciente[] listarPaciente() {
		return null;
	}

	@Override
	public Atendente[] listarAtendente() {
		return null;
	}

	@Override
	public Procedimento[] listarProcedimento() {
		return null;
	}

	@Override
	public Especialidade[] listarEspecialidade() {
		return null;
	}

	@Override
	public Convenio[] listarConvenio() {
		return null;
	}

}
