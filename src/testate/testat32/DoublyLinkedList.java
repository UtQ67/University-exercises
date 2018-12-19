package testate.testat32;

import java.util.zip.DeflaterOutputStream;

public class DoublyLinkedList
{
    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    ///////////////////////
    public DoublyLinkedList(DoublyLinkedList dll)
    {
        Element current = dll.first;
        
        while (current != null)
        {
            add(current.getContent());
            current = current.getSucc();
        }
    }
    
    public void clear()
    {
        first = last = null;
        size = 0;
    }
    
    public Object getLast()
    {
        if(size == 0) throw new IllegalStateException();
        return last;
    }
    
    public boolean contains(Object o)
    {
        for(Element current = first; current != null; current = current.getSucc())
        {
            if(current.getContent() == o)
                return true;
        }
        return false;
    }
    
    public int count(Object o)
    {
        int cnt = 0;
        for(Element current = first; current != null; current = current.getSucc())
        {
            if(current.getContent().equals(o))
                cnt++;
        }
        return cnt;
    }
    
    public boolean allEqual()
    {
        if(size == 0 || size == 1) return true;
        
        for(Element current = first; current != null; current = current.getSucc())
        {
            if(!current.getContent().equals(first.getContent()))
                return false;
        }
        return true;
    }
    
    public boolean containsDoubles()
    {
        for(Element i = first; i != null; i = i.getSucc())
        {
            for (Element j = i.getSucc(); j != null ; j=j.getSucc())
            {
                if(i.getContent().equals(j.getContent()))
                    return true;
            }
        }
        return false;
    }
    
    public void insert(int n, Object o)
    {
        if (size < n) throw new IndexOutOfBoundsException();
        if(n == 0)
        {
            first.connectAsPred(new Element(o));
            first = first.getPred();
        }else if(n == size-1)
        {
            last.connectAsSucc(new Element(o));
            last = last.getSucc();
        }else
        {
            Element indexN = first;
            for (int i = 0; i < n; i++)
            {
                indexN = indexN.getSucc();
            }
    
            Element indexNSucc = indexN.getSucc();
            indexN.disconnectSucc();
            indexN.connectAsPred(new Element(o));
            indexN.getSucc().connectAsSucc(indexNSucc);
        }
        size++;
    }
    
    public void toArray(Object[] arr)
    {
        Element current = first;
    
        for (int i = 0; i<arr.length; i++)
        {
            if(current != null)
            {
                arr[i] = current.getContent();
                current = current.getSucc();
            }else
            {
                arr[i] = null;
            }
        }
    }
    
    public DoublyLinkedList flip()
    {
        DoublyLinkedList flipped = new DoublyLinkedList();
        
        for(Element current = last; current != null; current = current.getPred())
        {
            flipped.add(current.getContent());
        }
        return flipped;
    }
    
    public void remove(int n)
    {
        Element current = first;
        if(n == 0)
            first = first.getSucc();
        
        if (n== size)
            last = last.getPred();
        
        for (int i = 0; i <= n; i++)
        {
            current = current.getSucc();
        }
        Element succ = current.getSucc();
        current.disconnectSucc();
        
        Element pred = current.getPred();
        current.disconnectPred();
        
        pred.connectAsSucc(succ);
        
        size--;
    }
    
    public void concat(DoublyLinkedList dll)
    {
        last.connectAsSucc(dll.first);
        this.size += dll.size();
        last = dll.last;
        dll.clear();
    }
    
    public DoublyLinkedList subList(int from, int to)
    {
        Element current = first;
        for (int i = 0; i < from; i++)
        {
            current = current.getSucc();
        }
    
        DoublyLinkedList subList = new DoublyLinkedList();
        for (int i = 0; i < to; i++)
        {
            subList.add(current.getContent());
            current = current.getSucc();
        }
        return subList;
    }
    public void removeAll(DoublyLinkedList dll)
    {
        for(Element current = first; current != null;)
        {
            boolean deleted= false;
            for(Element currentDll = dll.first; currentDll != null; currentDll = currentDll.getSucc())
            {
                if(current.getContent().equals(currentDll.getContent()))
                {
                    deleted = true;
                    Element pred = current.getPred();
                    current = current.getSucc();
                    
                    pred.disconnectSucc();
                    current.disconnectPred();
                    
                    pred.connectAsSucc(current);
                }
            }
            if(!deleted)
                current = current.getSucc();
        }
    }
    public void pack()
    {
        Element current = first;
        
        while(current != null && current.getSucc() != null)
        {
            if(current.getContent().equals(current.getSucc().getContent()))
            {
                Element newSucc = current.getSucc().getSucc();
                
                current.disconnectSucc();
                current.connectAsSucc(newSucc);
            }else
            {
                current = current.getSucc();
            }
        }
    }
    //////////////////////////
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void addFirst( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            first.connectAsPred( e );
            first = e;
        }
        size++;
    }

    public Object getFirst() 
    {
        if ( !isEmpty() )
        {
            return first.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object get( int index ) 
    {
        if ( index >= 0 && index < size )
        {
            Element current = first;
            for ( int i = 0; i < index; i++ )
            {
                current = current.getSucc();
            }
            return current.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object removeFirst()
    {
        if ( !isEmpty() ) 
        {
            Object result = first.getContent();
            if ( first.hasSucc() )
            {
                first = first.getSucc();
                first.disconnectPred();
            }
            else
            {
                first = last = null;
            }
            size--;
            return result;
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent().toString() );
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

}
