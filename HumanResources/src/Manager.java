public class Manager extends Staff implements ICaculator{
    private String position;
    //Normal constructor, setter and getter with some inheritances
    public Manager(String id, String name, int age, double coefficentsSalary, String dateStartWork, String department, int vacationDay, String position) {
        super(id, name, age, coefficentsSalary, dateStartWork, department, vacationDay);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    //Calculating salary according to the requirements of the assignment
    @Override
    public double calculateSalary() {
        double managerSalary=0.0;
        if (getPosition().equalsIgnoreCase("Business Leader")){
            managerSalary=getCoefficentsSalary()*5000000+8000000;
        }
        if (getPosition().equalsIgnoreCase("Project Leader")){
            managerSalary=getCoefficentsSalary()*5000000+5000000;
        }
        if (getPosition().equalsIgnoreCase("Technical Leader")){
            managerSalary=getCoefficentsSalary()*5000000+6000000;
        }
        return managerSalary;
    }
    //Display to console with String format
    @Override
    void displayinformation() {
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n",getId(),"|"+getName(),"|"+getAge(),
                "|"+getCoefficentsSalary(),"|"+getDateStartWork(),"|"+getVacationDay(),"|"+getDepartment(),"|"+getPosition(),"|"+String.format("%.2f",calculateSalary()));
    }
}
