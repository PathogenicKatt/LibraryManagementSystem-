class Book extends LibraryItem implements Borrowable, Comparable<Book> {
    private String author;
    private boolean isBorrowed;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
        this.isBorrowed = false;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
        } else {
            throw new IllegalStateException("Book is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
        } else {
            throw new IllegalStateException("Book was not borrowed.");
        }
    }

    @Override
    public String getInfo() {
        return "Book: " + getTitle() + " by " + author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return this.getTitle().compareTo(other.getTitle());
    }
}
