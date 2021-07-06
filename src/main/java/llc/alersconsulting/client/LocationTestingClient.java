package llc.alersconsulting.client;

import java.util.Arrays;

import gov.nga.common.rpc.DataServiceManager;
import gov.nga.common.rpc.client.ClientConfiguration;

public class LocationTestingClient 
{
	final private DataServiceManager manager;
	
	public LocationTestingClient(final ClientConfiguration config)
	{
		manager = DataServiceManager.getManager(config);
	}
	
	public void runTest()
	{
		LocationTest tester = new LocationTest(manager);
		tester.testFetcher(Arrays.asList(new Long[]{10L, 15L, 22L, 3587L, 6791L}));
	}
}
