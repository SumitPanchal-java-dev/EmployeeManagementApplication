package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable int id) {
        return employeeService.getOneEmployee(id);
    }

    @PostMapping
    public void createNewEmployee(@RequestBody Employee newEmployee) {
        employeeService.createEmployee(newEmployee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        updatedEmployee.setEmpid(id);
        employeeService.updateEmployee(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return employeeService.getAll();
    }
}
