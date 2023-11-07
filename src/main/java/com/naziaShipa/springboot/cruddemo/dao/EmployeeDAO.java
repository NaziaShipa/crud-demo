package com.naziaShipa.springboot.cruddemo.dao;

import com.naziaShipa.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
