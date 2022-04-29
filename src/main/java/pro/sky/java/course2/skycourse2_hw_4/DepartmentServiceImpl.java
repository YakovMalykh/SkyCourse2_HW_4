package pro.sky.java.course2.skycourse2_hw_4;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {

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
        return employeeService.getEmployees().values().stream()
                .filter(p -> p.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Employee> printAllEmployee() {
        return employeeService.getEmployees().values().stream()
                .collect(Collectors.toList());
    }

    //сделал метод публичным, чтобы протестировать его
    public void chekDepartment(Integer departmentId) {
        if (departmentId < 1 || departmentId > 5) {
            throw new IllegalArgumentException("Такого отдела не существует");
        }
    }

}
