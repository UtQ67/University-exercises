package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class SubtotalOfThreeElementsStrategy implements DoublyLinkedList.InsertionStrategy<Integer>
{
	int n = -1;
	int sum = 0;
	@Override
	public boolean select(Integer ref)
	{
		sum += ref;
		n++;
		return n%3 == 2;
	}
	
	@Override
	public Integer toInsert(Integer ref)
	{
		return sum;
	}
}
