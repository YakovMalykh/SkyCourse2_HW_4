package pro.sky.java.course2.skycourse2_hw_4;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.BadRequestEmployeeException;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.NotFoundEmployeeException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        String name = checkInputStrings(firstName);
        String surname = checkInputStrings(lastName);
        String personKey = name + surname;
        Employee person = new Employee(name, surname, salary, department);
        if (employees.containsKey(personKey)) {
            throw new BadRequestEmployeeException("уже имеется такой сотрудник");
        } else {
            employees.put(personKey, person);
        }
        return person;    }

    public Employee removeEmployee(String firstName, String lastName) {
        String name = checkInputStrings(firstName);
        String surname = checkInputStrings(lastName);
        String personKey = name + surname;
        if (!employees.containsKey(personKey)) {
            throw new NotFoundEmployeeException("такого сотрудника нет");
        } else {
            return employees.remove(personKey);
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        String name = checkInputStrings(firstName);
        String surname = checkInputStrings(lastName);
        String personKey = name + surname;
        if (employees.containsKey(personKey)) {
            return employees.get(personKey);
        } else {
            throw new NotFoundEmployeeException("такого сотрудника нет");
        }
    }

    public Collection print() {

        return employees.values();
    }

    private String checkInputStrings(String string) {

        if (!StringUtils.isAlpha(string)) {
            throw new BadRequestEmployeeException("введены недопустимые символы");//как сделать так,
            // чтобы это сообщение выводилось в консоль?
        }
        return StringUtils.capitalize(string);
    }

}
