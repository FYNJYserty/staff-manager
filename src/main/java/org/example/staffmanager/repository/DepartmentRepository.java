package org.example.staffmanager.repository;

import org.example.staffmanager.dto.DepartmentCountStaffDto;
import org.example.staffmanager.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // Вывод информации о департаментах с количеством сотрудников в каждом
    @Query("SELECT new org.example.staffmanager.dto.DepartmentCountStaffDto(" +
            "d.id, d.name, COUNT(ed.employee)) " +
            "FROM Department d " +
            "LEFT JOIN EmployeeDepartment ed ON ed.department = d " +
            "GROUP BY d " +
            "ORDER BY d.id")
    List<DepartmentCountStaffDto> allDepartmentsWithCount();
}
