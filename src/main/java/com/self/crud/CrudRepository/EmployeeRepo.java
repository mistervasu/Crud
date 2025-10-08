package com.self.crud.CrudRepository;
import com.self.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}




