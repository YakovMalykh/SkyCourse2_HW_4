package pro.sky.java.course2.skycourse2_hw_4;

import java.util.Collection;
import java.util.Optional;

public interface DepartmentService {

    Optional<Employee> maxSalaryEmployee(Integer departmentId);

    Optional<Employee> minSalaryEmployee(Integer departmentId);

    Collection<Employee> printDepartmentComposition(Integer departmentId);

    Collection printAllEmployee();
}
