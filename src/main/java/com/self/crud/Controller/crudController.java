package com.self.crud.Controller;

import com.self.crud.DTO.EmployeeDto;
import com.self.crud.Service.EmployeeService;
import com.self.crud.exception.ErrorDetails;
import com.self.crud.exception.ResourceNotFoundException;
import com.self.crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class crudController {
    private EmployeeService employeeService;
    @Autowired
    public crudController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/listAll")
    public ResponseEntity<List <EmployeeDto>> getAllEmployees(){
        List <EmployeeDto> listEmployee = employeeService.getAllEmployees();
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }

    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Integer empId){
        EmployeeDto employee = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
        // return ResponseEntity.ok(employeeService.getEmployeeById(id));
        // return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
        //return ResponseEntity.OK().header("Custom-Header", "CustomValue").body(employeeService.getEmployeeById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employee){
        return ResponseEntity.ok(employeeService.updateEmployee(employee,id));
    }

    @PatchMapping("/partialUpdate/{id}")
    public ResponseEntity<EmployeeDto> partialUpdateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employee){
        return ResponseEntity.ok(employeeService.partialUpdateEmployee(employee,id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    //using Controller to handle Exception
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "EMPLOYEE_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }

}
