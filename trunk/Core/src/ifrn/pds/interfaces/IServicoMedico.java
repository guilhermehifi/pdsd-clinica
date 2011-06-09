package ifrn.pds.interfaces;

import ifrn.pds.model.Especialidade;
import ifrn.pds.model.Medico;

public interface IServicoMedico {
	
	public void cadastrarMedico(Medico medico);
	public Medico buscarMedico(String login);
	public Medico[] listarMedicos();
	public Especialidade[] listarEspecialidadeMedico(Medico medico);

}
