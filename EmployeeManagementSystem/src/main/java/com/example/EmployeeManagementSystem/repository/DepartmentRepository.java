//package com.example.EmployeeManagementSystem.repository;
//
//import com.example.EmployeeManagementSystem.model.Department;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface DepartmentRepository extends JpaRepository<Department, Long> {
//
//    // Derived query method to find a department by name
//    Department findByName(String name);
//}
package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.projection.DepartmentDTO;
import com.example.employeemanagementsystem.projection.DepartmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Find departments by name using a derived query method
    List<Department> findByDepartmentName(String name);

    // Custom JPQL query to retrieve departments based on name
    @Query("SELECT d FROM Department d WHERE d.name = :name")
    List<Department> searchDepartmentsByName(@Param("name") String name);

    // Interface-based projection method
    List<DepartmentProjection> findDepartmentsByNameProjection(String name);

    // Class-based projection using constructor expression
    @Query("SELECT new com.example.employeemanagementsystem.projection.DepartmentDTO(d.id, d.name) " +
            "FROM Department d")
    List<DepartmentDTO> fetchAllDepartmentDTOs();
}
