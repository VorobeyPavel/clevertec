package com.example.employee_resume;

import com.example.employee_resume.dao.EmployeeRepository;
import com.example.employee_resume.entity.Employee;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class EmployeeResumeApplication {

    /*@Bean
    InitializingBean saveData(EmployeeRepository repo){
        return ()->{
            repo.save(new Employee("Antom", "Mironov", "HR", 900));
            repo.save(new Employee("Pavel", "Vorobey", "IT", 800));
            repo.save(new Employee("Sveta", "Rusetscay", "Salary", 750));
            repo.save(new Employee("Dima", "Steshko", "IT", 1100));
            repo.save(new Employee("Zaur", "Tregulov", "IT", 950));
            repo.save(new Employee("Anna", "Boloshova", "HR", 850));
            repo.save(new Employee("Maksim", "Avdeichik", "IT", 1200));
            repo.save(new Employee("Oleg", "Nisht", "IT", 1050));
            repo.save(new Employee("Anna", "Mironova", "Salary", 770));
        };
    }*/


    public static void main(String[] args) {
        SpringApplication.run(EmployeeResumeApplication.class, args);
    }

}
