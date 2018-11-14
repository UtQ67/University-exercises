package testate.testat21;

public class PointInTime
{
	public int year;
	public int day;
	public int hour;
	
	public PointInTime(int _year, int _day, int _hour)
	{
		year = _year;
		day = _day;
		hour = _hour;
	
		normalizeHours();
	}
	
	private void normalizeHours()
	{
		if (hour >= 24)
		{
			day += hour/24;
			hour = hour %24;

			normalizeDays();
		}
	}
	
	private void normalizeDays()
	{
		if(day > 365)
		{
			year += day/365;
			day = day%365;
		}
	}
	public PointInTime copy()
	{
	return new PointInTime(year, day, hour);
	}
	
	public String toString()
	{
		String y = Integer.toString(year);
		String t = Integer.toString(day);
		String h = Integer.toString(hour);
		return y + "/" + t + "/" + h;
	}
	public void change(int _hour)
	{
		hour +=_hour;
		normalizeHours();
	}
}
