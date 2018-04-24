package humanResources;

import java.time.LocalDate;

public interface EmployeeGroup {
    void addEmployee(Employee employee) throws AlreadyAddedException;
    Employee[] getEmployeesSortedBySalary();
    Employee[] getEmployees();
    int employeeQuantity();
    boolean removeEmployee(String firstName, String secondName);
    boolean removeEmployee(Employee employee);
    Employee getEmployee(String firstName, String secondName);
    String getName();
    void setName(String name);
    Employee mostValuableEmployee();
    String toString();
    boolean equals(Object obj);
    int hashCode();

    int getPartTimeEmployeesQuantity();
    int getStaffEmployeesQuantity();
    int getCurrentTravellersQuantity();
    Employee[] getCurrentTravellers(LocalDate beginTravelMark, LocalDate endTravelMark);
}
