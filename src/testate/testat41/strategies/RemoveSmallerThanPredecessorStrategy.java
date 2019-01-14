package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class RemoveSmallerThanPredecessorStrategy implements DoublyLinkedList.DeletionStrategy<Integer>
{
	int last = -Integer.MAX_VALUE;
	public boolean select(Integer ref)
	{
		if(ref < last)
		{
			last = ref;
			return true;
		}
		last = ref;
		return false;
	}
}
