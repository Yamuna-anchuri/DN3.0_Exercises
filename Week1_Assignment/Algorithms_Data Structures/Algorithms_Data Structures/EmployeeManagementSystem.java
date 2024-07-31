public class EmployeeManagementSystem { 
    private Employee[] employees; 
    private int size; 
    private static final int INITIAL_CAPACITY = 10; 
 
    // Constructor 
    public EmployeeManagementSystem() { 
        this.employees = new Employee[INITIAL_CAPACITY]; 
        this.size = 0; 
    } 
 
    // Method to add an employee 
    public void addEmployee(Employee employee) { 
        if (size == employees.length) { 
            // Resize the array if needed 
            resize(); 
        } 
        employees[size++] = employee; 
    } 
 
    // Method to search for an employee by ID 
    public Employee searchEmployee(String employeeId) { 
        for (int i = 0; i < size; i++) { 
            if (employees[i].getEmployeeId().equals(employeeId)) { 
                return employees[i]; 
            } 
        } 
        return null; // Employee not found 
    } 
 
    // Method to traverse and display all employees 
    public void traverseEmployees() { 
        for (int i = 0; i < size; i++) { 
            Employee emp = employees[i]; 
            System.out.println("ID: " + emp.getEmployeeId() + ", Name: " + emp.getName() + 
                ", Position: " + emp.getPosition() + ", Salary: " + emp.getSalary()); 
        } 
    } 
 
    // Method to delete an employee by ID 
    public void deleteEmployee(String employeeId) { 
        int index = -1; 
        for (int i = 0; i < size; i++) { 
            if (employees[i].getEmployeeId().equals(employeeId)) { 
                index = i; 
                break; 
            } 
        } 
        if (index != -1) { 
            // Shift elements to remove the employee 
            for (int i = index; i < size - 1; i++) { 
                employees[i] = employees[i + 1]; 
            } 
            employees[size - 1] = null; // Clear the last element 
            size--; 
        } 
    } 
 
    // Resize the array to accommodate more elements 
    private void resize() { 
        int newCapacity = employees.length * 2; 
        Employee[] newArray = new Employee[newCapacity]; 
        System.arraycopy(employees, 0, newArray, 0, size); 
        employees = newArray; 
    } 
}