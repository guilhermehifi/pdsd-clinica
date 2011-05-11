
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

public class ImplLogin implements Login, Serializable{
	
		public ImplLogin() throws RemoteException{
			UnicastRemoteObject.exportObject(this);
		}
		
		public void conectar(Usuario u) throws RemoteException {
			
		}



		public void desconectar(Usuario u) throws RemoteException {

		}
		
}
