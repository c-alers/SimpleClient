package llc.alersconsulting.client;

import java.util.Arrays;
import java.util.List;

import gov.nga.common.entities.art.Constituent.SORT;
import gov.nga.common.rpc.DataServiceManager;
import gov.nga.common.rpc.client.ClientConfiguration;
import gov.nga.common.search.ResultsPaginator;

public class ConstituentTestingClient 
{
	final private DataServiceManager manager;
	
	public ConstituentTestingClient(final ClientConfiguration config)
	{
		manager = DataServiceManager.getManager(config);
	}
	
	public void runTest()
	{
		final List<Long> ids = Arrays.asList(new Long[] {45L, 457L, 234L, 2456L, 50L, 654L, 823L, 13L, 1L, 22L, 453L, 32L, 102L, 55L});
		final ConstituentTest tester = new ConstituentTest(manager);
		tester.testByIDs(ids);
		tester.testByIDsSorted(ids, SORT.HASBIOGRAPHY_ASC, SORT.PREFERRED_DISPLAY_NAME_ASC);
		tester.testByIDsSorted(ids, SORT.PREFERRED_DISPLAY_NAME_ASC);
		tester.testConstituentPagination(new ResultsPaginator(3, 1), ids, SORT.PREFERRED_DISPLAY_NAME_ASC);
        tester.testConstituentPagination(new ResultsPaginator(3, 2), ids, SORT.PREFERRED_DISPLAY_NAME_ASC);
	}

}
