package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class AllToAbsStrategy implements DoublyLinkedList.SubstitutionStrategy<Integer>
{
	public AllToAbsStrategy(){}
	
	public Integer substitute(Integer ref)
	{
		if(ref < 0)
			return -ref;
		return ref;
	}
}
