package uebungen.ringBuffer;

import java.util.NoSuchElementException;

import dataStructurs.basic.Student;

public class RingBuffer
{
    private int limit;
    private int n;

    private Element first, last;

    public RingBuffer(int n)
    {
        limit = n;
    }

    public void push(Student s)
    {
        if(n>= limit)
            throw new RuntimeException("Queue limit reached");

        Element oldLast = last;
        last = new Element();
        last.student = s;
        n++;
        if(first == null)
            first = last;
        else
            oldLast.next = last;
    }
    public Student peek()
    {
        if(first == null) throw new NoSuchElementException("Queue empty");
        return first.student;
    }
    public Student pop()
    {
        if(first == null) throw new NoSuchElementException("Queue empty");

        Element el = first;
        first = first.next;
        n--;
        return el.student;
    }
    public int size()
    {
        return limit;
    }
    public int countElements()
    {
        return n;
    }

    private class Element
    {
        public Student student;
        public Element next;
    }

}