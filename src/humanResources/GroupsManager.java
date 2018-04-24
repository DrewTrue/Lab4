package humanResources;

import java.time.LocalDate;

public interface GroupsManager {
    int employeesQuantity();
    int groupsQuantity();
    void add(EmployeeGroup groupable) throws AlreadyAddedException;
    EmployeeGroup getEmployeeGroup(String name);
    EmployeeGroup[] getEmployeesGroups();
    int employeesQuantity(JobTitlesEnum jobTitle);
    EmployeeGroup getEmployeesGroup(String firstName, String secondName);
    Employee mostValuableEmployee();
    boolean remove(String groupName);
    int remove(EmployeeGroup group);

    int getPartTimeEmployeesQuantity();
    int getStaffEmployeesQuantity();
    int getCurrentTravellersQuantity();
    Employee[] getCurrentTravellers(LocalDate beginTravelMark, LocalDate endTravelMark);
}
