package interfaces;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import models.Medico;
import models.Paciente;
import models.Procedimento;
import models.TipoProcedimento;

public interface ObjetoRemotoServidor extends Remote{
	
	public Paciente fazerLogin(String usuario, String senha) throws RemoteException;
	public void agendar(Procedimento procedimento, Calendar horario, Medico medico,
			Paciente paciente) throws RemoteException;
	public List <Procedimento> listarProcedimento() throws RemoteException;

}


