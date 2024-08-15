package com.example.employeemanagementsystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeValueProjection {
    @Value("#{target.employeeId}")
    Long getEmployeeId();

    @Value("#{target.fullName}")
    String getFullName();

    @Value("#{target.emailAddress}")
    String getEmailAddress();
}
