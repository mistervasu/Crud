package com.self.crud.Service;

import com.self.crud.DTO.EmployeeDto;
import com.self.crud.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface EmployeeService {
    public List <EmployeeDto> getAllEmployees();
    public EmployeeDto saveEmployee(EmployeeDto employee);
    public EmployeeDto getEmployeeById(int id);
    public EmployeeDto updateEmployee(EmployeeDto employee, int id);
    public EmployeeDto partialUpdateEmployee(EmployeeDto employee, int id);
    public void deleteEmployeeById(int id);
}
