package org.example.staffmanager.controller;

import org.example.staffmanager.dto.DepartmentCountStaffDto;
import org.example.staffmanager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository; // Репозиторий департаментов
    /**
     * Вывод списка всех департаментов с количеством сотрудников
     * @return
     */
    @GetMapping(value ="/departments", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<DepartmentCountStaffDto>> allDepartmentsWithEmployeeCount() {
        List<DepartmentCountStaffDto> departmentCountStaff = departmentRepository.allDepartmentsWithCount();
        return ResponseEntity.ok(departmentCountStaff);
    }
}
