package ifrn.pds.interfaces;

import ifrn.pds.model.Agenda;
import ifrn.pds.model.Convenio;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;

public interface IServicoAtendente {
	
	public void cadastrarPaciente(Paciente paciente);
	public void confirmarAgendamento(Agenda agenda);
	public Paciente buscarPaciente(int id);
	public Medico [] listarEspecialista();
	public Agenda[] listarAgendamento();
	public Convenio[] listarConvenio();
	public boolean isUsuario(String usuario);
	public void excluirAgendamento(Agenda id);

}
