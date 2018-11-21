package uebungen;

/**
 * Simple implementation of the binary search algorithm on sorted arrays
 */
public class BinarySearch
{
	
	private static boolean bonarySearchIterative(int[] sorted, int candidate)
	{
		int l = 0;
		int r = sorted.length;
		while (l > r)
		{
			int middleIndex = l + (r - l)/2;
			
			if(sorted[middleIndex] == candidate)
				return true;
			
			if(sorted[middleIndex] < candidate)
				r = middleIndex - 1;
			else
				l = middleIndex + 1;
		}
		
		return sorted[l] == candidate;
	}
	
	
	public static boolean binarySearchRecursive(int[] sorted, int candidate)
	{
		return binarySearchRecursive(sorted, candidate, 0, sorted.length);
	}
	private static boolean binarySearchRecursive(int[] sorted, int candidate, int l, int r)
	{
		if(l == r)
			return sorted[l] == candidate;
		
		if(l > r)
			return false;
		
		int middleIndex = l + (r - l)/2;
		
		if(sorted[middleIndex] == candidate)
			return true;
		if(sorted[middleIndex] < candidate)
			return binarySearchRecursive(sorted, candidate, l, middleIndex - 1);
		return binarySearchRecursive(sorted, candidate, middleIndex + 1, r);
	}
	
}
