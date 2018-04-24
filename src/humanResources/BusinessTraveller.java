package humanResources;

import java.time.LocalDate;

public interface BusinessTraveller {
    void addTravel(BusinessTravel travel) throws IllegalDatesException;
    BusinessTravel[] getTravels();

    boolean isTravelNow();
    int getTravelDaysFromTimeLapse(LocalDate beginTravelMark, LocalDate endTravelMark);
}
