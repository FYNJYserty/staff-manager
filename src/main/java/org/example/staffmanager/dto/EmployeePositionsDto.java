package org.example.staffmanager.dto;

import java.time.LocalDate;

public class EmployeePositionsDto {
    // Локальные переменные (поля)
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String email;
    private Integer positionId;
    private String position;

    // Конструкторы
    public EmployeePositionsDto() {}
    public EmployeePositionsDto(Integer employeeId,
                                String firstName,
                                String lastName,
                                String middleName,
                                LocalDate birthDate,
                                String email,
                                Integer positionId,
                                String position) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.email = email;
        this.positionId = positionId;
        this.position = position;
    }

    // Геттеры
    public Integer getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMiddleName() { return middleName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getEmail() { return email; }
    public Integer getPositionId() { return positionId; }
    public String getPosition() { return position; }

    // Сеттеры
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setEmail(String email) { this.email = email; }
    public void setPositionId(Integer positionId) { this.positionId = positionId; }
    public void setPosition(String position) { this.position = position; }
}
