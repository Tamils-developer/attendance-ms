
create schema adv_emp_details;
-- drop schema adv_emp_details;
use adv_emp_details;

CREATE TABLE shift_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(32),
    timing VARCHAR(32)
)  AUTO_INCREMENT=100;

CREATE TABLE attendance_details (
    id VARCHAR(64) PRIMARY KEY  ,
    att_date DATE,
    attendance VARCHAR(10),
    shift_id int,
    status VARCHAR(32),
    approver_id VARCHAR(64),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    updated_by VARCHAR(64),
    is_deleted BOOLEAN  DEFAULT 0,
--     FOREIGN KEY (emp_id)
--         REFERENCES emp_auth_details (emp_id),
         FOREIGN KEY (shift_id)
        REFERENCES shift_details (id)
);


CREATE TABLE leave_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    leave_count INT,
    comp_off_count INT,
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN DEFAULT 0
);


 
CREATE TABLE holiday_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(100),
    date DATE,
    client_id VARCHAR(64),
    location VARCHAR(64),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN
);


CREATE TABLE rooster_table (
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE,
    end_date DATE,
    week_of_1 DATE,
    week_of_2 DATE,
    shift_id INT,
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN DEFAULT 0,
    FOREIGN KEY (shift_id)
        REFERENCES shift_details (id)
);


CREATE TABLE encashment_details (
    id INT PRIMARY KEY,
    encash_type varchar(32),
    status VARCHAR(64),
    approver_id VARCHAR(64),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN DEFAULT 0
);

CREATE TABLE comp_off_details (
    id int PRIMARY KEY   auto_increment ,
    date DATE unique key not null,
    status VARCHAR(64),
    attend_id VARCHAR(64),
      emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN DEFAULT 0,
    FOREIGN KEY (attend_id)
        REFERENCES attendance_details (id)
);


-- mock datas for testing and integration
insert into shift_details (type,timing) values ( 'Morning Shift','6:00am - 3:30pm'  ),
( 'Afternoon Shift','12:30pm - 9:30pm'  ),
( 'Evening Shift','5:30pm - 2:30am'  ),
( 'Night Shift','9:30pm - 6:30am'  ),
( 'Regular Shift','11:00am - 7:00pm'  );
-- insert into attendance_details (id,att_date,attendance,shift_id,status,approver_id,emp_id) values (1000,'2024-10-10','P',101,'Approved','100','200');
-- insert into attendance_details (id,att_date,attendance,shift_id,status,approver_id,emp_id) values (1002,'2024-10-11','P',101,'Approved','100','200');
-- insert into comp_off_details (id,date, status, attend_id,emp_id) values (10,'2024-10-10','Approved',1000,200);


INSERT INTO `adv_emp_details`.`holiday_details` (`id`, `type`, `date`, `client_id`, `location`, `emp_id`) VALUES 
('300', 'pongal', '2024-01-14', '1', 'UTG', '200'),
('301', 'test', '2024-01-14', '1', 'utg', '200'),
('302', 'test2', '2024-11-13', '1', 'utg', '200'),
('303', 'test2', '2024-11-14', '1', 'bgl', '200'),
('304', 'test2', '2024-11-15', '1', 'bgl', '200'),
('305', 'test2', '2024-11-10', '1', 'bgl', '201'),
('306', 'test2', '2024-11-11', '1', 'bgl', '201'),
('307', 'test2', '2024-11-10', '1', 'bgl', '200'),
('308', 'test2', '2024-11-13', '1', 'utg', '201'),
('309', 'test2', '2024-11-14', '1', 'bgl', '201'),
('310', 'test2', '2024-11-15', '1', 'bgl', '201');

INSERT INTO rooster_table (`id`, `start_date`, `end_date`, `week_of_1`, `week_of_2`, `shift_id`, `emp_id`,`updated_by`,`created_by`) VALUES
 ('10', '2024-10-28', '2024-11-03', '2024-10-28', '2024-11-03', '104', '200','200','200'),
 ('11', '2024-11-04', '2024-11-10', '2024-11-04', '2024-11-10', '104', '200','200','200'),
 ('12', '2024-11-11', '2024-11-17', '2024-11-11', '2024-11-17', '104', '200','200','200'),
 ('13', '2024-11-18', '2024-11-24', '2024-11-18', '2024-11-24', '104', '200','200','200'),
 ('14', '2024-11-25', '2024-12-01', '2024-11-25', '2024-12-01', '104', '200','200','200');
INSERT INTO `adv_emp_details`.`leave_details` (`leave_count`, `comp_off_count`, `emp_id`, `created_by`, `updated_by`, `is_deleted`) VALUES 
( '4', '0', '200', '300', '300', '0'),
( '4', '0', '201', '300', '300', '0');

INSERT INTO `adv_emp_details`.`attendance_details` (`id`, `att_date`, `attendance`, `shift_id`, `status`, `approver_id`, `emp_id`, `created_by`, `updated_by`) VALUES
 ('1000', '2024-11-10', 'p', '101', 'pending', '100', '200', '200', '200'),
 ('1001', '2024-11-10', 'p', '101', 'pending', '100', '201', '201', '201'),
 ('1002', '2024-11-11', 'p', '101', 'pending', '100', '200', '200', '200'),
 ('1003', '2024-11-11', 'p', '101', 'pending', '100', '201', '201', '201'),
 ('1004', '2024-11-12', 'p', '101', 'pending', '100', '200', '200', '200'),
 ('1005', '2024-11-12', 'p', '101', 'pending', '100', '201', '201', '201'),
 ('1006', '2024-11-13', 'p', '101', 'pending', '100', '200', '200', '200'),	
 ('1007', '2024-11-13', 'p', '101', 'pending', '100', '201', '201', '201'),
 ('1008', '2024-11-14', 'p', '101', 'pending', '100', '200', '200', '200'),
 ('1009', '2024-11-14', 'p', '101', 'pending', '100', '201', '201', '201'),
 ('1010', '2024-11-15', 'p', '101', 'pending', '100', '200', '200', '200'),
 ('1011', '2024-11-15', 'p', '101', 'pending', '100', '201', '201', '201'),
 ('1012', '2024-11-18', 'p', '101', 'pending', '100', '200', '200', '200'),
 ('1013', '2024-11-18', 'p', '101', 'pending', '100', '201', '201', '201'),
 ('1014', '2024-11-19', 'p', '101', 'pending', '100', '200', '200', '200'),
 ('1015', '2024-11-19', 'p', '101', 'pending', '100', '201', '201', '201');
 
 
 -- // store procedure for updating compoff details to the comp off table after checking in rooster and holiday table

SET SQL_SAFE_UPDATES = 0;


DELIMITER $$
CREATE PROCEDURE update_attendance_and_compoff_details_proc(
    IN attendId VARCHAR(255),
    IN approverId VARCHAR(255),
    IN empId VARCHAR(255),
    IN updatedStatus VARCHAR(64),
    OUT updateSuccess BOOLEAN
)
BEGIN
    DECLARE currentStatus VARCHAR(50);
    DECLARE currentAttendance VARCHAR(50);
    DECLARE createdDate TIMESTAMP;
    DECLARE leaveCount INT DEFAULT 0;
    DECLARE attendanceDate DATE;

    START TRANSACTION;
	SELECT status, attendance, created_date, att_date INTO currentStatus , currentAttendance , createdDate , attendanceDate FROM attendance_details WHERE id = attendId AND is_deleted = 0;
		IF currentStatus IS NULL THEN
			SET updateSuccess = FALSE;
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Attendance record not found or is deleted';
		END IF;
	UPDATE attendance_details SET   status = updatedStatus,    updated_by = approverId,    updated_date = CURRENT_TIMESTAMP, created_by = empId,    created_date = createdDate WHERE    id = attendId;

    IF UCASE(updatedStatus) = 'APPROVED'  THEN
        IF UCASE(currentAttendance) = 'P' THEN
 IF EXISTS (
					SELECT 1 
					FROM rooster_table rt
					WHERE rt.emp_id = empId AND (rt.week_of_1 = attendanceDate OR rt.week_of_2 = attendanceDate)
				) OR EXISTS (
					SELECT 1 
					FROM holiday_details hd 
					WHERE hd.emp_id = empId AND hd.date = attendanceDate
				) THEN
					INSERT INTO comp_off_details (date, status, attend_id, emp_id, created_by, updated_by, is_deleted)
					VALUES (attendanceDate, 'OPEN', attendId, empId, empId, empId, 0);
					UPDATE leave_details SET  comp_off_count = comp_off_count + 1, updated_by = approverId, updated_date = CURRENT_TIMESTAMP() WHERE emp_id = empId;
					 
				ELSE
					SIGNAL SQLSTATE '45000'
					SET MESSAGE_TEXT = 'CompOff details not available for this date';
                    rollback;
				END IF;
        ELSEIF ucase(currentAttendance) = 'CO' THEN
         IF EXISTS (
					SELECT 1 FROM comp_off_details cd WHERE cd.emp_id = empId AND cd.status = "OPEN"  
				) then
				UPDATE comp_off_details SET   status = 'TAKEN' WHERE  emp_id = empId AND status = "OPEN" AND DATEDIFF(CURRENT_TIMESTAMP(), created_date) < 90 LIMIT 1;
				UPDATE leave_details 	SET comp_off_count = comp_off_count - 1,updated_by = approverId,updated_date = CURRENT_TIMESTAMP WHERE	emp_id = empId;
                END IF;
        ELSE
            SELECT leave_count INTO leaveCount FROM leave_details WHERE emp_id = empId;
            IF leaveCount IS NULL THEN
            rollback;
                SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Leave details not found for the employee';
            END IF;
			UPDATE leave_details SET  leave_count = leaveCount - 1, updated_by = approverId, updated_date = CURRENT_TIMESTAMP WHERE emp_id = empId;
        END IF;
    END IF;
    COMMIT;
    SET updateSuccess = TRUE;
END$$
DELIMITER ;



select * from comp_off_details;
select * from attendance_details;










-- emp and auth tables

CREATE TABLE auth_details (
    id VARCHAR(64) PRIMARY KEY NOT NULL,
    emp_id VARCHAR(64) NOT NULL UNIQUE KEY,
    emp_pw VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN DEFAULT 0
);


CREATE TABLE emp_details (
    id INT PRIMARY KEY NOT NULL,
    name VARCHAR(64),
    mdn VARCHAR(64),
    email VARCHAR(64),
    date_of_joining DATE,
    role VARCHAR(64),
   designation VARCHAR(64),
    base_location VARCHAR(64),
    client_location VARCHAR(64),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN,
    FOREIGN KEY (emp_id)
        REFERENCES auth_details (emp_id)
)  AUTO_INCREMENT=1
;

CREATE TABLE address_details (
    id INT PRIMARY KEY AUTO_INCREMENT,
    door_no VARCHAR(10),
    street VARCHAR(32),
    landmark VARCHAR(32),
    city VARCHAR(32),
    district VARCHAR(32),
    pincode INT,
    state VARCHAR(32),
    country VARCHAR(32),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN,
    FOREIGN KEY (emp_id)
        REFERENCES auth_details (emp_id)
)  AUTO_INCREMENT=100;


-- schema for tax declaration
create schema emp_tax_declaration;
use emp_tax_declaration;


CREATE TABLE tax_regime (
    id VARCHAR(64) PRIMARY KEY,
    tax_regime_type VARCHAR(32),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN
);

CREATE TABLE house_rent_allowance (
    id VARCHAR(64) PRIMARY KEY,
    name_of_landlord VARCHAR(64),
    rent_amount INT,
    pan_of_landlord VARCHAR(32),
    address_of_landlord VARCHAR(200),
    month_year varchar(32),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN
);

CREATE TABLE home_loan (
    id VARCHAR(64) PRIMARY KEY,
    bank_name VARCHAR(64),
    loan_acc_no VARCHAR(20),
    branch VARCHAR(32),
    ifsc_code VARCHAR(200),
    intrest_paid int,
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN
);

CREATE TABLE  tax_dec(
    id VARCHAR(64) PRIMARY KEY,
    category_type VARCHAR(64),
    total_amount INT,
    section_type char(10),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN
);


select id , att_date, attendance, shift_id, status, approver_id ,created_date,created_by, updated_date,updated_by ,is_deleted from attendance_details where emp_id='200' AND att_date like "2024-10%";

-- select id , att_date, attendance, shift_id, status, approver_id ,created_date,created_by, updated_date,updated_by ,is_deleted from attendance_details where emp_id='200' AND EXTRACT(YEAR_MONTH FROM att_date ); 