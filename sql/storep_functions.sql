USE `ngo_management_system`;
DROP procedure IF EXISTS `employee`;

DELIMITER $$
USE `ngo_management_system` $$
CREATE PROCEDURE `employee` ()
BEGIN
	SELECT COUNT(*) from employee;
END $$

DELIMITER ;

DROP procedure IF EXISTS `donor`;

DELIMITER $$
USE `ngo_management_system` $$
CREATE PROCEDURE `donor` ()
BEGIN
	SELECT COUNT(*) from donor;
END $$

DELIMITER ;

DROP procedure IF EXISTS `donation`;

DELIMITER $$
USE `ngo_management_system` $$
CREATE PROCEDURE `donation` ()
BEGIN
	SELECT COUNT(*) from donation;
END $$

DELIMITER ;

DELIMITER $$
CREATE FUNCTION last_donation_made(id INT)
RETURNS DATE
BEGIN
	DECLARE donation_date DATE DEFAULT "NOT FOUND";
    SELECT last_donation INTO donation_date FROM donor WHERE donor_id = id;
RETURN last_donation
END
)
END
DELIMITER ;

DELIMITER $$
CREATE FUNCTION searchEmployee(id int) 
  RETURNS CHAR(100)
  BEGIN
    DECLARE employee_name CHAR(100) DEFAULT 'NOT FOUND';
    SELECT last_name INTO employee_name FROM employee ON employee.employee_id = id;
    RETURN employee_name;
  END
DELIMITER ;

DELIMITER $$
CREATE FUNCTION stock_sufficient(id INT)
	RETURNS VARCHAR(30)
	AS
	BEGIN
    DECLARE stock INT DEFAULT 0;
    SELECT amount INTO stock FROM resource_store ON resource_store.resource_id = id;
	RETURN( 'Stock is' + 
	CASE
		-- Case 1
		WHEN amount > 50 THEN 'sufficient'
		-- Case 2
		WHEN amount <= 50 THEN 'not sufficient'
	END
	)
	END;
DELIMITER ;
