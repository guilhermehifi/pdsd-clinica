package rmi;

import java.io.Serializable;
import java.rmi.*;
import models.Usuario;

public interface Login extends Remote, Serializable {
	
	public void conectar(Usuario id) throws RemoteException;
	public void desconectar(Usuario id) throws RemoteException;
	

}
