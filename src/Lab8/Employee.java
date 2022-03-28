package Lab8;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Employee {

    private String name;
    private String employeeType;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public int getSalary() {
        return salary;
    }

    public int setSalary () {
        switch (employeeType) {
            case "Full time":
                this.salary = 50000;
                break;
            case "Contractor":
                this.salary = 40000;
                break;
            default:
                this.salary = 0;
                break;
        }
        return salary;
    }
}
