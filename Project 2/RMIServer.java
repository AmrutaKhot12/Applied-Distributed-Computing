import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class RMIServer implements KeyStoreInterface
{
	private static final long serialVersionUID = -8501200304595115835L;
	public RMIServer() {}
	
	// Declare a hashmap to store the key value pairs
    Map<Integer, String> keyValue = new HashMap<Integer, String>();
    static RMIServer instance = null;
    Utilities utilities;

    static 
    {
        if (instance == null)
        {
            instance = new RMIServer();
            createStore();
        }
    }
    
    /**
   	 * This method pre-populates the key value store with 100 key value pairs.
   	 */
       static void createStore()
       {
	       	for(int i = 1 ; i <= 100 ; i++)
	       	{
	       		instance.keyValue.put(i, (5 * i)+"");
	   		}
       }
	
	/**
	 * This method adds a requested key and value pair in the keyvalue store.
	 * @param Integer key  key to be added
	 * @param String value value for the key to be added
	 * @return String  Returns the appropriate message 
	 */
    public String put(Integer key, String value)
    {
    	String message;
    	utilities.writeToConsole("Received Request from Client: PUT( " + key + "," + value +" )");
    	System.err.println("Put operation");
    	if (instance.keyValue.containsKey(key))
        {
    		message = "The requested key " + key + " already exists";
    		utilities.writeToConsole("Sent to Client:" + message);
            return message;
        }
    	else
    	{
    		instance.keyValue.put(key, value); 
    		message = "The requested key " + key + " is added successfully";
    		utilities.writeToConsole("Sent to Client:" + message);
    		return message;
        }
    	
    }
    	
    /**
	 * This method gets the value based on the input key.
	 * @param Integer key  Value for the key to be fetched.
	 * @return String  Returns value 
	 */
    public String get(Integer key)
    {
    	String message;
    	utilities.writeToConsole("Received Request from Client: GET( " + key + " )");
        if (!instance.keyValue.containsKey(key))
        {  
        	message = "The requested key"+ key + "was not found.";
        	utilities.writeToConsole("Sent to Client:" + message);
            return message;
        }
        message = "The Value is " + instance.keyValue.get(key) + " for key " + key;
        utilities.writeToConsole("Sent to Client:" + message);
        return message;
    }

    /**
	 * This method deletes a requested key and value pair from the keyvalue store.
	 * @param Integer key  key to be deleted
	 * @return String  Returns the appropriate message if the key was deleted or not.
	 */
    public String delete(Integer key)
    {
    	String message;
    	utilities.writeToConsole("Received Request from Client: DELETE( " + key + " )");
        if (!instance.keyValue.containsKey(key))
        {
        	message = "The requested key" + key + "was not found.";
        	utilities.writeToConsole("Sent to Client:" + message);
            return message;
        }
        instance.keyValue.remove(key);
        message = "The requested key " + key + " is removed";
        utilities.writeToConsole("Sent to Client:" + message);
        return message;
    }
	
 public static void main(String args[]) {
	
        
        try 
        {
            final RMIServer obj = new RMIServer();
            KeyStoreInterface stub = (KeyStoreInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry(Integer.parseInt(args[0]));
            registry.bind("KeyValueStore", stub);
            System.err.println("Server ready");
            
         // Create a new thread for each client
		    Thread t =new Thread();
		    t.start();

	
           
        } 
        catch (Exception e) 
        {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
	

}
