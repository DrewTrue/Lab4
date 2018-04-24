package humanResources;

public class NegativeSizeException extends NegativeArraySizeException {
    public NegativeSizeException(){
        super("Negative size!");
    }

    public NegativeSizeException(String message){
        super(message);
    }

    public String getMessageException(){
        return super.getMessage();
    }
}
