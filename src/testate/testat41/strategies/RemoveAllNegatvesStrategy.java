package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class RemoveAllNegatvesStrategy implements DoublyLinkedList.DeletionStrategy<Integer>
{
	@Override
	public boolean select(Integer ref)
	{
		return ref <= 0;
	}
}
