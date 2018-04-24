package humanResources;

public class IllegalDatesException extends Exception{
    public IllegalDatesException(){
        super("The dates cross!");
    }

    public IllegalDatesException(String message){
        super(message);
    }

    public String getMessageException(){
        return super.getMessage();
    }
}
