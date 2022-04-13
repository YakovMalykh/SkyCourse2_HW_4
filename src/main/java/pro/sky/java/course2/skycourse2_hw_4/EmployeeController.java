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

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/print")
    private Collection printEmployeeList() {
        return employeeService.print();
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String firstName,
                                @RequestParam("surname") String lastName,
                                @RequestParam("salary") Integer salary,
                                @RequestParam("department") Integer department) {
        return employeeService.addEmployee(firstName, lastName, salary,department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String firstName, @RequestParam("surname") String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String firstName, @RequestParam("surname") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

}
