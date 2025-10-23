package com.self.crud.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int id;

    @NotEmpty(message = "Employee name should not be empty or null")  //if message is not given, default message will be shown(must not be empty)
    private String name;

    @NotEmpty(message = "Employee email should not be empty or null")
    @Email
    private String email;

    @NotNull(message = "Employee salary should not be null")
    private Long salary;

}
