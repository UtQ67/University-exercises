package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class OneFollowsZeroStrategy implements DoublyLinkedList.InsertionStrategy<Integer>
{
	@Override
	public boolean select(Integer ref)
	{
		return ref == 0;
	}
	
	@Override
	public Integer toInsert(Integer ref)
	{
		return 1;
	}
}
