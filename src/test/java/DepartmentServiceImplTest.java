import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.skycourse2_hw_4.*;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.skycourse2_hw_4.Constants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldReturnDepartmentCompositionLikeCollectionEmployees() {
        when(employeeServiceMock.getEmployees()).thenReturn(EMOLOYEES_MAP);

        Collection result = out.printDepartmentComposition(DEPARTMENT_ID);
        assertIterableEquals(EMPLOYEE_LIST_DEPARTMENT_1, result);
    }

    @Test
    public void shouldReturnCollectionOfAllEmployees() {
        when(employeeServiceMock.getEmployees()).thenReturn(EMOLOYEES_MAP);

        Collection result = out.printAllEmployee();
        assertIterableEquals(EMPLOYEES_LIST, result);
    }

    @Test
    public void shouldReturnEmployeeWithMaxSalary() {
        when(employeeServiceMock.getEmployees()).thenReturn(EMOLOYEES_MAP);
        Optional<Employee> result = out.maxSalaryEmployee(1);
        assertEquals(Optional.of(EMPLOYEE_TEST), result);
    }
    @Test
    public void shouldReturnEmptyOptionalIfDepartmentEmpty(){
        when(employeeServiceMock.getEmployees()).thenReturn(EMOLOYEES_MAP);
        Optional<Employee> result2 = out.maxSalaryEmployee(3);
        assertTrue(result2.isEmpty());
    }

    @Test
    public void shouldReturnEmployeeWithMinSalary() {
        when(employeeServiceMock.getEmployees()).thenReturn(EMOLOYEES_MAP);
        Optional<Employee> result = out.minSalaryEmployee(2);
        assertEquals(Optional.of(EMPLOYEE_TEST_SECOND),result);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenIncorrectDepartmentId() {
        assertThrows(IllegalArgumentException.class, () ->
                out.chekDepartment(INCORRECT_DEPARTMENT_ID));
    }


}
