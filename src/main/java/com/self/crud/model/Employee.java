package com.self.crud.model;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(nullable = false, unique = true)
    String email;
    Long salary;

//    public Employee() {
//    }
//    public Employee(String name, String email, Long salary) {
//        this.name = name;
//        this.email = email;
//        this.salary = salary;
//    }
//
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Long getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Long salary) {
//        this.salary = salary;
//    }
}
