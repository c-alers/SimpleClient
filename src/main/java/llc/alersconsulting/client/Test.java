package llc.alersconsulting.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.nga.common.rpc.DataServiceManager;
import gov.nga.common.utils.StringUtils;

public class Test 
{
	private Logger log;
	final private DataServiceManager manager;
	
	protected Test(final DataServiceManager manager)
	{
		this.manager = manager;
		this.log = LoggerFactory.getLogger(this.getClass());
	}
	
	protected void report(final String message)
	{
		if (StringUtils.isNotBlank(message))
		{
			//System.out.println( message);
			log.info(message);
		}
	}
	
	protected DataServiceManager getManager()
	{
		return manager;
	}
	
	public void testManager()
	{
		report(String.format("Data Manager: %s", manager));
	}
}
