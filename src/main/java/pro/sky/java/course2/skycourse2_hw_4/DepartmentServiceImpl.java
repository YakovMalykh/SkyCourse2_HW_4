package pro.sky.java.course2.skycourse2_hw_4;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> maxSalaryEmployee(Integer departmentId) {
        chekDepartment(departmentId);
        return printDepartmentComposition(departmentId).stream()
                .max(Comparator.comparingInt(employee -> employee.getSalary()));
    }

    @Override
    public Optional<Employee> minSalaryEmployee(Integer departmentId) {
        chekDepartment(departmentId);
        return printDepartmentComposition(departmentId).stream()
                .min(Comparator.comparingInt(employee -> employee.getSalary()));
    }

    @Override
    public Collection<Employee> printDepartmentComposition(Integer departmentId) {
        chekDepartment(departmentId);
        return employeeService.employees.values().stream()
                .filter(p -> p.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<String> printAllEmployee() {
        return employeeService.employees.values().stream()
                .map(p -> p.toString())
                .collect(Collectors.toList());
    }


    private void chekDepartment(Integer departmentId) {
        if (departmentId < 1 || departmentId > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
    }

}
