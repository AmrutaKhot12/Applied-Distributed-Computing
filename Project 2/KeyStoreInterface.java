import java.rmi.Remote;
import java.rmi.RemoteException;


public interface KeyStoreInterface extends Remote{
	
	String put(Integer key, String value) throws RemoteException;
	
	String get(Integer key) throws RemoteException;
	
	String delete(Integer key) throws RemoteException;
}

