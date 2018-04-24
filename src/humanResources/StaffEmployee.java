package humanResources;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class StaffEmployee extends Employee implements BusinessTraveller{
    private int bonus;
    private CircleLinkedList list;
    private int travelsQuantity;

    private static final int DEFAULT_VALUE = 0;

    public StaffEmployee(String firstName, String secondName){
        this(firstName, secondName, JobTitlesEnum.NONE, DEFAULT_VALUE, new CircleLinkedList<>());
    }

    public StaffEmployee(String firstName, String secondName, JobTitlesEnum jobTitles, int salary){
        this(firstName,secondName,jobTitles,salary, new CircleLinkedList<>());
    }

    public StaffEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, int salary, CircleLinkedList list){
        super(firstName, secondName, jobTitle, salary);
        this.list = list;
        this.bonus = DEFAULT_VALUE;
        this.travelsQuantity = DEFAULT_VALUE;
    }

    @Override
    public boolean isTravelNow(){
        BusinessTravel lastBusinessTravel = getTravels()[getTravels().length - 1];
        return LocalDate.now().isAfter(lastBusinessTravel.getBeginTravel())
                && LocalDate.now().isBefore(lastBusinessTravel.getEndTravel());
    }

    @Override
    public int getTravelDaysFromTimeLapse(LocalDate beginTravelMark, LocalDate endTravelMark){
        BusinessTravel[] businessTravels = getTravels();
        for(int i = 0; i < businessTravels.length; i++) {
            if (beginTravelMark.isAfter(businessTravels[i].getBeginTravel())
                    && endTravelMark.isBefore(businessTravels[i].getEndTravel()))
                return (int) ChronoUnit.DAYS.between(beginTravelMark, endTravelMark);

            if (beginTravelMark.isAfter(businessTravels[i].getBeginTravel())
                    && beginTravelMark.isBefore(businessTravels[i].getEndTravel())
                    && endTravelMark.isAfter(businessTravels[i].getEndTravel()))
                return (int) ChronoUnit.DAYS.between(beginTravelMark, businessTravels[i].getEndTravel());

            if (endTravelMark.isAfter(businessTravels[i].getBeginTravel())
                    && endTravelMark.isBefore(businessTravels[i].getEndTravel())
                    && beginTravelMark.isBefore(businessTravels[i].getBeginTravel()))
                return (int) ChronoUnit.DAYS.between(businessTravels[i].getBeginTravel(), endTravelMark);
        }
        return 0;
    }

    @Override
    public void addTravel(BusinessTravel travel) throws IllegalDatesException {
        BusinessTravel[] businessTravels = getTravels();
        for (BusinessTravel businessTravel : businessTravels) {
            if (travel.getBeginTravel().isAfter(businessTravel.getBeginTravel())
                    && travel.getBeginTravel().isBefore(businessTravel.getEndTravel()))
                throw new IllegalDatesException();
        }
        list.addNode(travel);
        travelsQuantity++;
    }

    @Override
    public BusinessTravel[] getTravels(){
        return list.getBusinessTravels();
    }

    public int getTravelsQuantity(){
        return travelsQuantity;
    }

    public int getBonus(){
        return bonus;
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString()).append("\n").append("Travels ").append("/n");
        BusinessTravel[] businessTravel = list.getBusinessTravels();
        for(int i = 0; i < businessTravel.length; i++){
            result.append(businessTravel[i].toString()).append("\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj instanceof StaffEmployee
                && super.equals(obj)
                && this.bonus == ((StaffEmployee) obj).bonus
                && travelsQuantity == ((StaffEmployee) obj).travelsQuantity) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return travelsQuantity ^ bonus ^ list.hashCode();
    }
}
