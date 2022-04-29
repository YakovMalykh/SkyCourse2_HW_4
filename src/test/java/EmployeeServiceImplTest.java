import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import pro.sky.java.course2.skycourse2_hw_4.Constants;
import pro.sky.java.course2.skycourse2_hw_4.Employee;
import pro.sky.java.course2.skycourse2_hw_4.EmployeeServiceImpl;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.BadRequestEmployeeException;
import pro.sky.java.course2.skycourse2_hw_4.Exceptions.NotFoundEmployeeException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.skycourse2_hw_4.Constants.*;

public class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
//    имеется ли аннтоция, которая позволяет выполнять метод только перед конктреным тестовым методом?
    public void fillEmployeeList() {
        out.getEmployees().put("IgorGorelov", EMPLOYEE_TEST);
        out.getEmployees().put("MaxMaksimov", EMPLOYEE_TEST_SECOND);
    }

    @Test
    public void shouldAddEmployeeInMapAndReturnEmployee() {
        Employee result = out.addEmployee(NAME, SURNAME, SALARY, DEPARTMENT_ID);
        assertEquals(EMPLOYEE_TEST_THIRD, result);
        assertTrue(out.getEmployees().containsValue(EMPLOYEE_TEST_THIRD));
    }

    @Test
    public void shouldThrowBadRequestEmployeeExceptionIfDoubleEmployees() {
        assertThrows(BadRequestEmployeeException.class, () -> out.addEmployee(
                EMPLOYEE_TEST.getFirstName(),
                EMPLOYEE_TEST.getLastName(),
                EMPLOYEE_TEST.getSalary(),
                EMPLOYEE_TEST.getDepartmentId()));
    }


    @Test
    public void shouldReturnEmployeesList() {
        Collection result = out.print();
        assertIterableEquals(EMPLOYEES_LIST, result);
    }

    @Test
    public void shouldCheckInputStringWhenCorrectString() {
        String result = out.checkInputStrings(CORRECT_STRINRG);
        assertEquals(CORRECT_STRINRG, result);
    }

    @Test
    public void shouldCheckInputStringWhenLowerCaseString() {
        String result = out.checkInputStrings(LOWER_CASE_STRING);
        assertEquals(CORRECT_STRINRG, result);
    }

    @Test
    public void shouldCheckInputStringWhenUpperCaseString() {
        String result = out.checkInputStrings(UPPER_CASE_STRING);
        assertEquals(CORRECT_STRINRG, result);
    }

    @Test
    public void shouldCheckInputStringAndThrowExceptionWenIsNotOnlyAlpha() {
        assertThrows(BadRequestEmployeeException.class, () -> out.checkInputStrings(INCORRECT_STRING));
    }

    public static Stream<Arguments> provideParametrsForTest() {
        return Stream.of(
                Arguments.of(NAME_1,SURNAME_1)
        );
    }// здесь понимаю, что не следует использовать параметриз-е методы, но очень хотелось воспользоваться
    // их функционалом. Правильно я понимаю, что использовать их нужно, если у меня есть перегруженные
    // методы или методы которые могут в параметры принять данные и в зависитмсоти от этих данных может
    // быть разный результат?
    @ParameterizedTest
    @MethodSource("provideParametrsForTest")
    public void shouldReturnEmployeeWhenHiFoundInFindEmployeeMethod(String name,String surname) {
        Employee result = out.findEmployee(name,surname);
        assertEquals(EMPLOYEE_TEST,result);
    }
    @ParameterizedTest
    @MethodSource("provideParametrsForTest")
    public void shouldReturnEmployeeWhenHiFoundInRemoveEmployeeMethod(String name,String surname) {
        Employee result = out.removeEmployee(name, surname);
        assertEquals(EMPLOYEE_TEST,result);
    }

    @Test
    public void shouldThrowNotFoundEmployeeExceptionFromFindEmployeeMethod() {
        assertThrows(NotFoundEmployeeException.class,()->out.findEmployee(NAME,SURNAME));
    }
    @Test
    public void shouldThrowNotFoundEmployeeExceptionFromRemoveEmployeeMethod() {
        assertThrows(NotFoundEmployeeException.class,()->out.removeEmployee(NAME,SURNAME));
    }

}
