package llc.alersconsulting;



import gov.nga.common.rpc.client.ClientConfiguration;
import llc.alersconsulting.client.ConstituentTestingClient;
import llc.alersconsulting.client.ExhibitionTestingClient;
import llc.alersconsulting.client.LocationTestingClient;

/**
 * Hello world!
 *
 */
public class App implements ClientConfiguration
{
	
	
	public static void main( String[] args )
    {
    	System.out.println( "Hello! Beginning client tests..." );
        try
        {
        	final ClientConfiguration config = new App();
        	final ExhibitionTestingClient exClient = new ExhibitionTestingClient(config);
        	final ConstituentTestingClient cstClient = new ConstituentTestingClient(config);
        	final LocationTestingClient locClient = new LocationTestingClient(config);
        	exClient.runTest();
        	cstClient.runTest();
        	locClient.runTest();
        
        }
    	catch(final Exception err)
        {
    		System.out.println("An exception has occured");
    		err.printStackTrace();
        }
    	System.out.println("Test suite has completed!");
    }

	public String getConnectionURL() 
	{
		return "ap-artdataservicetst-priv.nga.gov:8081";
	}
}
