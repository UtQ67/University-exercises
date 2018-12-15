package uebungen;

import java.util.Iterator;

public class iterator2DArray implements Iterator<Integer>
{
	private int x;
	private int y;
	private int[][] array;
	
	private int xOffset;
	private int yOffset;
	
	public iterator2DArray(int[][] array)
	{
		this.array = array;
		this.xOffset = 1;
		this.yOffset = 1;
	}
	public iterator2DArray(int[][] array, int xOffset, int yOffset)
	{
		this.array = array;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	@Override
	public boolean hasNext()
	{
		return x < array.length && y < array[x].length;
	}
	
	@Override
	public Integer next()
	{
		int oldX = x;
		int oldY = y;
		
		y += yOffset;
		if(!(y < array[x].length))
		{
			y = 0;
			x += xOffset;
		}
		
		return array[oldX][oldY];
	}
}
