package org.example.staffmanager.controller;

import org.example.staffmanager.dto.DepartmentCountStaffDto;
import org.example.staffmanager.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentController departmentController;

    @Test
    void allDepartmentsWithEmployeeCountReturnsDepartmentsFromRepository() {
        List<DepartmentCountStaffDto> departments = List.of(
                new DepartmentCountStaffDto(1, "Разработка", 12L)
        );
        when(departmentRepository.allDepartmentsWithCount()).thenReturn(departments);

        ResponseEntity<List<DepartmentCountStaffDto>> response =
                departmentController.allDepartmentsWithEmployeeCount();

        assertEquals(200, response.getStatusCode().value());
        assertSame(departments, response.getBody());
        verify(departmentRepository).allDepartmentsWithCount();
    }
}
