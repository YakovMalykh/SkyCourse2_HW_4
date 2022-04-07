package pro.sky.java.course2.skycourse2_hw_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/print")//добавил метод, чтобы понимать как именяется массив сотрудников
    private Collection printEmployeeList() {
        return employeeService.print();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam ("name") String firstName, @RequestParam ("surname") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam ("name") String firstName, @RequestParam ("surname") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("name") String firstName, @RequestParam ("surname") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

}
