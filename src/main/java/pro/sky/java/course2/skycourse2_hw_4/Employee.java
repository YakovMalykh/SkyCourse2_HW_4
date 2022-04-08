package pro.sky.java.course2.skycourse2_hw_4;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer departmentId;


    public Employee(String firstName, String lastName, Integer salary, Integer department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = department;
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Override
    public String toString() {
        return "Сотрудник: " + firstName + " " + lastName + ", ЗП: "
                + salary + ", отдел: " + departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName)
                && salary.equals(employee.salary) && departmentId.equals(employee.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, departmentId);
    }
}
