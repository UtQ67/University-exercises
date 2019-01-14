package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class RemoveAndCountAllInIntervalStrategy implements DoublyLinkedList.DeletionStrategy<Integer>
{
	int bottom;
	int top;
	
	int cnt = 0;
	
	public RemoveAndCountAllInIntervalStrategy(int bottom, int top)
	{
		this.bottom = bottom;
		this.top =  top;
	}
	
	public boolean select(Integer ref)
	{
		if(bottom <= ref && ref <= top)
		{
			cnt++;
			return true;
		}
		return false;
	}
	
	public int getQuantity()
	{
		return cnt;
	}
}
