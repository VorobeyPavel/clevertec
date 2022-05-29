package com.example.employee_resume.aspects;

import com.example.employee_resume.entity.Employee;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger log = Logger.getLogger(LoggingAspect.class);

    //тип Advice - @Before
    //указываем где должен выполн метод
    //возвращаем тип, имя и параметры обязательно указывать
    @Before("execution( * com.example.employee_resume.dao.EmployeeRepository.save(*))") //point cut
    public void beforeAddNewEmployeeAdvice(JoinPoint joinPoint) {
        //System.out.println("addNewEmployee: попытка добавить нового работника");

        Object[] arguments = joinPoint.getArgs();
        for (Object obj : arguments) {
            if (obj instanceof Employee) {
                Employee employee = (Employee) obj;
                if (employee.getId()==null){
                    System.out.println("Попытка добавить нового работника: "+Arrays.toString(arguments));
                    /*System.out.println("Попытка добавить нового работника: Name - " + employee.getName() +
                            ", surname - " + employee.getSurname() +
                            ", department - " + employee.getDepartment() +
                            ", salary - " + employee.getSalary());*/
                    log.info("Попытка добавить нового работника: "+Arrays.toString(arguments));
                    /*log.info("Попытка добавить нового работника: Name - " + employee.getName() +
                            ", surname - " + employee.getSurname() +
                            ", department - " + employee.getDepartment() +
                            ", salary - " + employee.getSalary());*/
                }
                if (employee.getId()==null){

                }
            }
        }
    }

    @AfterReturning("execution(  * com.example.employee_resume.dao.EmployeeRepository.save(*))") //point cut
    public void AfterReturningAddNewEmployeeAdvice(JoinPoint joinPoint) {

        System.out.println("AfterReturningAddNewEmployeeAdvice: работник добавлен");
        Object[] arguments = joinPoint.getArgs();
        System.out.println("Работник " + Arrays.toString(arguments) + " добавлен");
        log.info("Работник " + Arrays.toString(arguments) + " добавлен");
    }

    @AfterThrowing(pointcut = "execution( * com.example.employee_resume.dao.EmployeeRepository.save(*))",
            throwing = "exception")
    public void afterAddNewEmployeeAdvice(JoinPoint joinPoint, Throwable exception){

        Object[] arguments = joinPoint.getArgs();
        log.warn("Вы ввели неверный формат данных "+Arrays.toString(arguments));
        System.out.println("Вы ввели неверный формат данных "+Arrays.toString(arguments));
        //log.warn("You entered an invalid data format "+Arrays.toString(arguments));
        //System.out.println("You entered an invalid data format "+Arrays.toString(arguments));
    }



    @Before("execution( * com.example.employee_resume.dao.EmployeeRepository.deleteById(*))") //point cut
    public void beforeDeleteEmployeeAdvice(JoinPoint joinPoint){
        System.out.println("beforeDeleteEmployee: попытка удалить работника");

        Object[] arguments = joinPoint.getArgs();
        System.out.println("Попытка удалить работника с id = "+ Arrays.toString(arguments));
        log.info("Попытка удалить работника с id = "+ Arrays.toString(arguments));
        /*for (Object obj : arguments) {
            if (obj instanceof Employee) {
                Employee employee = (Employee) obj;
                if (employee.getId()==0){
                    System.out.println("Информация об удаленном работнике: Имя - " + employee.getName() +
                            ", surname - " + employee.getSurname() +
                            ", department - " + employee.getDepartment() +
                            ", salary - " + employee.getSalary());
                    log.info("Информация об удаленном работнике: Имя - " + employee.getName() +
                            ", surname - " + employee.getSurname() +
                            ", department - " + employee.getDepartment() +
                            ", salary - " + employee.getSalary());
                }
            }
        }*/
    }

    /*@AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
        System.out.println("afterThrowingGetStudentsLoggingAdvice: " +
                "логируем выброс исключения" + exception);
    }*/

    @AfterThrowing(pointcut = "execution( * com.example.employee_resume.dao.EmployeeRepository.deleteById(*))",
            throwing = "exception")
    public void afterThrowingDeleteEmployeeAdvice(JoinPoint joinPoint, Throwable exception){

        Object[] arguments = joinPoint.getArgs();
        log.warn("Работника c id = "+Arrays.toString(arguments)+" не существует");
        System.out.println("afterThrowingDeleteEmployeeAdvice: " +
                "Работника c id = "+Arrays.toString(arguments)+" не существует");
    }


    @AfterReturning("execution( * com.example.employee_resume.dao.EmployeeRepository.deleteById(*))") //point cut
    public void AfterDeleteEmployeeAdvice(JoinPoint joinPoint){

        System.out.println("AfterDeleteEmployee: работник удален");
        Object[] arguments = joinPoint.getArgs();
        System.out.println("Работник c id = "+Arrays.toString(arguments)+" удален ");
        log.info("Работник c id = "+Arrays.toString(arguments)+" удален ");
        /*for (Object obj : arguments) {
            if (obj instanceof Employee) {
                Employee employee = (Employee) obj;
                if (employee.getId()==0){
                    System.out.println("Информация об удаленном работнике: Имя - " + employee.getName() +
                            ", surname - " + employee.getSurname() +
                            ", department - " + employee.getDepartment() +
                            ", salary - " + employee.getSalary());
                    log.info("Информация об удаленном работнике: Имя - " + employee.getName() +
                            ", surname - " + employee.getSurname() +
                            ", department - " + employee.getDepartment() +
                            ", salary - " + employee.getSalary());
                }
            }
        }*/
    }





}
