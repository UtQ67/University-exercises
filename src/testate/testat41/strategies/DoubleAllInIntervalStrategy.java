package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class DoubleAllInIntervalStrategy implements DoublyLinkedList.SubstitutionStrategy<Integer>
{
	int top;
	int bottom;
	
	
	public DoubleAllInIntervalStrategy(int top, int bottom)
	{
		this.top = top;
		this.bottom = bottom;
	}
	
	public Integer substitute(Integer ref)
	{
		if(top <= ref && ref <= bottom)
			return ref*ref;
		return ref;
	}
}
