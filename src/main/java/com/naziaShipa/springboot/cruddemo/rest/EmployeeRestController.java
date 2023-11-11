package com.naziaShipa.springboot.cruddemo.rest;

import com.naziaShipa.springboot.cruddemo.dao.EmployeeDAO;
import com.naziaShipa.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.naziaShipa.springboot.cruddemo.entity.Employee;
import com.naziaShipa.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;


    //quick and dirty: inject employee dao
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    //expose "/employess" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException(" Employee id is no found -" + theEmployee);
        }
        return theEmployee;
    }

    //add mapping for POST/employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        //also just in case they pass an id in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for PUT/employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for DELETE/employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null
        if(tempEmployee == null){
            throw new RuntimeException("Employee is not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }


}
