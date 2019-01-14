package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class AverageOfPositivesStrategy implements DoublyLinkedList.InspectionStrategy<Integer>
{
	int n = 0;
	int sum = 0;
	public AverageOfPositivesStrategy()
	{
	}
	
	public void inspect(Integer ref)
	{
		n++;
		sum++;
	}
	
	public float getAverage()
	{
		return sum/n;
	}
}
