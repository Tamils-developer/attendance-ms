
create table shift_details(id int primary key auto_increment, type varchar(32), timing varchar(32)) auto_increment=100;

insert into shift_details (type,timing) values ( 'Morning Shift','6:30am - 3:30pm'  ),
( 'Afternoon Shift','12:30pm - 9:30pm'  ),
( 'Evening Shift','5:30pm - 2:30am'  ),
( 'Night Shift','9:30pm - 6:30am'  ),
( 'Regular Shift','11:00am - 7:00pm'  );
CREATE TABLE attendance_details (
    id VARCHAR(64) PRIMARY KEY  ,
    date_ DATE,
    attendane VARCHAR(10),
    shift_id int,
    status VARCHAR(32),
    approver_id VARCHAR(64),
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN,
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
    is_deleted BOOLEAN
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
    date DATE,
    shift_id INT,
    emp_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN,
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
    is_deleted BOOLEAN
);

CREATE TABLE comp_off_details (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    date DATE,
    status VARCHAR(64),
    attend_id VARCHAR(64),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(64),
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(64),
    is_deleted BOOLEAN,
    FOREIGN KEY (attend_id)
        REFERENCES attendance_details (id)
);