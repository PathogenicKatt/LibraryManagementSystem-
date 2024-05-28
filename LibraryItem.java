import java.io.Serializable; //signals JVM that the instance of the class can be serialized
abstract class LibraryItem implements Serializable {
    private String id;
    private String title;

    public LibraryItem(String id, String title) {
        setId(id);
        setTitle(title);
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getInfo();
}
