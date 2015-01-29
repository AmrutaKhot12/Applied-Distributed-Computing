import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

	private RMIClient() {}
	static Utilities utilities;

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        Utilities utilities = new Utilities("D:/clientLogs.log");
        try 
        {
            Registry registry = LocateRegistry.getRegistry(host);
            KeyStoreInterface stub = (KeyStoreInterface) registry.lookup("KeyValueStore");
            String response = stub.put(1000, "Addme");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(100, "Addme");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
        } 
        catch (Exception e) 
        {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        
      
    }
}
