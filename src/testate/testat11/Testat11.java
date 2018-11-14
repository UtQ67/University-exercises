package testate.testat11;

public class Testat11
{
	public static void main(String args[])
	{
		System.out.println(computeEuler(10));
	}
	
	
	public static int determinMaxinmum(int a, int b, int c )
	{
		int max = a;
		max = max < b? b : max;
		max = max < c? c : max;
		
		return max;
	}
	
	public static int interval(int a, int b)
	{
		a = a < b? a : b;
		
		int sum = 0;
		for(int i = a; i < b; i++)
			sum += i;
		return sum;
	}
	
	public static boolean isPythaTriple(int a, int b, int c)
	{
		if(c<a)
		{
			int temp = c;
			c = a;
			a = temp;
		}
		if (c < b)
		{
			int temp = c;
			c = b;
			b = temp;
		}
		return (a*a + b*b )==(c*c);
	}
	
	public static int digitSum(int n)
	{
		int sum = 0;
		while(n != 0)
		{
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
	
	public static String digitToString(int digit)
	{
		String[] dict = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		if (digit < 0 || digit > 9)
			return "";
		return  dict[digit];
	}
	
	public static String intToString(int n)
	{
		String str ="";
		
		if(n<0)
		{
			str += "minus-";
			n = -n;
		}
		
		for(int i = 0; n != 0; i++)
		{
			if(i != 0)
				str += "-";
			int modulo = 1;
			while (n > modulo * 10)
			{
				modulo *= 10;
			}
			str += digitToString(n/modulo);
			n /= 10;
		}
		return str;
	}
	public static String digitSumToString(int num)
	{
		return intToString(digitSum(num));
	}
	public static boolean isHarshad(int num)
	{
		return num%digitSum(num) == 0;
	}
	public static void computeHarshads(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			if (isHarshad(i))
				System.out.println(i + " is Harshaad");
		}
	}
	public static double computeEuler(int n)
	{
		double sum = 0;
		for(int i = 0; i < n; i++)
		{
			sum += 1/(double)factorial(i);
		}
		return sum;
	}
	
	public static int factorial(int n)
	{
		int fac = 1;
		for(int i = 1; i <= n ; i++)
		{
			fac *= i;
		}
		return fac;
	}
	
	public static void showSawTeeth(int n, int h)
	{
		if (h == 0)
			return;
		
		for (int hi = 0; hi < h; hi++)
		{
			String string = "";
			for (int ni = 0; ni < n; ni++)
			{
				int cntSpaces = h - hi - 1;
				int cntDash = hi + 1;
				string += createCharSequence(' ', cntSpaces);
				string += createCharSequence('/', cntDash);
			}
			System.out.println(string);
		}
	}
	public static String createCharSequence(char c, int length)
	{
		String seq = "";
		for (int i = 0; i < length; i++)
		{
			seq += c;
		}
		return seq;
	}
	
}
