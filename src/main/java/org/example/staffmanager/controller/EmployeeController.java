package org.example.staffmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    /**
     * Контроллер с выводом списка сотрудников с их должностями
     * @return
     */
    @GetMapping("/employees")
    public String allEmployeesPositions() {
        return "employees";
    }
}
