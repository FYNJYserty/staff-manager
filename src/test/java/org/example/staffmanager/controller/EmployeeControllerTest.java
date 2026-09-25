package org.example.staffmanager.controller;

import org.example.staffmanager.dto.EmployeePositionsDto;
import org.example.staffmanager.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void allEmployeesPositionsReturnsEmployeesFromRepository() {
        List<EmployeePositionsDto> employees = List.of(
                new EmployeePositionsDto(1, "Пётр", "Иванов", "Сергеевич",
                        LocalDate.of(1995, 4, 12), "p.ivanov@example.com", 1, "Инженер-разработчик")
        );
        when(employeeRepository.allEmployeesWithPositions()).thenReturn(employees);

        ResponseEntity<List<EmployeePositionsDto>> response = employeeController.allEmployeesPositions();

        assertEquals(200, response.getStatusCode().value());
        assertSame(employees, response.getBody());
        verify(employeeRepository).allEmployeesWithPositions();
    }
}
