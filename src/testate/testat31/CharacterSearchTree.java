package testate.testat31;

import javax.lang.model.util.ElementScanner6;

public class CharacterSearchTree
{ 
    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() 
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public CharacterSearchTree(char[] chars)
    {
        for (char c : chars) 
            add(c);
        
    }

    public HuffmanTriple getContent()
    {
        if ( !isEmpty() )
        {
            return content;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isEmpty() 
    {
        return content == null;
    }

    public boolean isLeaf() 
    {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void add(char t, int q, String c)
    {
        if(isEmpty())
        {
            content = new HuffmanTriple(t, q);
            content.setCode(c);

            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        }
        else
        {
            if(content.getToken()>t)
                leftChild.add(t, q, c);
            else if(content.getToken()<t)
                rightChild.add(t,q,c);
            else
            {
                content.setCode(c);
                for(int i = 0; i < q; i++)
                    content.incrementQuantity();
            }
        }
    }

    public void add( char t )
    {
        if ( isEmpty() ) 
        {
            content = new HuffmanTriple( t );
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        }
        else
        {
            if ( content.getToken() > t )
            {
                leftChild.add( t );
            }
            else if ( content.getToken() < t )
            {
                rightChild.add( t );
            }
            else
            {
                content.incrementQuantity();
            }
        }
    }

    public void iterativeAdd( char t )
    {
        CharacterSearchTree current = this;
        while ( !current.isEmpty() && current.content.getToken() != t )
        {
            if ( current.content.getToken() > t )
            {
                current = current.leftChild;
            }
            else
            {
                current = current.rightChild;
            }
        }
        if ( current.isEmpty() ) 
        {
            current.content = new HuffmanTriple( t );
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        }
        else
        {
            current.content.incrementQuantity();
        }
    }

    public String getCode( char t )
    {
        if ( !isEmpty() ) 
        {
            if ( content.getToken() > t )
            {
                return leftChild.getCode( t );
            }
            else if ( content.getToken() < t )
            {
                return rightChild.getCode( t );
            }
            else
            {
                return content.getCode();
            }
        }
        else
        {
            throw new IllegalStateException();
        }
    }
    
    public int countCharacter()
    {
        if(isEmpty())
            return 0;
        return leftChild.countCharacter() + rightChild.countCharacter() + content.getQuantity();
    }

    public int longestCode()
    {
        if(isEmpty())
            return 0;
        int leftLength = leftChild.longestCode();
        int rightLength = rightChild.longestCode();

        int longestChild = leftLength > rightLength? leftLength : rightLength;

        return content.getCode().length() > longestChild ? content.getCode().length() : longestChild;
        
    }

    public int size() 
    {
        if ( isEmpty() ) 
        {
            return 0;
        }
        else
        {
            return 1 + leftChild.size() + rightChild.size();
        }       
    }

    public int height()
    {
        if(isEmpty())
            return 0;
        int leftHeight = leftChild.height();
        int rightHeight = rightChild.height();
        return leftHeight > rightHeight? leftHeight+1 : rightHeight+1;
    }

    public void show()
    {
        if ( !isEmpty() ) 
        {
            leftChild.show();
            System.out.println( content.toString() );
            rightChild.show();
        }
    }

    public void showPreOrder()
    {
        if(!isEmpty())
        {
            if(isLeaf())
                System.out.print("*");
            System.out.println(content.toString());
            leftChild.showPreOrder();
            rightChild.showPreOrder();
        }
    }
    public HuffmanTriple[] toArray()
    {
        if ( !isEmpty() ) 
        {
            HuffmanTriple[] collector = new HuffmanTriple[size()];
            toArray( collector, 0 );
            return collector;
        }
        return new HuffmanTriple[0];
    }

    private int toArray( HuffmanTriple[] collector, int index ) 
    {
        if ( !isEmpty() )
        {
            index = leftChild.toArray( collector, index );
            collector[index] = content;
            index = rightChild.toArray( collector, index + 1 );
        }
        return index;
    }  
}
