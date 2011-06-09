package ifrn.pds.fachada.webservice;

import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoAtendente;
import ifrn.pds.model.Agenda;
import ifrn.pds.model.Convenio;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.Usuario;

public class ServicoAtendente implements IServicoAtendente {

	private Dao<Paciente> pacienteDAO = new Dao<Paciente>();
	private Dao<Agenda> agendaDAO = new Dao<Agenda>();
	private Dao<Medico> medicoDAO = new Dao<Medico>();
	private Dao<Convenio> convenioDao = new Dao<Convenio>();
	private Dao<Usuario> usuarioDao = new Dao<Usuario>();

	public Paciente buscarPaciente(int cpf) {
		return pacienteDAO.findByExample(Paciente.class, "cpf", new Integer(cpf).toString());
	}

	public void cadastrarPaciente(Paciente paciente) {
		pacienteDAO.persist(paciente);
	}

	public void excluirAgendamento(Agenda id) {
		agendaDAO.remove(id);

	}

	public Medico[] listarMedico() {
		return (Medico[]) medicoDAO.findAll(Medico.class).toArray();
	}

	@Override
	public void confirmarAgendamento(Agenda agenda) {
		agendaDAO.persist(agenda);
	}

	@Override
	public Medico[] listarEspecialista() {
		return (Medico[]) medicoDAO.findAll(Medico.class).toArray();
	}

	@Override
	public Agenda[] listarAgendamento() {
		return (Agenda[]) agendaDAO.findAll(Agenda.class).toArray();
	}

	@Override
	public Convenio[] listarConvenio() {
		return (Convenio[]) convenioDao.findAll(Convenio.class).toArray();
	}

	@Override
	public boolean isUsuario(String usuario) {
		Usuario u = usuarioDao.findByExample(Usuario.class, "usuario", usuario);
		return u != null;
	}

}
