CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW 
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

DECLARE
    CURSOR customer_details_cursor IS
        SELECT CustomerID, Name, DOB, Balance, LastModified
        FROM Customers;

    customer_record customer_details_cursor%ROWTYPE;
BEGIN
    OPEN customer_details_cursor;
    
    LOOP
        FETCH customer_details_cursor INTO customer_record;
        EXIT WHEN customer_details_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('CustomerID: ' || customer_record.CustomerID || 
                             ', Name: ' || customer_record.Name || 
                             ', DOB: ' || customer_record.DOB || 
                             ', Balance: ' || customer_record.Balance || 
                             ', LastModified: ' || customer_record.LastModified);
    END LOOP;
    
    CLOSE customer_details_cursor;
END;
/
