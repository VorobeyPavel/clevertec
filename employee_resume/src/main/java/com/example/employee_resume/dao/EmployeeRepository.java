package com.example.employee_resume.dao;


import com.example.employee_resume.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findAllByName(String name);
}
