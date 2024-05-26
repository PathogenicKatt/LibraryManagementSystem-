import java.io.*;
import java.util.*;
//want to see the connection between the Library and Member class
//but actually the connection is with the LibraryItem class
//oh and remember that this is a Library Management System, meaning you also manage the books that are
//are in the libary
public class Library {
    private static final int MAX_ITEMS = 100;
    private static final int MAX_MEMBERS = 100;
    private LibraryItem[] items = new LibraryItem[MAX_ITEMS];//an array of Library items
    private Member[] members = new Member[MAX_MEMBERS];//here is the 1st relation
    private int itemCount = 0; //will increment every time a new item is added to the library
    private int memberCount = 0;//will increment everytime you add a new member
    //has nothing to do with the members, this just add items to the library
    public void addItem(LibraryItem item) {
        if (itemCount < MAX_ITEMS) {
            items[itemCount++] = item;
        } else {
            System.out.println("Library is full, cannot add more items.");
        }
    }
    //self explanotory, but basically you have to register first before you'd borrow a book
    public void registerMember(Member member) {
        if (memberCount < MAX_MEMBERS) {
            members[memberCount++] = member;//adding each registering member into an array
        } else {
            System.out.println("Library is full, cannot register more members.");
        }
    }
    //self explanotory, this is for members who wants to borrow items from the library and uses the itemId and the memberId
    //to check if the item is being borrowed by somebody else
    public void borrowItem(String itemId, int memberId) {
        LibraryItem item = findItemById(itemId);//looks for the specified itemId to be borrowed from the library
        if (item instanceof Borrowable) {
            ((Borrowable) item).borrow();
        } else {
            throw new IllegalArgumentException("Item cannot be borrowed.");
        }
    }

    public void returnItem(String itemId) {
        LibraryItem item = findItemById(itemId);
        if (item instanceof Borrowable) {
            ((Borrowable) item).returnItem();
        } else {
            throw new IllegalArgumentException("Item cannot be returned.");
        }
    }

    private LibraryItem findItemById(String itemId) { 
        //it's gonna iterate through the items array to see if the provided item id matches the one in an array
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getId().equals(itemId)) {
                return items[i];
            }
        }
        throw new IllegalArgumentException("Item not found");
    }
    
    public void displayItems() {
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].getInfo());
        }
    }
    //self explanotory, but because the memberCount changes every time a new member is added therefore you can use it to iterate
    //till that last member, rather than the MAX_MEMBERS variable
    public void displayMembers() {
        for (int i = 0; i < memberCount; i++) {
            System.out.println(members[i]);
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(Arrays.copyOf(items, itemCount));
            out.writeObject(Arrays.copyOf(members, memberCount));
        }
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            items = (LibraryItem[]) in.readObject();
            members = (Member[]) in.readObject();
            itemCount = items.length;
            memberCount = members.length;
        }
    }
}

