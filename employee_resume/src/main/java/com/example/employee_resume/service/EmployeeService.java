package com.example.employee_resume.service;

import com.example.employee_resume.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    //public String saveEmployee(Employee employee);

    public Employee getEmployee(Long id);

    public String deleteEmployee(Long id);

    public List<Employee> findAllByName(String name);
}
