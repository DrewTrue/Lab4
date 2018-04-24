package humanResources;

public abstract class Employee{
    private String firstName;
    private String secondName;
    private JobTitlesEnum jobTitle;
    private int salary;

    protected Employee(String firstName, String secondName,  int salary){
        this(firstName, secondName, JobTitlesEnum.NONE, salary);
    }
    protected Employee(String firstName, String secondName, JobTitlesEnum jobTitle, int salary){
        if(salary < 0)
            throw new IllegalArgumentException();
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getSecondName(){
        return secondName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public JobTitlesEnum getJobTitle(){
        return jobTitle;
    }

    public void setJobTitle(JobTitlesEnum jobTitle){
        this.jobTitle = jobTitle;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public abstract int getBonus();
    public abstract void setBonus(int bonus);

    @Override
    public String toString(){
        String result = String.format("%s, %s, %s, %dр.", firstName, secondName, jobTitle, salary);
        if(firstName != null && secondName != null && jobTitle != JobTitlesEnum.NONE && salary != 0)
            return result;
        return "";
    }

    @Override
    public boolean equals(Object obj){
        return this == obj & firstName.equals(((Employee) obj).firstName)
                && secondName.equals(((Employee) obj).secondName)
                && jobTitle.equals(((Employee) obj).jobTitle)
                && salary == ((Employee) obj).salary;
    }

    @Override
    public int hashCode() {
        int hash = firstName.hashCode() ^ secondName.hashCode() ^ jobTitle.hashCode() ^ salary;
        return hash;
    }
}