package testate.testat41.strategies;

import testate.testat41.DoublyLinkedList;

public class AddNToPositivesStrategy implements DoublyLinkedList.SubstitutionStrategy<Integer>
{
	int n;
	public AddNToPositivesStrategy(int n)
	{
		this.n = n;
	}
	
	public Integer substitute(Integer ref)
	{
		return ref+n;
	}
}
