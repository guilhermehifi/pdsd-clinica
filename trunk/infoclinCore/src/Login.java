import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Login extends Remote{
	
	public void conectar(Usuario u) throws RemoteException;
	public void desconectar(Usuario u) throws RemoteException;

}
