//package com.example.EmployeeManagementSystem.repository;
//
//import com.example.EmployeeManagementSystem.model.Employee;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//
//    // Derived query method to find employees by department name
//    List<Employee> findByDepartmentName(String departmentName);
//}
package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.projection.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.projection.EmployeeValueProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by email with pagination and sorting
    Page<Employee> findByEmailAddress(String emailAddress, Pageable pageable);

    // Retrieve employees by department ID with pagination and sorting
    @Query("SELECT e FROM Employee e WHERE e.department.id = :deptId")
    Page<Employee> findByDepartmentId(@Param("deptId") Long departmentId, Pageable pageable);

    // Fetch employees by department name using native SQL with pagination and sorting
    @Query(value = "SELECT * FROM employees e JOIN departments d ON e.department_id = d.id WHERE d.name = :deptName", nativeQuery = true)
    Page<Employee> findByDepartmentName(@Param("deptName") String departmentName, Pageable pageable);

    // Interface-based projection for employees by department name
    List<EmployeeProjection> findProjectionsByDepartmentName(String departmentName);

    // Class-based projection using constructor expression for employees by department name
    @Query("SELECT new com.example.employeemanagementsystem.projection.EmployeeDTO(e.id, e.name, e.email) " +
            "FROM Employee e WHERE e.department.name = :deptName")
    List<EmployeeDTO> findDTOsByDepartmentName(@Param("deptName") String departmentName);

    // Value-based projection for employees by department name
    List<EmployeeValueProjection> findValueProjectionsByDepartmentName(String departmentName);
}
