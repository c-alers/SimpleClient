package llc.alersconsulting.samples;

public class SimplePOJO 
{
	private final Long constituent;
	private final Long id;
    private final String number;
    
    public SimplePOJO()
    {
    	this.constituent = 11L;
    	this.id = 30L;
    	this.number = "1234";
    }
    
    public Long getConstituent() {
		return constituent;
	}
	public Long getId() {
		return id;
	}
	public String getNumber() {
		return number;
	}
}
