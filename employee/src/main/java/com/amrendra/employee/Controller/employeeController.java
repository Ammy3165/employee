package com.amrendra.employee.Controller;

import com.amrendra.employee.Entity.Employee;
import com.amrendra.employee.Repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class employeeController {
    @Autowired
    private employeeRepository employeeRepo;

    public List<Employee> getAllEmployee(){
       List< Employee> employee=employeeRepo.findAll();
        return employee;

    }
}