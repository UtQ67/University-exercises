package uebungen.ringBuffer;

import uebungen.Student;

public class RingBufferArray
{
	private Student[] ringBuffer;
	private int head = 0;
	private int tail = 0;
	
	public RingBufferArray(int limit)
	{
		ringBuffer = new Student[limit];
	}
	
	public void push(Student s)
	{
		if(tail + 1== head) throw new  RuntimeException("Queue limit reached");
		
		ringBuffer[tail + 1%ringBuffer.length] = s;
		tail++;
	}
	
	public Student pop()
	{
		Student ret = ringBuffer[head % ringBuffer.length];
		ringBuffer[head % ringBuffer.length]=null;
		head++;
		return ret;
	}
	public Student peek()
	{
		return ringBuffer[head%ringBuffer.length];
	}
	public int size()
	{
		return ringBuffer.length;
	}
	public int countElements()
	{
		return  tail%ringBuffer.length - head % ringBuffer.length;
	}
}
