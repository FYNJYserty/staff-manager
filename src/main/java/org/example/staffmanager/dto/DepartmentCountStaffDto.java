package org.example.staffmanager.dto;

public class DepartmentCountStaffDto {
    // Локальные переменные
    private Integer departmentId;
    private String departmentName;
    private Long employeeCount;
    // Конструкторы
    public DepartmentCountStaffDto() {
    }
    public DepartmentCountStaffDto(Integer departmentId, String departmentName, Long employeeCount) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }
    // Геттеры
    public Integer getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
    public Long getEmployeeCount() { return employeeCount; }
    // Сеттеры
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public void setEmployeeCount(Long employeeCount) { this.employeeCount = employeeCount; }
}
