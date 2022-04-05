package pro.sky.java.course2.skycourse2_hw_4;

import jdk.jfr.StackTrace;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.badRequestEmployeeException;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.internalServerErrorException;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.notFoundEmployeeException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        if (employees.contains(person)) {
            throw new badRequestEmployeeException("уже имеется такой сотрудник");
        } else {
            employees.add(person);
            return person;
        }

    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);

        if (employees.contains(person)) {
            employees.remove(person);
            return person;
        } else {
            throw new notFoundEmployeeException();
        }

    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        if (employees.contains(person)) {
            return person;
        } else {
            throw new notFoundEmployeeException();
        }
    }

    public List print() {
        return employees;
    }
}
