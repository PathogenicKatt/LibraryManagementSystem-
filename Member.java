public class Member {
    //private -> only accessible within that class
    /*this -> it is a keyword used to specify the current object, the instance of a class basically in comes handy when 
    you have variables of the same name*/
    
    private static int memberCounter=1; //used to indicate that particular member belongs to that class itself rather than 
    //as the instance of the class. Also they can be called class variables
    private final int memberId; //makes it final because we don't want it to be changed meaning it's for that member
    private String name;

    public Member() //somehow a default constructor is always required.
    {
        this("");/*if nothing is being passed, this constructor will by default put in an empty string which 
        throws an exception*/
    }
    public Member(String name)
    {
        setName(name);
        this.memberId=memberCounter++; //the this key word describes the instance of the class, 
    }

    public void setName(String name)
    {
        //trim() removes any leading or trailing whitespaces: " john " -> "john"
        //isEmpty() checks if the string has a length of zero: "" -> which returns true
        if(name==null || name.trim().isEmpty()) 
        {
            throw new InvalidDataException("Name cannot be null or empty");
        }
        this.name=name;
    }
    public int getMember_ID()
    {
        return memberId;
    }
    public String toString()
    {
        return "Member{"+
                "memberId="+ memberId+
                ", name="+name+ '\''+'}';
    }

    public static void main(String[]args)
    {
        Member member1,member2;
        //whenever you create an exception u need to use the try catch block 
        try{

            member1 = new Member("katt");
            member2 = new Member("Lulu");
            System.out.println(member1);
            System.out.println(member2);

        }catch(InvalidDataException e)
        {
            System.out.println(e);
        }
    }
}
