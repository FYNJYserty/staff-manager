package org.example.staffmanager.repository;

import org.example.staffmanager.dto.EmployeePositionsDto;
import org.example.staffmanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Вывод информации о сотрудниках и их позициях в компании
    @Query("SELECT new org.example.staffmanager.dto.EmployeePositionsDto(" +
            "e.id, e.firstName, e.lastName, e.middleName, e.birthDate, e.email, " +
            "e.position.id, e.position.name) " +
            "FROM Employee e " +
            "ORDER BY e.id")
    List<EmployeePositionsDto> allEmployeesWithPositions();
}
