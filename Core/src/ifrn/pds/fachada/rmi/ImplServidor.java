package ifrn.pds.fachada.rmi;

import ifrn.pds.dao.Dao;
import ifrn.pds.excecao.PacienteException;
import ifrn.pds.model.Agenda;
import ifrn.pds.model.Medico;
import ifrn.pds.model.Paciente;
import ifrn.pds.model.TipoProcedimento;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

public class ImplServidor implements InterfaceRemotaServidor{
	
	private static final long serialVersionUID = 1L;
	Dao<Paciente> pacienteDAO = new Dao<Paciente>();
	Dao<TipoProcedimento> procDAO = new Dao<TipoProcedimento>();
	Dao<Agenda> agendaDAO = new Dao<Agenda>();
	Dao<Medico> medicoDAO = new Dao<Medico>();
	
	public ImplServidor() throws RemoteException{
		UnicastRemoteObject.exportObject(this);
	}
	
	public void agendar(TipoProcedimento tipoProcedimento, Date data, String hora, Medico medico,Paciente paciente)
	throws RemoteException{
			Agenda agenda = new Agenda();
			agenda.setTipoProcedimento(tipoProcedimento);
			agenda.setData(data);
			agenda.setHorario(hora);
			agenda.setMedico(medico);
			agenda.setPaciente(paciente);
			agendaDAO.persist(agenda);
	}

	//funcionando e testado
	public Paciente fazerLogin(String usuario, String senha) throws RemoteException, PacienteException{
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

	//funcionando e testado
	public TipoProcedimento [] listarProcedimentos() throws RemoteException{
		List <TipoProcedimento> proc = procDAO.findAll("TipoProcedimento");
		int qtd = proc.size();
		TipoProcedimento [] tipo = new TipoProcedimento[qtd];
			for(int i=0; i<proc.size(); i++){
				tipo[i]=proc.get(i);
			}
		return tipo;
	}
	
	public String horariosDisponiveis() throws RemoteException {
		return null;
	}
	
	//testado funciona retorna a lista de medico, para retornar o nome dos medicos
	public Medico [] listarNomeMedicos()throws RemoteException{
		List<Medico> lista = medicoDAO.findAll("Medico");
		Medico[] m = new Medico[lista.size()];
		for (int i = 0; i < m.length; i++) {
			m[i] = lista.get(i);
		}
		return m;
	}

}
