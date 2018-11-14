package testate.testat12;

import java.util.HashSet;

public class Testat12
{
	public static void main(String args[])
	{
		System.out.println(countSequences(new int[]{80,7,1,0,11,72,0,0,37,61}));
	}
	
	public static int countNegatives(int[] arr)
	{
		int cnt = 0;
		for (int i : arr)
			if(i<0)
				cnt += 1;
		return cnt;
	}
	
	public static int sumUpNegatives(int[] arr)
	{
		int sum = 0;
		for (int i : arr)
			if(i<0)
				sum += i;
			return sum;
	}
	
	public static int maxValue(int[] arr)
	{
		int max = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if(max < arr[i])
				max = arr[i];
		}
		return max;
	}
	
	public static int maxValueCount(int[] arr)
	{
		int maxValue = arr[0];
		int acc = 0;
		
		for (int i : arr)
		{
			if(i == maxValue)
				acc++;
			if(i > maxValue)
			{
				maxValue = i;
				acc = 1;
			}
		}
		return acc;
	}
	
	public static boolean isSorted(int[] arr)
	{
		for (int i = 1; i < arr.length; i++)
		{
			if(arr[i-1] > arr[i])
				return false;
		}
		return true;
	}
	
	public static boolean isPalindrome(int[] arr)
	{
		for (int i = 0; i < arr.length/2; i++)
		{
			if(arr[i] != arr[arr.length - i  -1])
				return false;
		}
		return true;
	}
	
	public static int[] increseArray(int[] arr, int amount)
	{
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] += amount;
		}
		return arr;
	}
	
	public static int[] doubleIfContaindPositive(int[] arr)
	{
		int[] changed = new int[arr.length];
		HashSet<Integer> contained = new HashSet<>();
		
		for (int i = 0; i < arr.length; i++)
		{
			changed[i] = arr [i] * 2;
			if(!contained.contains(arr[i]))
				contained.add(arr[i]);
		}
		return changed;
	}
	public static String toString(int[] arr)
	{
		String string = "[";
		for (int i = 0; i < arr.length; i++)
		{
			if(i!= 0)
				string += ", ";
			string += arr[i];
		}
		string += "]";
		return string;
	}
	
	public static int[] addArrays(int[] arr1, int[] arr2)
	{
		if(arr1.length != arr2.length)
			return null;
		int[] added = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++)
		{
			added[i] = arr1[i] + arr2[i];
		}
		return added;
	}
	
	public static int countSequences(int[] arr)
	{
		int cnt = 0;
		boolean currSeq = false;
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i] == 0)
			{
				if (currSeq)
					currSeq = false;
				else
					cnt++;
			}
			else if(i == 0)
			{
				currSeq = true;
				cnt++;
			}
			
		}
		return cnt;
	}
}
