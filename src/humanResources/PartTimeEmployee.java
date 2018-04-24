package humanResources;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String firstName, String secondName,  int salary){
        this(firstName, secondName, JobTitlesEnum.NONE, salary);
    }

    public PartTimeEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, int salary){
        super(firstName, secondName, jobTitle, salary);
    }

    public int getBonus(){
        return 0;
    }

    public void setBonus(int bonus){ }

    @Override
    public String toString(){
        String result = String.format("%s, %s, %s, %dр.", super.getFirstName(), super.getSecondName(), super.getJobTitle(), super.getSalary());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        /*if(this == obj)
            return true;*/
        return this == obj & obj instanceof PartTimeEmployee && super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.getFirstName().hashCode()
                ^ super.getSecondName().hashCode()
                ^ super.getJobTitle().hashCode()
                ^ super.getSalary();
    }
}
