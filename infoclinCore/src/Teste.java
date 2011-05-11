import java.rmi.RemoteException;


public class Teste {

	public static void main(String[] args) throws RemoteException {
		
		ImplLogin login = new ImplLogin();
		
		Usuario us = new Usuario(1, "dani", "123");
		ImplLogin serv = new ImplLogin();
		serv.conectar(us);
		
	}

}
