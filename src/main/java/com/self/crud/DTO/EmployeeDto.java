package com.self.crud.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "EmployeeDTO Model Information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int id;

    @Schema(description = "Employee Name", example = "John Doe")
    @NotEmpty(message = "Employee name should not be empty or null")  //if message is not given, default message will be shown(must not be empty)
    private String name;

    @Schema(description = "Employee EmailAddress", example = "xyz@hotmail.com")
    @NotEmpty(message = "Employee email should not be empty or null")
    @Email
    private String email;

    @Schema(description = "Employee Salary")
    @NotNull(message = "Employee salary should not be null")
    private Long salary;

}
