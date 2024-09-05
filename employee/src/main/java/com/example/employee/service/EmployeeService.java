package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Address;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getOneEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void createEmployee(Employee newEmployee) {
        ArrayList<Address> addressList = new ArrayList<>();
        for (Address address : newEmployee.getAddresses()) {
            address.setEmployee(newEmployee);
            addressList.add(address);
        }
        newEmployee.setAddresses(addressList);
        employeeRepository.save(newEmployee);
    }

    public void updateEmployee(Employee updatedEmployee) {
        employeeRepository.save(updatedEmployee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
