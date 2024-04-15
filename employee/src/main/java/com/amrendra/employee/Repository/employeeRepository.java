package com.amrendra.employee.Repository;

import com.amrendra.employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmpCity(String empCity);

    Employee findByEmpAge(String empAge);
}
