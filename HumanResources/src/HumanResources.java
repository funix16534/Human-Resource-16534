//Add necessary class
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class HumanResources {
    //Need for menu
    public static int choice;
    //Manage data by array lists
    public static ArrayList<Department> listDepartment = new ArrayList<>();
    public static ArrayList<Staff> listEmployee = new ArrayList<>();
    public static void main(String[] args){
        //Add Departments
        Department hr = new Department("HR","Human Resources");
        Department it = new Department("IT","Information Technolygy");
        Department mk = new Department("MK","Marketing");
        listDepartment.add(hr);
        listDepartment.add(it);
        listDepartment.add(mk);
        //I created this for test code and mentor can uses code faster.
        Employee hr01 = new Employee("HR01","Hana Snow",28,3.2,"10/10/2010","Human Resources",10,4.0);
        Employee it01 = new Employee("IT01","Andy de Van",25,2.5,"11/11/2010","Information Technology",5,4.5);
        Employee mk01 = new Employee("MK01","Daenerys",20,2.5,"8/3/983","Marketing",8,0.0);
        Manager hr02 = new Manager("HR02","BB Tran",30,4.0,"9/10/2009","Human Resources",7,"Technical Leader");
        Manager it02 = new Manager("IT02","Muscle Tard",28,4.5,"1/3/2015","Information Technology",0,"Project Leader");
        Manager mk02 = new Manager("MK02","Doraemon",229,5.0,"22/2/2222","Marketing",1,"Business Leader");
        listEmployee.add(hr01);
        listEmployee.add(it01);
        listEmployee.add(mk01);
        listEmployee.add(hr02);
        listEmployee.add(it02);
        listEmployee.add(mk02);
        //Each of departments have 2 staffs
        for (Department department: listDepartment){
            department.numEmployee+=2;
        }
        //Begin program
        menu();

    }
    public static void menu(){
        //Display menu and choose function
        System.out.print("""
                1 - Display the list of existing employees in the company
                2 - Show departments in the company
                3 - Display employees by department
                4 - Add new employees to the company
                5 - Search for employee information by name or employee code
                6 - Display payroll of employees throughout the company
                7 - Display employee payroll in ascending order
                8 - Display employee payroll in descending order
                Else Integer : Exit the program.
                """);
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        //Choose function
        choice = sc.nextInt();
        //After execute, return to menu. In my case, do-while and while cause bug or skip code, so I used if-else statement.
        if (choice==1){
            displayExistEmployee();
            menu();
        }
        if (choice==2){
            showDepartment();
            menu();
        }
        if (choice==3){
            displayEmployeeDepartment();
            menu();
        }
        if (choice==4){
            addNewStaff();
            menu();
        }
        if (choice==5){
            searchEmployee();
            menu();
        }
        if (choice==6){
            displayPayroll();
            menu();
        }
        //Advance requirement
        if (choice==7){
            displayPayrollAscending();
            menu();
        }
        if (choice==8){
            displayPayrollDescending();
            menu();
        }
    }
    //Display with string format, function 1 in menu
    public static void displayExistEmployee(){
        //String format
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
        for (Staff employee : listEmployee) {
            //Each employee display
            employee.displayinformation();
        }
    }
    //String format, function 2 in menu
    public static void showDepartment(){
        //String format
        System.out.printf("%-5s%-30s%-30s\n","ID","|Department","|Number of current employees");
        for (Department department : listDepartment) {
            //Each department display
            System.out.println(department);
        }
    }
    //Function 3 in menu, display by department name
    public static void displayEmployeeDepartment(){
        System.out.println("Human Resources");
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
        for (Staff employee : listEmployee) {
            //Each employee of HR department display
            if (employee.getDepartment().equals("Human Resources")) {
                employee.displayinformation();
            }
        }
        System.out.println("Information Technology");
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
        for (Staff employee : listEmployee) {
            if (employee.getDepartment().equals("Information Technology")) {
                //Each employee of IT department display
                employee.displayinformation();
            }
        }
        System.out.println("Marketing");
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
        for (Staff employee : listEmployee) {
            if (employee.getDepartment().equals("Marketing")) {
                //Each employee of MK department display
                employee.displayinformation();
            }
        }
    }
    //Function 4 in menu
    public static void addNewStaff(){
        Scanner sc = new Scanner(System.in);
        int employeeOrManager;
        //Add employee or manager
        System.out.println("1 - Add Employee");
        System.out.println("2 - Add Manager(with position)");
        System.out.print("You choose? ");
        employeeOrManager = sc.nextInt();
        //Validate choice
        if (employeeOrManager!=1&&employeeOrManager!=2){
            System.out.print("1 and 2 is the only choices. Please choose again! ");
            employeeOrManager = sc.nextInt();
        }
        //Input data for staff
        System.out.print("ID: ");
        String id = sc.next();
        //ID can have the same
        for (Staff employee: listEmployee ){
            if (employee.getId().equals(id)){
                System.out.println("Error: This ID have been taken. Please input ID again");
                id = sc.next();
            }
        }
        System.out.print("Name: ");
        sc.nextLine(); //input name
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt(); //input age
        System.out.print("Coefficients Salary: ");
        double coefficientsSalary = sc.nextDouble(); //input co.salary
        System.out.print("Date start work: ");
        String dateStartWork = sc.next(); //input day start work
        System.out.print("Number of days off work: ");
        int vacationDay = sc.nextInt(); //input days off work
        System.out.println("1. HR - Human Resources");
        System.out.println("2. IT - Information Technology");
        System.out.println("3. MK - Marketing");
        System.out.print("Department: ");
        //Choose department
        int numDepartment = sc.nextInt();
        //Validate choice
        if (numDepartment!=1&&numDepartment!=2&&numDepartment!=3){
            System.out.print("1, 2, 3 is the only choices. Please choose again! ");
            numDepartment = sc.nextInt();
        }
        String department="";
        if (numDepartment==1){
            department = "Human Resources";
        }
        if (numDepartment==2){
            department = "Information Technology";
        }
        if (numDepartment==3){
            department = "Marketing";
        }
        //When choose to add employee
        if (employeeOrManager==1){
            System.out.print("Overtime hours: ");
            double overTimeHour = sc.nextDouble(); //input overhour
            Employee newEmployee = new Employee(id, name, age, coefficientsSalary, dateStartWork,department,vacationDay, overTimeHour);
            //New object in arraylist
            listEmployee.add(newEmployee);
            listDepartment.get(numDepartment-1).numEmployee++; //increase number of employee
            System.out.println("You added a employee.");
        }
        //When choose to add manager
        if (employeeOrManager==2){
            System.out.println("1 - Business Leader");
            System.out.println("2 - Project Leader");
            System.out.println("3 - Technical Leader");
            System.out.print("Position: ");
            //Chooser position
            int numPosition = sc.nextInt();
            if (numPosition!=1&&numPosition!=2&&numPosition!=3){
                System.out.print("1, 2, 3 is the only choices. Please choose again! ");
                numPosition = sc.nextInt();
            }
            String position = "";
            if (numPosition==1){
                position = "Business Leader";
            }
            if (numPosition==2){
                position = "Project Leader";
            }
            if (numPosition==3){
                position = "Technical Leader";
            }
            Manager newManager = new Manager(id, name, age, coefficientsSalary,dateStartWork,department,vacationDay,position);
            listEmployee.add(newManager);
            //New object in arraylist
            listDepartment.get(numDepartment-1).numEmployee++; //increase number of employee
            System.out.println("You added a manager.");
        }
    }
    //Function 5 in menu
    public static void searchEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Search by ID");
        System.out.println("2 - Search by name");
        System.out.println("You choose?");
        //Choose search method
        int numSearch = sc.nextInt();
        if (numSearch!=1&&numSearch!=2) {
            //Validate choice
            System.out.println("1 and 2 is the only choice. Please choose again!");
            numSearch = sc.nextInt();
        }
        if (numSearch==1){
            System.out.print("Type ID: ");
            String idSearch = sc.next(); //input search
            //follow input, display result
            boolean result = false; //need to display if the searching have no result
            for (Staff employee: listEmployee){
                //display employee if have ID requires
                if (employee.getId().contains(idSearch)){
                    System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
                    employee.displayinformation();
                    result = true;
                }
            }
            //The searching have no result
            if (!result){
                System.out.println("No result!");
            }
        }
        if (numSearch==2){
            System.out.print("Type Name: ");
            String nameSearch = sc.next();
            //follow input, display result
            boolean result = false; //Need to display if the searching have no result
            for (Staff employee: listEmployee){
                //display employee have name requires
                if (employee.getName().contains(nameSearch)){
                    System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
                    employee.displayinformation();
                    result = true;
                }
            }
            //The searching have no result
            if (!result){
                System.out.println("No result!");
            }
        }
    }

    //Function 6 in menu
    public static void displayPayroll(){
        //String format
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
        for (Staff employee : listEmployee) {
            //display each employee
            employee.displayinformation();
        }
    }
    //Function 7 in menu
    public static void displayPayrollAscending(){
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
        //sort the higher salary bottom in list employee
        Collections.sort(listEmployee, new Comparator<Staff>() {
            @Override
            public int compare(Staff emp1, Staff emp2) {
                if (emp1.calculateSalary() < emp2.calculateSalary()) {
                    return -1;
                } else {
                    if (emp1.calculateSalary() == emp2.calculateSalary()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
        //display employee again
        for (Staff employee: listEmployee){
            employee.displayinformation();
        }
    }
    public static void displayPayrollDescending(){
        System.out.printf("%-10s%-40s%-5s%-25s%-20s%-20s%-30s%-40s%-20s\n","ID","|Name","|Age","|Coeficient Salaray","|Date Start Work","|Days Off Work","|Department","|Position/Overtime","|Salary");
        //sort the lower salary bottom
        Collections.sort(listEmployee, new Comparator<Staff>() {
            @Override
            public int compare(Staff emp1, Staff emp2) {
                if (emp1.calculateSalary() < emp2.calculateSalary()) {
                    return 1;
                } else {
                    if (emp1.calculateSalary() == emp2.calculateSalary()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
        //display employee again
        for (Staff employee: listEmployee){
            employee.displayinformation();
        }
    }
}
