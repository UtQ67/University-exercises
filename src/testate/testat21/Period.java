package testate.testat21;

public class Period
{
	private int minutes;
	
	public Period(int _hours, int _minutes)
	{
		this(_hours * 60 + _minutes);
	}
	
	public Period(int _minutes)
	{
		if(_minutes <= 0)
			minutes = 0;
		else
			minutes = _minutes;
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	
	// Full hours
	public int getHours()
	{
		return minutes/60;
	}
	
	// Return the minutes when converted into Hours, minutes
	public int getMinorMinutes()
	{
		return  minutes - getHours() * 60;
	}
	
	// hh:mm
	public String toString()
	{
		String hours = Integer.toString(getHours());
		String minutes = Integer.toString(getMinorMinutes());
		return hours + ":" + minutes;
	}
	
	public Period clone()
	{
		return new Period(minutes);
	}
	
	public void change(int min)
	{
		if(min <= 0)
			return;
		minutes += min;
	}
}
