import java.io.IOException;

public class LibraryUniversitySystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some items and members for testing
        library.addItem(new Book("123", "Java Programming","Gunther"));
        library.addItem(new DVD("456", "Inception"));
        library.registerMember(new Member("Alice"));
        library.registerMember(new Member("Bob"));

        // Display items and members
        library.displayItems();
        library.displayMembers();

        // Test borrowing and returning items
        try {
            library.borrowItem("123", 1);
            library.returnItem("123");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Save to file and load from file
        try {
            library.saveToFile("library.dat");
            library.loadFromFile("library.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Display items and members again after loading from file
        library.displayItems();
        library.displayMembers();
    }
}
