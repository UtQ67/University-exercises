package dataStructurs.basic;

public class Student
{
    private String name;
    private String subject;
    private int registrationNo;
    // many other attributes
    
    public Student( String n, String sub, int no ) {
        name = n;
        subject = sub;
        registrationNo = no;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public int getRegistrationNo() {
        return registrationNo;
    }
    
    public boolean hasGreaterNumber( Student s )
    {
        return getRegistrationNo() > s.getRegistrationNo();
    }
    
    public boolean hasEqualNumber( Student s )
    {
        return getRegistrationNo() == s.getRegistrationNo();
    }
    
    public boolean hasGreaterName( Student s )
    {
        return getName().compareTo( s.getName() ) > 0;
    }
    
    public boolean hasEqualName( Student s )
    {
        return getName().compareTo( s.getName() ) == 0;
    }
    
    public String toString() {
        return "student: " + getName() + 
               ", registration number: " + getRegistrationNo() + 
               "(" + getSubject() + ")";
    }
}
