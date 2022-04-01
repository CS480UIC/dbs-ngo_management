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

SELECT SUM(num_of_donations) as num_donations
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
              
CREATE OR REPLACE VIEW ngo_management_system.cause_volunteer AS
SELECT v.volunteer_id, v.first_name
FROM ngo_management_system.volunteer v
INNER JOIN ngo_management_system.volunteer_support_cause vs on vs.volunteer_id=v.volunteer_id
group by vs.support_cause_id
order by v.first_name ASC;

SELECT * FROM ngo_management_system.cause_volunteer;