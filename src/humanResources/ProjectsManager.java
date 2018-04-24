package humanResources;

import java.time.LocalDate;

public class ProjectsManager implements GroupsManager{
    private Node<EmployeeGroup> head;
    private Node<EmployeeGroup> tail;
    private int size;

    public ProjectsManager(){
        this(new Node<EmployeeGroup>(null));
    }

    public ProjectsManager(Node<EmployeeGroup> head){
        this.head = head;
        tail.setNext(head);
        this.tail = head;
        this.size = 0;
    }

    @Override
    public int getPartTimeEmployeesQuantity(){
        int quantity = 0;
        Employee[] employees;
        EmployeeGroup[] groups = getEmployeesGroups();
        for(int i = 0; i < groups.length; i++) {
            employees = groups[i].getEmployees();
            for(int j = 0; j < employees.length; j++) {
                if (employees[j] instanceof PartTimeEmployee) {
                    quantity++;
                }
            }
        }
        return quantity;
    }

    @Override
    public int getStaffEmployeesQuantity(){
        int quantity = 0;
        Employee[] employees;
        EmployeeGroup[] groups = getEmployeesGroups();
        for(int i = 0; i < groups.length; i++){
            employees = groups[i].getEmployees();
            for(int j = 0; j < employees.length; j++) {
                if (employees[j] instanceof StaffEmployee) {
                    quantity++;
                }
            }
        }
        return quantity;
    }

    @Override
    public int getCurrentTravellersQuantity(){
        int quantity = 0;
        Employee[] employees;
        EmployeeGroup[] groups = getEmployeesGroups();
        for(int i = 0; i < groups.length; i++) {
            employees = groups[i].getEmployees();
            for (int j = 0; j < employees.length; j++) {
                if (((StaffEmployee) employees[j]).isTravelNow())
                    quantity++;
            }
        }
        return quantity;
    }

    @Override
    public Employee[] getCurrentTravellers(LocalDate beginTravelMark, LocalDate endTravelMark){
        Employee[] newEmployees = new Employee[getStaffEmployeesQuantity()];
        Employee[] employees;
        EmployeeGroup[] groups = getEmployeesGroups();
        int counter = 0;
        for(int i = 0; i < groups.length; i++) {
            employees = groups[i].getEmployees();
            for (int j = 0; j < employees.length; j++) {
                if (((StaffEmployee) employees[i]).getTravelDaysFromTimeLapse(beginTravelMark, endTravelMark) > 0)
                    newEmployees[counter] = employees[i];
            }
        }
        return newEmployees;
    }

    @Override
    public EmployeeGroup[] getEmployeesGroups(){
        EmployeeGroup[] groups = new EmployeeGroup[size];
        Node node = head;
        int counter = 0;
        while(node != null){
            groups[counter] = (Project) node.getValue();
            node = node.getNext();
            counter++;
        }
        return groups;
    }

    @Override
    public int groupsQuantity() {
        return size;
    }

    @Override
    public EmployeeGroup getEmployeeGroup(String name) {
        EmployeeGroup[] groups = getEmployeesGroups();
        for (int i = 0; i < size; i++) {
            if (groups[i] != null && groups[i].getName().equals(name))
                return groups[i];
        }
        return null;
    }

    @Override
    public Employee mostValuableEmployee() {
        int maxSalary = 0, index = 0;
        Employee[] employee;
        EmployeeGroup[] groups = getEmployeesGroups();
        for (int i = 0; i < size; i++) {
            if (groups[i] != null) {
                employee = groups[i].getEmployeesSortedBySalary();
                if (employee[0] != null && employee[0].getSalary() > maxSalary) {
                    maxSalary = employee[0].getSalary();
                    index = i;
                }
            }
        }
        employee = groups[index].getEmployeesSortedBySalary();
        return employee[0];
    }

    @Override
    public EmployeeGroup getEmployeesGroup(String firstName, String secondName) {
        EmployeeGroup[] groups = getEmployeesGroups();
        Employee[] employee;
        for (int i = 0; i < size; i++) {
            if (groups[i] != null) {
                employee = groups[i].getEmployees();
                for(int j = 0; j < employee.length; j++) {
                    if (employee[j] != null && (employee[j].getFirstName().equals(firstName)
                            && employee[j].getSecondName().equals(secondName)))
                        return groups[i];
                }
            }
        }
        return null;
    }

    @Override
    public int employeesQuantity(JobTitlesEnum jobTitle) {
        int quantity = 0;
        EmployeeGroup[] groups = getEmployeesGroups();
        Employee[] employee;
        for (int i = 0; i < size; i++) {
            if(groups[i] != null) {
                for(int j = 0; j < groups[i].getEmployees().length; j++){
                    employee = groups[i].getEmployees();
                    if(employee[j].getJobTitle().equals(jobTitle))
                        quantity++;
                }
            }
        }
        return quantity;
    }

    @Override
    public int employeesQuantity() {
        int quantity = 0;
        EmployeeGroup[] groups = getEmployeesGroups();
        for (int i = 0; i < size; i++) {
            if(groups[i] != null) {
                quantity += groups[i].employeeQuantity();
            }
        }
        return quantity;
    }

    @Override
    public void add(EmployeeGroup group) throws AlreadyAddedException {
        EmployeeGroup[] groupsHelper = getEmployeesGroups();
        for(int i = 0; i < groupsHelper.length; i++){
            if(group.equals(groupsHelper[i]))
                throw new AlreadyAddedException();
        }
        if(group == null)
            return;
        Node<EmployeeGroup> node = new Node<>(group);
        if(head == null)
            head = node;
        else
            tail.setNext(node);
        tail = node;
        size++;
    }

    @Override
    public boolean remove(String name) {
        Node<EmployeeGroup> current = head;
        Node<EmployeeGroup> previous = null;

        while(current != null){
            if(current.getValue().getName().equals(name)){
                if(previous != null){
                    previous.setNext(current.getNext());
                    if(current.getNext() == null)
                        tail = previous;
                }
                else{
                    head = head.getNext();
                    if(head == null)
                        tail = null;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int remove(EmployeeGroup group) {
        int counter = 0;
        Node<EmployeeGroup> current = head;
        Node<EmployeeGroup> previous = null;
        while(current != null){
            if(current.getValue().equals(group)){
                if(previous != null){
                    previous.setNext(current.getNext());
                    if(current.getNext() == null)
                        tail = previous;
                }
                else{
                    head = head.getNext();
                    if(head == null)
                        tail = null;
                }
                size--;
                counter++;
            }
            previous = current;
            current = current.getNext();
        }
        return counter;
    }
}
