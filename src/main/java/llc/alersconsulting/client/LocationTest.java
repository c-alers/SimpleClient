package llc.alersconsulting.client;

import java.util.Arrays;
import java.util.List;

import gov.nga.common.entities.art.Location;
import gov.nga.common.entities.art.QueryResult;
import gov.nga.common.rpc.DataServiceManager;

public class LocationTest extends Test 
{

	protected LocationTest(DataServiceManager manager) {
		super(manager);
	}
	
	protected void testFetcher(final List<Long> objIds)
    {
        final StringBuilder report = new StringBuilder();
        final QueryResult<Location> rslt = getManager().fetchByLocationIDs(objIds);
        report.append("Test query fetching objects: " + objIds);
        report.append(String.format("\nRetrieved %d objects", rslt.getResultCount()));
        for (Location obj: rslt.getResults())
        {
            report.append(String.format("\n%s isExternal = %b", obj, obj.getIsExternal()));
        }
        report(report.toString());
    }

}
