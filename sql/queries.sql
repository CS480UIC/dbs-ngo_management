# simple
SELECT employee_id, first_name
FROM ngo_management_system.employee
WHERE salary >= 50000 AND salary <= 100000;

SELECT transaction_id , donor_id 
FROM ngo_management_system.donation
WHERE amount >= 1000 AND amount <= 10000;

SELECT volunteer_id, first_name
FROM ngo_management_system.volunteer
WHERE birth_date <= '1980-01-01';

# aggregate
SELECT SUM(salary) AS TOTAL_EXPENSE
FROM ngo_management_system.employee
WHERE address LIKE '%Chicago%';

SELECT COUNT(transaction_id) AS TOTAL_DONATION
FROM ngo_management_system.donation
WHERE time < '2022-02-03 05:00:00';

SELECT first_name, SUM(num_of_donations) as num_donations
FROM ngo_management_system.donor
GROUP BY first_name
HAVING SUM(num_of_donations) > 50;

# views
CREATE OR REPLACE VIEW ngo_management_system.emp_org AS
SELECT E.employee_id, E.first_name, O.organization_name
FROM ngo_management_system.employee E
INNER JOIN ngo_management_system.organization O ON O.organization_id = E.organization_id
GROUP BY E.organization_id
ORDER BY E.first_name ASC;

SELECT * FROM ngo_management_system.emp_org;

CREATE OR REPLACE VIEW ngo_management_system.donate_time AS
SELECT d.first_name, d.last_name 
FROM ngo_management_system.donor as d
WHERE EXISTS (SELECT n.donor_id
			  FROM donation as n
			  WHERE d.donor_id=n.donor_id
	          AND time < '2022-02-03 05:00:00');
              
SELECT * FROM ngo_management_system.donate_time;
              
CREATE OR REPLACE VIEW cause_volunteer AS
SELECT v.volunteer_id, v.first_name, num_causes, c.cause_name
FROM ngo_management_system.volunteer v INNER JOIN
(SELECT volunteer_id, count(support_cause_id) AS num_causes
FROM ngo_management_system.volunteer_support_cause GROUP BY volunteer_id) AS num_cause_table
ON v.volunteer_id = num_cause_table.volunteer_id
INNER JOIN ngo_management_system.volunteer_support_cause vs ON v.volunteer_id = vs.volunteer_id
INNER JOIN ngo_management_system.cause c ON c.cause_id = vs.support_cause_id
ORDER BY v.first_name ASC;

SELECT * FROM ngo_management_system.cause_volunteer;