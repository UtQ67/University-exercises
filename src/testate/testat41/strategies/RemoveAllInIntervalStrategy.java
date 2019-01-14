package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class RemoveAllInIntervalStrategy implements DoublyLinkedList.DeletionStrategy<Integer>
{
	int bottom;
	int top;
	
	public RemoveAllInIntervalStrategy(int bottom, int top)
	{
		this.bottom = bottom;
		this.top = top;
	}
	
	
	@Override
	public boolean select(Integer ref)
	{
		return bottom <= ref && ref <= top;
	}
}
