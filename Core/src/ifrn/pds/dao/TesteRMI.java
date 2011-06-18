package ifrn.pds.dao;

import ifrn.pds.excecao.PacienteException;
import ifrn.pds.model.Agenda;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.Procedimento;


import java.rmi.RemoteException;
import java.util.List;

public class TesteRMI {
	
	Dao<Paciente> pacienteDAO = new Dao<Paciente>();
	Dao<Procedimento> procDAO = new Dao<Procedimento>();
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
	
	public Procedimento [] listarProcedimento(Paciente p1) {
		List <Procedimento> proc = procDAO.findAll("Procedimento");
		Procedimento [] p = new Procedimento[proc.size()];
		for(int i=0; i<p.length; i++){
			p[i] = proc.get(i);
		}
			for(int x=0; x<p.length; x++){
				if(p[x].getPaciente().getId()==p1.getId())
					return p;
			}
		return null;
	}
	
	
	public Paciente fazerLogin(String usuario, String senha) throws  PacienteException{
		List<Paciente> paciente = pacienteDAO.findAll("Paciente");
		Paciente p = new Paciente();
		for(int i=0; i< paciente.size(); i++){
			if(paciente.get(i).getUsuario().equals(usuario) && (paciente.get(i).getSenha().equals(senha))){
				p=paciente.get(i);
			}
			
			else {
				throw new  PacienteException();
			}
			
		}
		return p;
}

	
	
}
