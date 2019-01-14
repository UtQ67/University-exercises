package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class InsertFromListStrategy implements DoublyLinkedList.InsertionStrategy<Integer>
{
	private DoublyLinkedList<Integer> list;
	
	
	public InsertFromListStrategy(DoublyLinkedList<Integer> l)
	{
		list= l;
	}
	
	@Override
	public boolean select(Integer ref)
	{
		return false;
	}
	
	@Override
	public Integer toInsert(Integer ref)
	{
		return null;
	}
}
