package uebungen;

/**
 * Simple implementation of the binary search algorithm on sorted arrays
 */
public class BinarySearch
{

	public static boolean binarySearchRecursive(int[] sorted, int candidate)
	{
		return binarySearchRecursive(sorted, candidate, 0, sorted.length);
	}
	public static boolean binarySearchRecursive(int[] sorted, int candidate, int from, int to)
	{
		if(from == to)
			return sorted[from] == candidate;
		
		int middleIndex = from + to/2;
		
		if(sorted[middleIndex] == candidate)
			return true;
		if(sorted[middleIndex] < candidate)
			return binarySearchRecursive(sorted, candidate, from, middleIndex - 1);
		return binarySearchRecursive(sorted, candidate, middleIndex + 1, to);
	}
	
}
