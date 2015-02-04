import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {

	private RMIClient() {}
	static Utilities utilities;

    public static void main(String[] args) {

       
        Utilities utilities = new Utilities("clientLogs.log");
        try 
        {
            Registry registry = LocateRegistry.getRegistry(Integer.parseInt(args[0]));
            KeyStoreInterface stub = (KeyStoreInterface) registry.lookup("KeyValueStore");
            String response = stub.put(1000, "Addme");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(1200, "Addme");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.get(100);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(1350, "K");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(100, "L");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
	    response = stub.delete(100);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(1020, "OL");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.get(500);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(1400, "OP");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.get(20);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.get(10);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.delete(78);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(3400, "WE");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(2345, "wq");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.delete(300);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.get(230);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.delete(90);
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(100, "Addme");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            response = stub.put(100, "Addme");
            utilities.log(Utilities.LogType.Information, "Received Response From Server.\n " + response);
            } 
        catch(RemoteException re){
			System.out.println("Unable to find the RMI Server");
		} catch(NotBoundException ne){
			System.out.println("RMI Server not bound");   }     
      
    }
}
