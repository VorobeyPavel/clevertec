package com.example.employee_resume.service;

import com.example.employee_resume.aspects.LoggingAspect;
import com.example.employee_resume.dao.EmployeeRepository;
import com.example.employee_resume.entity.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static final Logger log = Logger.getLogger(LoggingAspect.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){
            employee = optional.get();
        }
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
        }catch (ConstraintViolationException e){
            System.out.println("saveEmployee: Вы ввели неверный формат данных");
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    /*@Override
    public String saveEmployee(Employee employee) {
        String message = null;
        try {
            employeeRepository.save(employee);
        }catch (NullPointerException e){
            message = "Exception: you entered an invalid data format";
        }
        return message;
    }*/

    @Override
    public String deleteEmployee(Long id) {
        String message = "Employee with ID=" + id + " was delete";
        try {
            employeeRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            message = "EmptyResultDataAccessException. Employee with ID= "+id+" does not exist";
        }
        return message;
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employeeList = employeeRepository.findAllByName(name);
        return employeeList;
    }
}
