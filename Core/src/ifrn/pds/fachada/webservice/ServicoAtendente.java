package ifrn.pds.fachada.webservice;

import java.util.List;
import ifrn.pds.dao.Dao;
import ifrn.pds.interfaces.IServicoAtendente;
import ifrn.pds.model.Agenda;
import ifrn.pds.model.Convenio;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;

public class ServicoAtendente{

	Dao <Paciente> pacienteDAO = new Dao<Paciente>();
	Dao <Agenda> agendaDAO = new Dao<Agenda>();
	Dao <Medico> medicoDAO = new Dao<Medico>();
	
	
	
	public Paciente buscarPaciente(int cpf) {
		return pacienteDAO.findByCPF(Paciente.class, cpf);
	}

	public void cadastrarPaciente(Paciente paciente) {
		pacienteDAO.persist(paciente);
	}

//	public void confirmarAgendamento(Agenda agenda) {
//	}

	public void excluirAgendamento(Agenda id) {
		agendaDAO.remove(id);
		
	}
	
//	public boolean isUsuario(String usuario) {
//		return false;
//	}
//
//	public List<Convenio> listarConvenio() {
//		return null;
//	}

	
	public Medico [] listarMedico() {
		return (Medico[]) medicoDAO.findAll(Medico.class).toArray();
	}

}
