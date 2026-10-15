// I use custom exceptions (Chapter 7: Error Handling) to separate error logic from the happy path.
public class CartException extends Exception{
    public CartException(String message){
        super(message);
    }
}
