package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class SubtotalStrategy implements DoublyLinkedList.InsertionStrategy<Integer>
{
	
	int n = 0;
	int sum = 0;
	@Override
	public boolean select(Integer ref)
	{
		sum += ref;
	 	return true;
	}
	
	@Override
	public Integer toInsert(Integer ref)
	{
		return sum;
	}
}
