public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String m)//the message is passed from the member class
    {
        super(m);
    }
}
