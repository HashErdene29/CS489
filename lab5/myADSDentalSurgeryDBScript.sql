------------------------------------ TABLES
create table Address (
	address_id int not null,
    street varchar(255) not null,
    city varchar(255) not null,
    state varchar(255) not null,
    postal_code int not null,
    country varchar(255) not null,
    primary key(address_id)
);

create table Patient (
	patient_id int not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number varchar(255) not null,
    email varchar(255) not null,
    date_of_birth date not null,
    address_id int,
    primary key(patient_id),
    foreign key(address_id) references Address(address_id)
);

create table Surgery (
	surgery_id int not null,
    surgery_name varchar(255) not null,
    phone_number varchar(255) not null,
    surgery_date varchar(255) not null,
    address_id int,
    primary key(surgery_id),
    foreign key (address_id) references Address(address_id)
);

create table OfficeManager (
	manager_id int not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number varchar(255),
    primary key(manager_id)
);

create table Dentist (
	dentist_id int not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number varchar(255) not null,
    specilization varchar(255) not null,
    primary key(dentist_id)
);

create table Appointment (
	appointment_id int not null,
    app_date date not null,
    app_type varchar(255) not null,
    dentist_id int,
    patient_id int,
    surgery_id int,
    primary key(appointment_id),
    foreign key (dentist_id) references Dentist(dentist_id),
    foreign key (patient_id) references Patient(patient_id),
    foreign key (surgery_id) references Surgery(surgery_id)
);

------------------------------------ DATA

INSERT INTO Address (address_id, street, city, state, postal_code, country) 
VALUES 
(1, '123 Main Street', 'Anytown', 'CA', 12345, 'USA'),
(2, '456 Elm Street', 'Sometown', 'NY', 54321, 'USA'),
(3, '789 Oak Street', 'Othertown', 'TX', 67890, 'USA'),
(4, '321 Pine Street', 'Smalltown', 'FL', 54321, 'USA'),
(5, '678 Maple Street', 'Villagetown', 'WA', 98765, 'USA'),
(6, '910 Cedar Street', 'Ruraltown', 'GA', 13579, 'USA');

INSERT INTO Patient (patient_id, first_name, last_name, phone_number, email, date_of_birth, address_id) 
VALUES 
(1, 'John', 'Doe', '555-123-4567', 'john.doe@example.com', '1990-05-15', 1),
(2, 'Jane', 'Smith', '555-987-6543', 'jane.smith@example.com', '1985-08-20', 2),
(3, 'Alice', 'Johnson', '555-555-5555', 'alice.johnson@example.com', '1978-12-10', 3);

INSERT INTO OfficeManager (manager_id, first_name, last_name, phone_number) 
VALUES 
(1, 'Michael', 'Smith', '555-123-7890'),
(2, 'Emily', 'Johnson', '555-456-7890'),
(3, 'David', 'Brown', '555-789-1234');

INSERT INTO Dentist (dentist_id, first_name, last_name, phone_number, specilization) 
VALUES 
(1, 'Sarah', 'Anderson', '555-111-3333', 'Orthodontist'),
(2, 'Mark', 'Taylor', '555-222-4444', 'Endodontist'),
(3, 'Laura', 'Wilson', '555-333-5555', 'Periodontist'),
(4, 'Emily', 'Clark', '555-444-6666', 'Pediatric Dentist');


INSERT INTO Surgery (surgery_id, surgery_name, phone_number, surgery_date, address_id) 
VALUES 
(1, 'Jaw Alignment Surgery', '555-111-2222', '2024-04-25', 1), 
(2, 'Root Canal Procedure', '555-222-3333', '2024-04-30', 2),
(3, 'Gum Disease Treatment', '555-333-4444', '2024-05-05', 3); 

INSERT INTO Appointment (appointment_id, app_date, app_type_id, dentist_id, patient_id, surgery_id) 
VALUES 
(1, '2024-04-12', 1, 1, 1, NULL),
(2, '2024-04-17', 2, 2, 2, 3),
(3, '2024-04-22', 3, 3, 3, NULL),
(4, '2024-04-25', 1, 1, 4, 1),
(5, '2024-04-30', 2, 2, 5, NULL),
(6, '2024-05-05', 3, 3, 6, 3);

------------------------------------ QUERY

-- 1
select * from dentist order by last_name asc;
-- 2
select a.appointment_id, a.app_date, a.app_type, d.dentist_id, p.*, ad.street, ad.city, ad.state, ad.postal_code, ad.country from appointment a 
inner join dentist d on a.dentist_id = d.dentist_id
inner join patient p on a.patient_id = p.patient_id
inner join address ad on p.address_id = ad.address_id
where d.dentist_id = 1;
-- 3
select a.appointment_id, a.app_date, a.app_type, s.surgery_name, s.surgery_date, ad.street, ad.city, ad.state, ad.postal_code, ad.country from appointment a 
inner join surgery s on a.surgery_id = s.surgery_id
inner join address ad on s.address_id = ad.address_id;
-- 4
select a.app_date, p.*, ad.street, ad.city, ad.state, ad.postal_code, ad.country from appointment a
	inner join patient p on a.patient_id = p.patient_id
    inner join address ad on p.address_id = ad.address_id
    where a.patient_id = 1 and a.app_date = "2024-04-12";

