package uebungen.ringBuffer;

import uebungen.Student;

public class RingBufferArray
{
	private Student[] ringBuffer;
	private int pos = 0;
	
	public RingBufferArray(int limit)
	{
		ringBuffer = new Student[limit];
	}
	
	public void push(Student s)
	{
		if(pos%ringBuffer.length + 1 == ringBuffer.length) throw new  RuntimeException("Queue limit reached");
		
		ringBuffer[pos%ringBuffer.length] = s;
	}
	
	public Student pop()
	{
		Student ret = ringBuffer[pos % ringBuffer.length];
		ringBuffer[pos % ringBuffer.length]=null;
		return ret;
	}
	public Student peek()
	{
		return ringBuffer[pos%ringBuffer.length];
	}
	public int size()
	{
		return ringBuffer.length;
	}
	public int countElements()
	{
		return pos%ringBuffer.length;
	}
}
