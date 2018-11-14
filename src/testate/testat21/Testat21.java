package testate.testat21;

public class Testat21
{
	public static void main(String args[])
	{
		Period period = new Period(10);
		Period periodCopy = period.clone();
		
		periodCopy.change(10);
		
		System.out.println("--------Period Test---------");
		System.out.println("Period");
		System.out.println(period.toString());
		System.out.println("Copy:");
		System.out.println(periodCopy.toString());
		
		PointInTime pointInTime = new PointInTime(1000, 10, 20);
		PointInTime pointInTimeCopy = pointInTime.copy();
		pointInTimeCopy.change(20);
		
		
		System.out.println("--------Point in Time Test-------");
		System.out.println("Point in TIme:");
		System.out.println(pointInTime.toString());
		System.out.println("Copy:");
		System.out.println(pointInTimeCopy.toString());
		
		Date date = new Date("Baum", pointInTime, period);
		Date dateCopy = date.clone();
		dateCopy.change(10);
		
		System.out.println("--------Date Test--------");
		System.out.println("Date:");
		System.out.println(date.toString());
		System.out.println("Copy:");
		System.out.println(dateCopy.toString());
	}
}
