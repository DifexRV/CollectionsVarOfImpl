package com.example.Collections.VarOfImpl.Collections.VarOfImpl.service;

import com.example.Collections.VarOfImpl.Collections.VarOfImpl.exception.EmployeeAlreadyAddedException;
import com.example.Collections.VarOfImpl.Collections.VarOfImpl.exception.EmployeeNotFoundException;
import com.example.Collections.VarOfImpl.Collections.VarOfImpl.exception.EmployeeStorageIsFullException;
import com.example.Collections.VarOfImpl.Collections.VarOfImpl.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String,Employee> employees = new HashMap<>(Map.of());

    @Override
    public Collection<Employee> employeeList() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee addEmployee(Employee employee) throws Exception {
        if (employees.size() >= 13) {
            throw new EmployeeStorageIsFullException();
        }

        if (employees.containsKey(employee.getFullName()) == true) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(employee.getFullName(), employee);
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) throws Exception {

        if (employees.containsKey(employee.getFullName()) == false) {
            throw new EmployeeNotFoundException();
        } else {
            return employees.remove(employee.getFullName());
        }

    }

    @Override
    public Employee findEmployee(Employee employee) throws Exception {

        if (employees.containsKey(employee.getFullName()) == false) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employee.getFullName());
    }

}