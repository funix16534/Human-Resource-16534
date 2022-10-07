public abstract class Staff {
    //Define necessary constructor
    private String id;
    private String name;
    private int age;
    private double coefficentsSalary;
    private String dateStartWork;
    private String department;
    private int vacationDay;
    //Normal constructor, setter and getter with some inherit
    public Staff(String id, String name, int age, double salary, String dateStartWork, String department, int vacationDay) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficentsSalary = salary;
        this.dateStartWork = dateStartWork;
        this.department = department;
        this.vacationDay = vacationDay;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCoefficentsSalary() {
        return coefficentsSalary;
    }

    public void setCoefficentsSalary(int coefficentsSalary) {
        this.coefficentsSalary = coefficentsSalary;
    }

    public String getDateStartWork() {
        return dateStartWork;
    }

    public void setDateStartWork(String dateStartWork) {
        this.dateStartWork = dateStartWork;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getVacationDay() {
        return vacationDay;
    }

    public void setVacationDay(int vacationDay) {
        this.vacationDay = vacationDay;
    }
    //Method to display
    abstract void displayinformation();

    abstract double calculateSalary();
}

    //Interface to calculate salary
    interface ICaculator{
    double calculateSalary();
    }