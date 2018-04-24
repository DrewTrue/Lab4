package humanResources;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class BusinessTravel {
    private int compensation;
    private LocalDate beginTravel;
    private LocalDate endTravel;
    private String description;
    private String destination;
    
    private final static String DEFAULT_LINE = "";
    private final static int DEFAULT_VALUE = 0;
    private final static LocalDate DEFAULT_BEGIN = LocalDate.now();
    private final static LocalDate DEFAULT_END = DEFAULT_BEGIN.plusDays(1);

    public BusinessTravel(){
        this(DEFAULT_LINE, DEFAULT_BEGIN, DEFAULT_END, DEFAULT_VALUE, DEFAULT_LINE);
    }

    public BusinessTravel(String destination, LocalDate beginTravel, LocalDate endTravel, int compensation, String description){
        if(endTravel.isBefore(beginTravel) && compensation < 0)
            throw new IllegalArgumentException();
        this.compensation = compensation;
        this.beginTravel = beginTravel;
        this.endTravel = endTravel;
        this.description = description;
        this.destination = destination;
    }

    public LocalDate getBeginTravel() {
        return beginTravel;
    }

    public LocalDate getEndTravel() {
        return endTravel;
    }

    public int getCompensation(){
        return compensation;
    }

    public int getDaysCount(){
        return (int)ChronoUnit.DAYS.between(beginTravel, endTravel);
    }

    public String getDescription(){
        return description;
    }

    public String getDestination(){
        return destination;
    }

    @Override
    public String toString(){
        String result = String.format("%d, %d, %s, %s", compensation, getDaysCount(), description, destination);
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if( obj instanceof BusinessTravel
                && compensation == ((BusinessTravel) obj).compensation
                && beginTravel.equals(((BusinessTravel) obj).beginTravel)
                && endTravel.equals(((BusinessTravel) obj).endTravel)
                && description == ((BusinessTravel) obj).description
                && destination == ((BusinessTravel) obj).destination) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return compensation ^ beginTravel.hashCode() ^ endTravel.hashCode() ^ destination.hashCode() ^ description.hashCode();
    }
}