package pro.sky.java.course2.skycourse2_hw_4;

import jdk.jfr.StackTrace;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.badRequestEmployeeException;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.internalServerErrorException;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.notFoundEmployeeException;

import java.util.*;

@Service
public class EmployeeService {
    Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName) {
        String personKey = firstName + lastName;
        Employee person = new Employee(firstName, lastName);
        if (employees.containsKey(personKey)) {
            throw new badRequestEmployeeException("уже имеется такой сотрудник");
        } else {
            employees.put(personKey, person);
        }
        return person;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        String personKey = firstName + lastName;
        if (!employees.containsKey(personKey)) {
            throw new notFoundEmployeeException("такого сотрудника нет");
        } else {
            return employees.remove(personKey);
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        String personKey = firstName + lastName;
        if (employees.containsKey(personKey)) {
            return employees.get(personKey);
        } else {
            throw new notFoundEmployeeException("такого сотрудника нет");
        }
    }
    public Collection print() {

        return employees.values();
    }
}
