package org.example.staffmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeDepartmentId implements Serializable {
    @Serial
    private static final long serialVersionUID = -2129809878675895633L;
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "department_id", nullable = false)
    private Integer departmentId;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDepartmentId entity = (EmployeeDepartmentId) o;
        return Objects.equals(this.employeeId, entity.employeeId) &&
                Objects.equals(this.departmentId, entity.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, departmentId);
    }
}