package oop.assigment_problems;

class EmployeeData {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeData(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeStaticDemo {
    public static void main(String[] args) {
        EmployeeData employee1 = new EmployeeData("Divya", 65000);
        EmployeeData employee2 = new EmployeeData("Arjun", 50000);
        EmployeeData employee3 = new EmployeeData("Priya", 60000);

        EmployeeData.printCompanyInfo();
    }
}