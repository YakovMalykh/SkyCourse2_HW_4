package pro.sky.java.course2.skycourse2_hw_4;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);


    Collection print();
}
