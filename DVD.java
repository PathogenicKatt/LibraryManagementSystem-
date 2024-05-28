public class DVD extends LibraryItem implements Borrowable {
    public DVD(String id, String title) {
        super(id, title);
    }

    @Override
    public void borrow() {
        // Borrow logic
    }

    @Override
    public void returnItem() {
        // Return logic
    }

    @Override
    public String getInfo() {
        return "DVD: " + getTitle();
    }
}
