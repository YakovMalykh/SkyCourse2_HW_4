package pro.sky.java.course2.skycourse2_hw_4;

import pro.sky.java.course2.skycourse2_hw_4.Employee;

import java.util.*;

public class Constants {
    public static final String NAME = "Pavel";
    public static final String SURNAME = "Pavlov";
    public static final Integer SALARY = 150000;
    public static final Integer DEPARTMENT_ID = 1;
    public static final Integer INCORRECT_DEPARTMENT_ID=6;

    public static final String NAME_1 = "Igor";
    public static final String SURNAME_1 = "Gorelov";

    public static final Employee EMPLOYEE_TEST = new Employee("Igor", "Gorelov",
            130000, 1);

    public static final Employee EMPLOYEE_TEST_SECOND = new Employee("Max", "Maksimov",
            100000, 2);
    public static final Employee EMPLOYEE_TEST_THIRD = new Employee(NAME, SURNAME, SALARY, DEPARTMENT_ID);

    public static final Collection EMPLOYEES_LIST = new ArrayList<>(List.of(EMPLOYEE_TEST, EMPLOYEE_TEST_SECOND));

    public static final Collection EMPLOYEE_LIST_DEPARTMENT_1 = new ArrayList<>(List.of(EMPLOYEE_TEST));

    public static final Map<String,Employee> EMOLOYEES_MAP = new HashMap(Map.of(
            "IgorGorelov",EMPLOYEE_TEST,
            "MaxMaksimov",EMPLOYEE_TEST_SECOND)
    );

//    public static final Collection SECOND_EMPLOYEES_LIST = new ArrayList<>(
//            List.of(EMPLOYEE_TEST, EMPLOYEE_TEST_SECOND, EMPLOYEE_TEST_THIRD));

    public static final String CORRECT_STRINRG = "Oleg";
    public static final String UPPER_CASE_STRING = "OLEG";
    public static final String LOWER_CASE_STRING = "oleg";
    public static final String INCORRECT_STRING = "ol12";
}
