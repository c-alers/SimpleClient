package llc.alersconsulting.client;

import java.util.Arrays;
import java.util.List;

import gov.nga.common.entities.art.Constituent;
import gov.nga.common.entities.art.Constituent.SORT;
import gov.nga.common.entities.art.Exhibition;
import gov.nga.common.entities.art.QueryResult;
import gov.nga.common.rpc.DataServiceManager;
import gov.nga.common.search.ResultsPaginator;
import gov.nga.common.search.SearchHelper;
import gov.nga.common.search.SearchHelper.SEARCHOP;
import gov.nga.common.utils.CollectionUtils;

public class ConstituentTest extends Test 
{

	protected ConstituentTest(DataServiceManager manager) {
		super(manager);
	}
    
    private SearchHelper<Constituent> buildSearchHelper(final List<Long> ids)
    {
    	final List<String> testIDs = CollectionUtils.newArrayList();
    	for (Long id: ids) testIDs.add(id.toString());
        final SearchHelper<Constituent> sh = new SearchHelper<Constituent>();
        sh.addFilter(Constituent.SEARCH.CONSTITUENT_ID, SEARCHOP.IN, testIDs);
        return sh;
    }
	
	public void testByIDs(final List<Long> ids)
	{
		try
		{
			report(String.format("testFetch(%s): Starting....", ids));
			QueryResult<Constituent> rslt = getManager().fetchByConstituentIDs(ids);
			report(String.format("Total numer of results: %d", rslt.getResultCount()));
			for (Constituent obj: rslt.getResults())
			{
				if (obj != null)
				{
					report(obj.toString());
				}
				else
				{
					report("null Constituent???");
				}
			}
			report("\n\n");
		}
		catch (final Exception err)
		{
			report("testFetch(): Threw an exception:");
			err.printStackTrace();
		}
	}
	
	public void testByIDsSorted(final List<Long> ids, final Constituent.SORT...order)
	{
		try
		{
			report(String.format("testFetchBySorted(%s, %s): Starting....", ids, order));
			QueryResult<Constituent> rslt = getManager().fetchByConstituentIDs(ids, order);
			report(String.format("Total numer of results: %d", rslt.getResultCount()));
			for (Constituent obj: rslt.getResults())
			{
				if (obj != null)
				{
					report(obj.toString());
				}
				else
				{
					report("null Constituent???");
				}
			}
			report("\n\n");
		}
		catch (final Exception err)
		{
			report("testFetch(): Threw an exception:");
			err.printStackTrace();
		}
	}
    
    protected void testConstituentPagination(final ResultsPaginator rp, final List<Long> ids, final Enum<?>... order)
    {
        final QueryResult<Constituent> rslt = getManager().searchConstituents(buildSearchHelper(ids), rp, null, order);
        final StringBuilder report = new StringBuilder();
        report.append("Test query fetching objects: " + ids);
        report.append(String.format("\nRetrieving %d objects out of %d results from page %d", rp.getPageSize(), rslt.getResultCount(), rp.getPage()));
        for (Constituent obj: rslt.getResults())
        {
            report.append("\n"+obj);
        }
        report.append("\n\n");
        report(report.toString());
    }
}
