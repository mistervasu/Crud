package com.self.crud.Service;

import com.self.crud.CrudRepository.EmployeeRepo;
import com.self.crud.DTO.EmployeeDto;
import com.self.crud.exception.ResourceNotFoundException;
import com.self.crud.mapper.employeeMapper;
import com.self.crud.model.Employee;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    //using ModelMapper
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired   //if there is only one constructor then no need to use @Autowired from spring 4.3 onwards
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public List <EmployeeDto> getAllEmployees() {
        List <Employee> employee = employeeRepo.findAll();
        List <EmployeeDto> listEmployee = employee.stream().map(employeeMapper::convertToDTO).toList();
        return listEmployee;
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        //Now Convert employeeDto to employee JPA entity
        //Employee employee = employeeMapper.convertToEntity(employeeDto);

        Employee employee = modelMapper.map(employeeDto, Employee.class);    //using Model Mapper
        Employee savedEmployee = employeeRepo.save(employee);

        //Convert employee JPA entity to employeeDto
        //EmployeeDto savedEmployeeDto = employeeMapper.convertToDTO(savedEmployee);
        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class); //using Model Mapper
        return savedEmployeeDto;
    }

    public EmployeeDto getEmployeeById(int id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );
        return employeeMapper.convertToDTO(employee);
    }

    public EmployeeDto updateEmployee(EmployeeDto employee, int id) {
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setSalary(employee.getSalary());

        Employee updatedEmployee = employeeRepo.save(existingEmployee);

        return employeeMapper.convertToDTO(updatedEmployee);
    }
    public EmployeeDto partialUpdateEmployee(EmployeeDto employee, int id) {
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id)
        );

        if (employee.getName() != null) {
            existingEmployee.setName(employee.getName());
        }
        if (employee.getEmail() != null) {
            existingEmployee.setEmail(employee.getEmail());
        }
        if (employee.getSalary() != null) {
            existingEmployee.setSalary(employee.getSalary());
        }

        Employee updatedEmployee = employeeRepo.save(existingEmployee);
        return employeeMapper.convertToDTO(updatedEmployee);
    }

    public void deleteEmployeeById(int id) {
        if (!employeeRepo.existsById(id)) {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
        employeeRepo.deleteById(id);
    }

}
