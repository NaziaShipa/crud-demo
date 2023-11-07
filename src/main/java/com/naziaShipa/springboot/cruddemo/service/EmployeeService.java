package com.naziaShipa.springboot.cruddemo.service;

import com.naziaShipa.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
