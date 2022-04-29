package pro.sky.java.course2.skycourse2_hw_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/departments")
@RestController
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalaryEmployee(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.maxSalaryEmployee(departmentId);
    }

    @GetMapping("min-salary")
    public Optional<Employee> minSalaryEmployee(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.minSalaryEmployee(departmentId);
    }

    @GetMapping("/department") // с перегрузкой метода сложность возникла, если указываю all, то Spring выдает ошибку
    public Collection<Employee> printDepartmentComposition(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.printDepartmentComposition(departmentId);
    }
    @GetMapping("/all")
    public Collection<Employee> printAllEmployee() {
        return departmentService.printAllEmployee();
    }

}
