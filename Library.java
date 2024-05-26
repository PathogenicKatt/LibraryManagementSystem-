import java.io.*;
import java.util.*;
//want to see the connection between the Library and Member class
public class Library {
    private static final int MAX_ITEMS = 100;
    private static final int MAX_MEMBERS = 100;
    private LibraryItem[] items = new LibraryItem[MAX_ITEMS];
    private Member[] members = new Member[MAX_MEMBERS];//here is the 1st relation
    private int itemCount = 0;
    private int memberCount = 0;

    public void addItem(LibraryItem item) {
        if (itemCount < MAX_ITEMS) {
            items[itemCount++] = item;
        } else {
            System.out.println("Library is full, cannot add more items.");
        }
    }

    public void registerMember(Member member) {
        if (memberCount < MAX_MEMBERS) {
            members[memberCount++] = member;
        } else {
            System.out.println("Library is full, cannot register more members.");
        }
    }

    public void borrowItem(String itemId, int memberId) {
        LibraryItem item = findItemById(itemId);
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

