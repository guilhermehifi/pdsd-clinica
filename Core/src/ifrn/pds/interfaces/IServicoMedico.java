package ifrn.pds.interfaces;

import java.util.List;

import ifrn.pds.model.*;

public interface IServicoMedico {
	
	public void cadastrarMédico(Medico medico);
	public Medico buscarMedico();
	public List<Medico> listarMedico();
	public List<Especialidade> listarEspecialidadeMedico();

}
