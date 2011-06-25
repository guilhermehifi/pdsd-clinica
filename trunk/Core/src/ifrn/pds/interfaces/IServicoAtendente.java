package ifrn.pds.interfaces;

import ifrn.pds.model.Agenda;
import ifrn.pds.model.Convenio;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;

public interface IServicoAtendente {
	
	public void cadastrarPaciente(Paciente paciente);
	public boolean confirmarAgendamento(int id);
	public Paciente buscarPaciente(int id);
	public Medico [] listarEspecialista();
	public Convenio[] listarConvenio();
	public boolean verificaDisponibilidade(String usuario);
	public void excluirAgendamento(int id);
	Agenda[] listarAgendamento(int id, String data);

}
