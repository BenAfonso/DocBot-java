# CREATE DATABASE docbot_dev;

# \c docbot_dev;

DROP TABLE IF EXISTS Person;
DROP TABLE IF EXISTS Patient;
DROP TABLE IF EXISTS Administrator;
DROP TABLE IF EXISTS Policy;
DROP TABLE IF EXISTS Doctor;
DROP TABLE IF EXISTS AnswerTemplate;
DROP TABLE IF EXISTS Hour;
DROP TABLE IF EXISTS Day;
DROP TABLE IF EXISTS Schedule;
DROP TABLE IF EXISTS Disponibility;
DROP TABLE IF EXISTS RequestAppointment;
DROP TABLE IF EXISTS Appointment;
DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS AnswerRequest;

CREATE TABLE Person (
    id SERIAL,
    firstName VARCHAR(30),
    lastName VARCHAR(40),
    birthday DATE,
    phone VARCHAR(15),
    email VARCHAR(50),
    isValidated boolean,
    PRIMARY KEY (id)
);

CREATE TABLE Patient (
    id integer REFERENCES Person (id),
    isBlocked boolean,
    doctor_id integer REFERENCES Doctor (id),
    PRIMARY KEY (id)
);

CREATE TABLE Administrator (
    id integer REFERENCES Person (id),
    PRIMARY KEY (id)
);

CREATE TABLE Policy (
    id integer,
    name VARCHAR(60),
    description VARCHAR(255),
    PRIMARY KEY (id)
); 

CREATE TABLE Doctor (
    id integer REFERENCES Person (id),
    siret VARCHAR(50),
    number VARCHAR(5),
    street VARCHAR(120),
    city VARCHAR(40),
    zip_code VARCHAR(8),
    policy_id integer REFERENCES Policy (id),
    PRIMARY KEY (id)
);

CREATE TABLE AnswerTemplate (
    id integer,
    doctor_id integer REFERENCES Doctor (id),
    name VARCHAR(90),
    content VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Hour (
    time time,
    PRIMARY KEY (time)
);

CREATE TABLE Day (
    date date,
    PRIMARY KEY (date)
);

CREATE TABLE Schedule (
    id SERIAL UNIQUE,
    doctor_id integer REFERENCES Person (id),
    date date REFERENCES Day (date), 
    PRIMARY KEY (doctor_id, date)    
);


CREATE TABLE Disponibility (
    id SERIAL UNIQUE,
    schedule_id integer REFERENCES Schedule (id),
    hourStart time REFERENCES Hour (time),
    hourEnd time,
    description VARCHAR(255),
    PRIMARY KEY (hourStart, schedule_id)
);

CREATE TABLE RequestAppointment (
    id SERIAL UNIQUE,
    patient_id integer REFERENCES Patient (id),
    disponibility_id integer REFERENCES Disponibility (id),
    PRIMARY KEY (patient_id, disponibility_id)
);

CREATE TABLE Appointment (
    id SERIAL UNIQUE,
    requestAppointment_id integer REFERENCES RequestAppointment (id),
    PRIMARY KEY (id)
);

CREATE TABLE Comment (
    id SERIAL UNIQUE,
    requestAppointment_id integer REFERENCES RequestAppointment (id), 
    datePost timestamp,
    title VARCHAR(90),
    content VARCHAR(255),
    rate integer,
    PRIMARY KEY (id)
);

CREATE TABLE AnswerRequest (
    id SERIAL UNIQUE,  
    title VARCHAR(90),
    content VARCHAR(255),
    requestAppointment_id integer REFERENCES RequestAppointment (id),
    PRIMARY KEY (id)
);

