package testate.testat22;


public class Testat22
{
    public static void main(String[] args) {
        
    }

    public static int digitSum(int n)
    {
        if(n == 0)
            return 0;
        return n + digitSum(n-1);
    }
    public static double harm(int n)
    {
        if(n == 1)
            return 1;
        return 1/n + harm(n-1);
    }
    public static int power(int a, int n)
    {
        if(n == 0)
            return 1;
        return a * power(a, n-1);
    }
    public static int powerPlus(int a, int n)
    {
        if(n == 0)
            return 1;
        if(n%2 == 0)
            return powerPlus(a, n/2) * powerPlus(a, n/2);
        return powerPlus(a, (n-1)/2) * powerPlus(a, (n-1)/2);
    }
    public static String binaryCode(int i)
    {
        if(i == 1)
            return "1";
        if(i == 2)
            return "0";
        int mod = i%2;
        return binaryCode(i/2) + Integer.toString(mod);
    }
    public static int maximum(int[] arr, int i)
    {
        if(i == 0)
            return arr[i];
        int lastMax = maximum(arr, i-1);
        return arr[i] > lastMax? arr[i]: lastMax;
    }
    public static boolean isSorted(int[] a, int i) {
        if (i<0) 
            return true;
        
        if (a[i] > a[i-1]) 
            return false;
            
        return isSorted(a,i-1);
    }
    public static boolean contains(int arr[], int i, int x)
    {
        if(i == 0)
            return arr[i] == x;
        return arr[i] == x || contains(arr, i-1, x);
    }
    public static int countPositives(int arr[], int d, int t)
    {
        if( t== d)
            return arr[t] > 0 ? 1:0;
        if(arr[t] >0 )
            return countPositives(arr, d, t-1) + 1;
        return countPositives(arr, d, t-1);
    }
    public static boolean contentCheck(char[] arr1, char[]arr2, int i)
    {
        if(i == 0)
            return arr1[i] == arr2[i];
        return arr1[i] == arr2[i] && contentCheck(arr1, arr2, i-1);
    }
    public static boolean isPalindrome(char[] arr, int i)
    {
        if(i == arr.length/2)
            return arr[i] == arr[arr.length - i - 1];
        return arr[i] == arr[arr.length - 1 - i] && isPalindrome(arr, i++);
    }
    
}