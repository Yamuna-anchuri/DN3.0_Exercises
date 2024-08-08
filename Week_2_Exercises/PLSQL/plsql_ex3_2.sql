CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_bonus IN INT,
    p_dept IN VARCHAR2
) 
AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus / 100))
    WHERE Department = p_dept;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus(10, 'IT');
END;
/

DECLARE
    CURSOR employee_cursor IS
        SELECT EmployeeID, Name, Position, Salary, Department, HireDate
        FROM Employees
        WHERE Department = 'IT'; -- Replace 'IT' with the department you want to check

    employee_record employee_cursor%ROWTYPE;
BEGIN
    UpdateEmployeeBonus(10, 'IT');

    OPEN employee_cursor;
    
    LOOP
        FETCH employee_cursor INTO employee_record;
        EXIT WHEN employee_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('EmployeeID: ' || employee_record.EmployeeID || 
                             ', Name: ' || employee_record.Name || 
                             ', Position: ' || employee_record.Position || 
                             ', Salary: ' || employee_record.Salary || 
                             ', Department: ' || employee_record.Department || 
                             ', HireDate: ' || employee_record.HireDate);
    END LOOP;
    
    CLOSE employee_cursor;
END;
/
