package ifrn.pds.interfaces;

import java.util.List;

import ifrn.pds.model.*;

public interface CrudMedico {
	
	public void cadastrarMédico(Medico medico);
	public Medico buscarMedico();
	public List<Medico> listarMedico();
	public List<Especialidade> listarEspecialidadeMedico();

}
