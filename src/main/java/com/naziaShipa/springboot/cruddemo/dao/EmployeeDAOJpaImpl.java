package com.naziaShipa.springboot.cruddemo.dao;

import com.naziaShipa.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee ", Employee.class);
        // execute query and get result list
         List<Employee> employees = theQuery.getResultList();
        // return the results
        return employees;

    }

    @Override
    public Employee findById(int theId) {

        //find the employee the id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        //save or update depending on the employee id
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //delete employee by id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        entityManager.remove(theEmployee);
    }
}









