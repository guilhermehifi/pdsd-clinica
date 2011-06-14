package ifrn.pds.fachada.webservice;

import java.util.List;

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
		return pacienteDAO.findByExample("Paciente", "cpf", new Integer(cpf).toString());
	}

	public void cadastrarPaciente(Paciente paciente) {
		pacienteDAO.persist(paciente);
	}

	public void excluirAgendamento(Agenda id) {
		agendaDAO.remove(id);

	}

	public Medico[] listarMedico() {
		return (Medico[]) medicoDAO.findAll("Medico").toArray();
	}

	@Override
	public boolean confirmarAgendamento(Agenda agenda) {
		if(!agenda.isAgendado()){
			agenda.setAgendado(true);
			return true;
		}
		return false;
	}

	@Override
	public Medico[] listarEspecialista() {
		List<Medico> lista = medicoDAO.findAll("Medico");
		Medico[] m = new Medico[lista.size()];
		for (int i = 0; i < m.length; i++) {
			m[i] = lista.get(i);
			System.out.println(m[i].getId());
		}
		return m;
	}

	@Override
	public Agenda[] listarAgendamento() {
		return (Agenda[]) agendaDAO.findAll("Agenda").toArray();
	}

	@Override
	public Convenio[] listarConvenio() {
		return (Convenio[]) convenioDao.findAll("Convenio").toArray();
	}

	@Override
	public boolean isUsuario(String usuario) {
		Usuario u = usuarioDao.findByExample("Usuario", "usuario", usuario);
		return u != null;
	}

}
