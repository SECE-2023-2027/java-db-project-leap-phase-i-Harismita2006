create database banking;
use  banking;
create table customer(
userid int primary key,
username varchar(20),
email varchar(30),
mobile_no varchar(10),
address varchar(100),
acc_no varchar(20));

alter table customer modify column mobile_no bigint;
alter table customer drop column email;
ALTER TABLE customer
ADD CONSTRAINT unique_mobile_no UNIQUE (mobile_no),     
ADD CONSTRAINT check_mobile_no_length CHECK (LENGTH(mobile_no) = 10), 
ADD CONSTRAINT check_acc_no_length CHECK (LENGTH(acc_no) BETWEEN 10 AND 20); 
ALTER TABLE customer
ADD email VARCHAR(50) NOT NULL;
ALTER TABLE customer
ADD CONSTRAINT check_email_format 
CHECK (email LIKE '%_@_%._%');

INSERT INTO customer (userid, username, mobile_no, address, acc_no) VALUES
(11, 'Suresh', '9387432101', 'Coimbatore, Tamil Nadu', 'ACC1122334455'),
(12, 'Aishwarya', '9345678901', 'Trivandrum, Kerala', 'ACC2233445566'),
(13, 'Manoj', '9442233445', 'Madurai, Tamil Nadu', 'ACC3344556677'),
(14, 'Shruti', '9366547890', 'Bangalore, Karnataka', 'ACC4455667788'),
(15, 'Karthik', '9488776655', 'Chennai, Tamil Nadu', 'ACC5566778899'),
(16, 'Anjali', '9399888777', 'Hyderabad, Telangana', 'ACC6677889900'),
(17, 'Vijay', '9500112233', 'Mysore, Karnataka', 'ACC7788990011'),
(18, 'Ramesh', '9644556677', 'Kochi, Kerala', 'ACC8899001122'),
(19, 'Preeti', '9712345678', 'Tirupathi, Andhra Pradesh', 'ACC9900112233'),
(20, 'Nithya', '9811223344', 'Tiruppur, Tamil Nadu', 'ACC1011122334');

select * from customer where userid=11;

UPDATE customer SET email = 'suresh.rao@example.com' WHERE userid = 11;
UPDATE customer SET email = 'aishwarya.iyer@example.com' WHERE userid = 12;
UPDATE customer SET email = 'manoj.kumar@example.com' WHERE userid = 13;
UPDATE customer SET email = 'shruti.bhat@example.com' WHERE userid = 14;
UPDATE customer SET email = 'karthik.murthy@example.com' WHERE userid = 15;
UPDATE customer SET email = 'anjali.patel@example.com' WHERE userid = 16;
UPDATE customer SET email = 'vijay.das@example.com' WHERE userid = 17;
UPDATE customer SET email = 'ramesh.nair@example.com' WHERE userid = 18;
UPDATE customer SET email = 'preeti.jain@example.com' WHERE userid = 19;
UPDATE customer SET email = 'nithya.krishnan@example.com' WHERE userid = 20;

select email from customer where email is not null;

CREATE TABLE student (
    student_id INT PRIMARY KEY,                  
    name VARCHAR(20) NOT NULL,                  
    address VARCHAR(30) NOT NULL,                
    department VARCHAR(20) NOT NULL          
);

INSERT INTO student (student_id, name, address, department) VALUES
(21, 'Aryan Kapoor', 'Bengaluru, KA', 'CSE'),
(22, 'Sia Sharma', 'Chennai, TN', 'EEE'),
(23, 'Zara Iyer', 'Kochi, KL', 'ECE'),
(24, 'Vivaan Reddy', 'Hyderabad, TS', 'IT'),
(25, 'Aadhya Nair', 'Chennai, TN', 'CSE'),
(26, 'Reyansh Verma', 'Madurai, TN', 'AIDS'),
(27, 'Ishaan Rao', 'Bengaluru, KA', 'ECE'),
(28, 'Kiara Patel', 'Hyderabad, TS', 'CSE'),
(29, 'Shaan Bhat', 'Jaggayyapeta, AP', 'EEE'),
(30, 'Nivaan Menon', 'Chennai, TN', 'IT');

create table employee(
employee_id int primary key,
name varchar(20),
address varchar(30) not null,
salary int not null);

INSERT INTO employee (employee_id, name, address, salary) VALUES
(101, 'Aarav Kumar', 'Chennai', 50000),
(102, 'Lakshmi Priya', 'Coimbatore', 45000),
(103, 'Rohit Ramesh', 'Madurai', 55000),
(104, 'Deepika Iyer', 'Chennai', 48000),
(105, 'Vikram Raj', 'Salem', 52000),
(106, 'Pooja Suresh', 'Coimbatore', 47000),
(107, 'Surya Narayanan', 'Madurai', 60000),
(108, 'Anjali Krishna', 'Salem', 49000),
(109, 'Dinesh Karthick', 'Chennai', 53000),
(110, 'Revathi Chandran', 'Tiruchirappalli', 51000);

select min(salary) from employee;
select * from employee where salary = (select min(salary) from employee);
select * from employee where salary = (select max(salary) from employee);
select * from employee where salary = (select avg(salary) from employee);
SELECT SUM(salary) AS total_salary
FROM employee;
select count(employee_id) as count_salary from employee;
ALTER TABLE student
ADD dept_id INT;

UPDATE student
SET dept_id = CASE
    WHEN department = 'CSE' THEN 101
    WHEN department = 'IT' THEN 102
    WHEN department = 'ECE' THEN 103
    WHEN department = 'EEE' THEN 104
    WHEN department = 'AIDS' THEN 105
END;

select * from student;
ALTER TABLE student
ADD CONSTRAINT fk_student_dept
FOREIGN KEY (dept_id) REFERENCES department(dept_id);

 create table department(
 dept_id int primary key,
 dept_name varchar(20),
 core varchar(20));
 
 INSERT INTO department (dept_id, dept_name, core) VALUES
(101, 'CSE', 'Computer Networks'),
(102, 'IT', 'Data Structures'),
(103, 'ECE', 'Digital Electronics'),
(104, 'EEE', 'Power Systems'),
(105, 'AIDS', 'Data Science');

INSERT INTO student (student_id, name, address, department, dept_id) VALUES
(1, 'Thara Natarajan', 'Chennai', 'CSE', 101),
(2, 'Lakshana Raman', 'Madurai', 'IT', 102),
(3, 'Kavya Subramaniam', 'Coimbatore', 'ECE', 103),
(4, 'Diya Rajan', 'Salem', 'EEE', 104),
(5, 'Mridula Krishnan', 'Tirunelveli', 'AIDS', 105),
(6, 'Dhanya Mohan', 'Trichy', 'CSE', 101),
(7, 'Mithran Iyer', 'Thanjavur', 'IT', 102),
(8, 'Arjun Kumar', 'Vellore', 'ECE', 103),
(9, 'Sanjay Varma', 'Erode', 'EEE', 104),
(10, 'Karthick Reddy', 'Dindigul', 'AIDS', 105);

SELECT s.student_id, s.name, s.address, s.department, d.dept_name, d.core
FROM student s
INNER JOIN department d ON s.dept_id = d.dept_id;
 
SELECT s.student_id, s.name, s.address, s.department, d.dept_name, d.core
FROM student s
LEFT JOIN department d ON s.dept_id = d.dept_id;
 
SELECT s.student_id, s.name, s.address, s.department, d.dept_name, d.core
FROM student s
RIGHT JOIN department d ON s.dept_id = d.dept_id;
 
CREATE TABLE bank (
    bank_id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    branch VARCHAR(50) NOT NULL
);
