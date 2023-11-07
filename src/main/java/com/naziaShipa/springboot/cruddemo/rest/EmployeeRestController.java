package com.naziaShipa.springboot.cruddemo.rest;

import com.naziaShipa.springboot.cruddemo.dao.EmployeeDAO;
import com.naziaShipa.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.naziaShipa.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;


    //quick and dirty: inject employee dao
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    //expose "/employess" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
