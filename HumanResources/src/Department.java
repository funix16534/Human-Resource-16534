public class Department {
    //Define necessary variables
    private String id;
    private String department;
    int numEmployee;
    //Constructor
    public Department(String id, String department){
        this.id=id;
        this.department=department;
        this.numEmployee=0;
    }
    //Setter & getter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumEmployee() {
        return numEmployee;
    }

    public void setNumEmployee(int numEmployee) {
        this.numEmployee = numEmployee;
    }
    //Print
    public String toString(){
        return String.format("%-5s%-30s%-30s",getId(),"|"+getDepartment(),"|"+getNumEmployee());
    }
}
