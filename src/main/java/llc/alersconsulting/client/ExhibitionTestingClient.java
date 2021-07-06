package llc.alersconsulting.client;

import java.util.Arrays;

import gov.nga.common.rpc.DataServiceManager;
import gov.nga.common.rpc.client.ClientConfiguration;

public class ExhibitionTestingClient 
{
	final private DataServiceManager manager;
	
	public ExhibitionTestingClient(final ClientConfiguration config)
	{
		manager = DataServiceManager.getManager(config);
	}
	
	public void runTest()
	{
		final ExhibitionTest tester = new ExhibitionTest(manager);
		tester.testFetcher();
		tester.testNGAQuery();
		tester.testConstituents(Arrays.asList(new Long[]{4764L, 3018L, 3071L, 4712L}));
		tester.testExhibitionRights(4950L);
        for (Long id: new Long[] {4950L, 5133L})
        {
        	tester.testFilterExhibitionObject(id);
        }
	}
}
