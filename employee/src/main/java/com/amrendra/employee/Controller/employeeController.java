package com.amrendra.employee.Controller;

import com.amrendra.employee.Entity.Employee;
import com.amrendra.employee.Repository.employeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping
public class employeeController {
    @Autowired
    private employeeRepository employeeRepo;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
     employeeRepo.save(employee);
     return employee;
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
       List< Employee> employeeAll=employeeRepo.findAll();
        return employeeAll;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
       Employee employeeById=employeeRepo.findById(id).
                orElseThrow(()->new EntityNotFoundException("id not found:"+id));
        return employeeById;
    }

    @GetMapping("/empCity")
    public Employee getEmployeeByCity(@RequestParam String empCity){
        Employee employeeCity=employeeRepo.findByEmpCity(empCity);
        return employeeCity;
    }
  @GetMapping("/empAge")
  public Employee getEmpByAge(@RequestParam String empAge){
        Employee employeeByAge=employeeRepo.findByEmpAge(empAge);
      return employeeByAge;
  }
  @DeleteMapping("/{id}")
    public String deleteEmployeeByID(@PathVariable int id){
        employeeRepo.deleteById(id);
        return "Employee by id deleted successfully";
  }
  @DeleteMapping
    public String deleteEmployee(){
        employeeRepo.deleteAll();
        return "Employee deleted successfully";
  }

  @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee employee){
      Employee emp= employeeRepo.findById(id).
              orElseThrow(()->new EntityNotFoundException("Employee id not found:"+id));

        emp.setId(employee.getId());
        emp.setEmpName(employee.getEmpName());
        emp.setEmpAge(employee.getEmpAge());
        emp.setEmpCity(employee.getEmpCity());
        emp.setEmpSalary(employee.getEmpSalary());

        employeeRepo.save(emp);
        return employee;
  }
}