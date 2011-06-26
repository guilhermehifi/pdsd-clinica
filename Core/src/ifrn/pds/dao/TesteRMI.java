package ifrn.pds.dao;

import ifrn.pds.excecao.PacienteException;
import ifrn.pds.model.Agenda;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.Procedimento;
import ifrn.pds.model.TipoProcedimento;


import java.rmi.RemoteException;
import java.util.List;

public class TesteRMI {
	
	Dao<Paciente> pacienteDAO = new Dao<Paciente>();
	Dao<TipoProcedimento> procDAO = new Dao<TipoProcedimento>();
	Dao<Agenda> agendaDAO = new Dao<Agenda>();
	Dao<Medico> medicoDAO = new Dao<Medico>();
	
	public Medico [] listarNomeMedicos(){
		List<Medico> lista = medicoDAO.findAll("Medico");
		Medico[] m = new Medico[lista.size()];
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i] = lista.get(i));
		}
		return m;
	}
	
	public TipoProcedimento [] listarProcedimentos() {
		List <TipoProcedimento> proc = procDAO.findAll("TipoProcedimento");
		int qtd = proc.size();
		TipoProcedimento [] tipo = new TipoProcedimento[qtd];
			for(int i=0; i<proc.size(); i++){
				tipo[i]=proc.get(i);
			}
		return tipo;
	}
	
	
	public Paciente fazerLogin(String usuario, String senha) throws  PacienteException{
		List<Paciente> paciente = pacienteDAO.findAll("Paciente");
		Paciente p = new Paciente();
		for(int i=0; i< paciente.size(); i++){
			if(paciente.get(i).getUsuario().getUsuario().equals(usuario) && (paciente.get(i).getUsuario().getSenha().equals(senha))){
				p=paciente.get(i);
			}
			
			else {
				throw new  PacienteException();
			}
			
		}
		return p;
}

	
	
}
