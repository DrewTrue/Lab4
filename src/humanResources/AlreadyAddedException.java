package humanResources;

public class AlreadyAddedException extends Exception{
    public AlreadyAddedException(){
        super("Employee already added!");
    }

    public AlreadyAddedException(String message){
        super(message);
    }

    public String getMessageException(){
        return super.getMessage();
    }
}
