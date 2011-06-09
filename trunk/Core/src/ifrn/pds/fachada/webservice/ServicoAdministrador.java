package ifrn.pds.fachada.webservice;

import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoAdministrador;
import ifrn.pds.model.Administrador;
import ifrn.pds.model.Atendente;
import ifrn.pds.model.Convenio;
import ifrn.pds.model.Especialidade;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.Procedimento;

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
		return (Administrador[]) administradorDao.findAll(Administrador.class)
				.toArray();
	}

	@Override
	public Medico[] listarMedico() {
		return (Medico[]) medicodaDao.findAll(Medico.class).toArray();
	}

	@Override
	public Paciente[] listarPaciente() {
		return (Paciente[]) pacienteDao.findAll(Paciente.class).toArray();
	}

	@Override
	public Atendente[] listarAtendente() {
		return (Atendente[]) atendenteDao.findAll(Atendente.class).toArray();
	}

	@Override
	public Procedimento[] listarProcedimento() {
		return (Procedimento[]) procedimentoDao.findAll(Procedimento.class)
				.toArray();
	}

	@Override
	public Especialidade[] listarEspecialidade() {
		return (Especialidade[]) especialidadeDao.findAll(Especialidade.class)
				.toArray();
	}

	@Override
	public Convenio[] listarConvenio() {
		return (Convenio[]) convenioDao.findAll(Convenio.class).toArray();
	}

}
