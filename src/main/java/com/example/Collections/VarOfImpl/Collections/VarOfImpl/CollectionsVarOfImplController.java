package com.example.Collections.VarOfImpl.Collections.VarOfImpl;


import com.example.Collections.VarOfImpl.Collections.VarOfImpl.model.Employee;
import com.example.Collections.VarOfImpl.Collections.VarOfImpl.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class CollectionsVarOfImplController {
    private final EmployeeService employeeServiceimpl;

    public CollectionsVarOfImplController(EmployeeService employeeServiceimpl) {
        this.employeeServiceimpl = employeeServiceimpl;
    }

    @GetMapping
    public Collection<Employee> employeeList() {
        return employeeServiceimpl.employeeList();
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam(value = "lastName", required = false) String lastName) throws Exception {

        Employee employee = new Employee(firstName, lastName);
        try {
            employeeServiceimpl.addEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }


    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                   @RequestParam(value = "lastName", required = false) String lastName) throws Exception {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeServiceimpl.removeEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName", required = false) String lastName) throws Exception {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeServiceimpl.findEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
}
