package com.self.crud.Controller;

import com.self.crud.DTO.EmployeeDto;
import com.self.crud.Service.EmployeeService;
import com.self.crud.exception.ErrorDetails;
import com.self.crud.exception.ResourceNotFoundException;
import com.self.crud.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "Employee Management System",
        description = "APIs for managing employees (Create, update, get, delete)"
)
@RestController
@RequestMapping("/employees")
public class crudController {
    private EmployeeService employeeService;
    @Autowired
    public crudController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "Get all Employees",
            description = "Retrieve a list of all employees from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved list of employees"
    )

    @GetMapping("/listAll")
    public ResponseEntity<List <EmployeeDto>> getAllEmployees(){
        List <EmployeeDto> listEmployee = employeeService.getAllEmployees();
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }

    @Operation(
            summary = "Create Employee Rest API",
            description = "Save a employees to the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Employee created successfully"
    )
    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employee){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get employee by ID",
            description = "Retrieve a specific employee using their unique ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved the employee"
    )
    @GetMapping("/list/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Integer empId){
        EmployeeDto employee = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
        // return ResponseEntity.ok(employeeService.getEmployeeById(id));
        // return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
        //return ResponseEntity.OK().header("Custom-Header", "CustomValue").body(employeeService.getEmployeeById(id));
    }

    @Operation(
            summary = "Update employee by ID",
            description = "Update a specific employee using their unique ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully updated the employee"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @PathVariable Integer id, @RequestBody EmployeeDto employee){
        return ResponseEntity.ok(employeeService.updateEmployee(employee,id));
    }

    @Operation(
            summary = "Partial update employee by ID",
            description = "Partially update a specific employee using their unique ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully updated the employee"
    )
    @PatchMapping("/partialUpdate/{id}")
    public ResponseEntity<EmployeeDto> partialUpdateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employee){
        return ResponseEntity.ok(employeeService.partialUpdateEmployee(employee,id));
    }

    @Operation(
            summary = "Delete employee by ID",
            description = "Delete a specific employee using their unique ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully deleted the employee from the database"
    )
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
