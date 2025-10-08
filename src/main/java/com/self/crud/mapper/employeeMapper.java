package com.self.crud.mapper;

import com.self.crud.DTO.EmployeeDto;
import com.self.crud.model.Employee;

public class employeeMapper {

    //Convert Employee JPA entitiy to Employee DTO
    public static EmployeeDto convertToDTO(Employee employee) {

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getSalary()
        );
        return employeeDto;
    }

    //Convert Employee DTO to Employee JPA entity
    public static Employee convertToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getSalary()
        );
        return employee;
    }
}
