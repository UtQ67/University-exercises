package testate.testat21;

import java.awt.datatransfer.StringSelection;

public class MultipleStrings
{
	private String texts[];
	
	public MultipleStrings(int n)
	{
		texts = new String[Math.abs(n)];
	}
	
	/**
	 * Add string at given position
	 *
	 * @param s	string to add
	 * @param p	index
	 * @return	false if failed, else true
	 */
	public boolean addAtPosition(String s, int p)
	{
		if(p >= texts.length)
			return false;
		if(p < 0)
			return false;
		texts[p] = s;
		return true;
	}
	
	/**
	 * Counts the occurrence of the given string at the end
	 *
	 * @param end String to search
	 * @return occurrence
	 */
	public int atEnd(String end)
	{
		int cnt = 0;
		for(String s : texts)
		{
			if (s == null)
				continue;
			if(s.endsWith(end))
				cnt++;
		}
		return cnt;
	}
	
	/**
	 * Checks if a char is in all texts
	 * @param c char to check
	 * @return true if c is in all texts, else false
	 */
	public boolean inAll(char c)
	{
		for(String s : texts)
		{
			if(s == null)
				continue;
			
			if(!(s.indexOf(c) >= 0))
				return false;
		}
		return true;
	}
	
	/**
	 * Replaces a char with another one in every text
	 * @param c char to replace
	 * @param r chat to replace with
	 */
	public void replace(char c, char r)
	{
		for (int i = 0; i < texts.length; i++)
		{
			if(texts[i]== null)
				continue;
			texts[i] = texts[i].replace(c, r);
		}
		
	}
}
