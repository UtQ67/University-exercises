package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class CountInIntervalStrategy implements DoublyLinkedList.InspectionStrategy<Integer>
{
	int bottom;
	int top;
	
	int quantity = 0;
	
	public CountInIntervalStrategy(int bottom, int top)
	{
		this.bottom = bottom;
		this.top = top;
	}
	
	public void inspect(Integer ref)
	{
		if(bottom <= ref && ref <= top)
			quantity++;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
}
