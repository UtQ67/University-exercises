package uebungen.ringBuffer;

import uebungen.Student;

public class RingBufferArray
{
	public static void main(String[] args)
	{
		System.out.println(5%5);
		RingBufferArray test = new RingBufferArray(5);
		
		for (int i = 0; i < test.size(); i++)
		{
			test.push(new Student("a", "b", i));
		}
		test.pop();
		test.push(new Student("Push test", "", 10));
		while (test.peek() != null)
			System.out.println(test.pop().toString());
	}
	
	private Student[] ringBuffer;
	private int head = 0;
	private int tail = 1;
	
	public RingBufferArray(int limit)
	{
		ringBuffer = new Student[limit];
	}
	
	public void push(Student s)
	{
		if(tail == head) throw new  RuntimeException("Queue limit reached");
		ringBuffer[(tail)%ringBuffer.length] = s;
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
		return  (tail%ringBuffer.length) - (head % ringBuffer.length);
	}
}
