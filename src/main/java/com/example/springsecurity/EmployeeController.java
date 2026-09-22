package com.example.springsecurity;


import com.example.springsecurity.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        // Fix cứng 3 nhân viên theo yêu cầu
        employees.add(new Employee(1L, "Nguyễn Công Hưng", 8000.0));
        employees.add(new Employee(2L, "Phạm Tuấn Bình", 8500.0));
        employees.add(new Employee(3L, "Nguyễn Văn A", 3000.0));

        return employees;
    }
}
