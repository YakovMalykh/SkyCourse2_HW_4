package pro.sky.java.course2.skycourse2_hw_4;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    Employee[] employees = new Employee[3];

    public Employee addEmployee(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else if (employees[i].equals(person)) {
                throw new badRequestEmployeeException();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = person;
                return employees[i];
            }
        }
        throw new internalServerErrorException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (person.equals(employees[i])) {
                employees[i] = null;
                return person;
            }
        }
        throw new notFoundEmployeeException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee person = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else if (employees[i].equals(person)) {
                return employees[i];
            }
        }
        throw new notFoundEmployeeException();
    }

    public String print() {
        String s = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                s = s + employees[i].toString();
            }
        }
        return s;
    }
}
