import java.util.Objects;

public class Employee {

    private final int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private int department;
    public double salary;
    static int count = 1;

    public Employee(String lastName, String firstName, String middleName, int department, double salary) {
        this.id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName, department, salary);
    }

    @Override
    public String toString() {
        return "Сотрудник: " + lastName + " " + firstName + " " + middleName;
    }

}
