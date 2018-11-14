package testate.testat21;

public class Date
{
	private String name;
	private PointInTime start;
	private Period period;
	
	public Date(String _name, PointInTime _start, Period _period)
	{
		name = _name;
		start = _start;
		period = _period;
	}
	
	
	public void set(PointInTime _start, Period _period)
	{
		start = _start;
		period = _period;
	}
	
	public void change(int hours)
	{
		if(start != null)
		{
			start.change(hours);
		}
	}
	
	public String toString()
	{
		String subject = "Name: " + name;
		String startString = start.toString();
		String periodString = period.toString();
		
		return  subject + "\n" + startString + "\n" + periodString;
	}
	
	public Date clone()
	{
		return new Date(name, start.copy(), period.clone());
	}
	
	public PointInTime getStart()
	{
		return start;
	}
	
	public Period getPeriod()
	{
		return period;
	}
	
	public String getName()
	{
		return name;
	}
}
