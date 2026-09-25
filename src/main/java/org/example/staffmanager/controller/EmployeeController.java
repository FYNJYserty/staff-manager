package org.example.staffmanager.controller;

import org.example.staffmanager.dto.EmployeePositionsDto;
import org.example.staffmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository; // Репозиторий работников
    /**
     * Контроллер с выводом списка сотрудников с их должностями
     * @return
     */
    @GetMapping(value ="/employees", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<EmployeePositionsDto>> allEmployeesPositions() {
        List<EmployeePositionsDto> employees = employeeRepository.allEmployeesWithPositions();
        return ResponseEntity.ok(employees);
    }
}
