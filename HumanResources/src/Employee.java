public class Employee extends Staff implements ICaculator{
    private double overTimeHour;
    //Normal constructor, setter and getter with some inheritances
    public Employee(String id, String name, int age, double coefficientsSalary, String dateStartWork, String department, int vacationDay, double overTimeHour) {
        super(id, name, age, coefficientsSalary, dateStartWork, department, vacationDay);
        this.overTimeHour = overTimeHour;
    }

    public double getOverTimeHour() {
        return overTimeHour;
    }
    public void setOverTimeHour(int overTimeHour) {
        this.overTimeHour = overTimeHour;
    }
    //Calculating salary according to the requirements of the assignment
    public double calculateSalary(){
        return getCoefficentsSalary()*3000000+overTimeHour*200000;
    }
    //Display to console with String format
    @Override
    void displayinformation() {
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n",getId(),"|"+getName(),"|"+getAge(),"|"+getCoefficentsSalary(),"|"+getDateStartWork(),
                "|"+getVacationDay(),"|"+getDepartment(),"|"+getOverTimeHour(),"|"+String.format("%.2f",calculateSalary()));
    }
}

