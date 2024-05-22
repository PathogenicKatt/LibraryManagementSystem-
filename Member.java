public class Member {
    private static int memberCounter=1; //use of static?
    private final int memberId;
    private String name;

    public Member()
    {
        this("");
    }
    public Member(String name)
    {
        setName(name);
        this.memberId=memberCounter++; //how is memberCounter accessible
    }
    public void setName(String name)
    {
        if(name==null || name.trim().isEmpty())
        {
            throw new InvalidDataException("Name cannot be null or empty")
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
}
