-- CREATE DATABASE docbot_dev;
-- \c docbot_dev;

DROP TABLE IF EXISTS AnswerRequest;
DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Appointment;
DROP TABLE IF EXISTS RequestAppointment;
DROP TABLE IF EXISTS Disponibility;
DROP TABLE IF EXISTS Schedule;
DROP TABLE IF EXISTS Day;
DROP TABLE IF EXISTS Hour;
DROP TABLE IF EXISTS AnswerTemplate;
DROP TABLE IF EXISTS Administrator;
DROP TABLE IF EXISTS Patient;
DROP TABLE IF EXISTS Doctor;
DROP TABLE IF EXISTS Policy;
DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
    id SERIAL UNIQUE NOT NULL,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(40) NOT NULL,
    password VARCHAR(255) NOT NULL,
    birthday DATE,
    phone VARCHAR(15),
    email VARCHAR(50) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Doctor (
    id integer REFERENCES Person (id),
    siret VARCHAR(50),
    number VARCHAR(5),
    street VARCHAR(120),
    city VARCHAR(40),
    zip_code VARCHAR(8),
    isValidated boolean DEFAULT false,
    PRIMARY KEY (id)
);

CREATE TABLE Patient (
    id integer REFERENCES Person (id),
    isBlocked boolean DEFAULT false,
    doctor_id integer REFERENCES Doctor (id),
    PRIMARY KEY (id)
);

CREATE TABLE Administrator (
    id integer REFERENCES Person (id),
    PRIMARY KEY (id)
);




CREATE TABLE AnswerTemplate (
    id integer,
    doctor_id integer REFERENCES Doctor (id),
    name VARCHAR(90),
    content VARCHAR(255),
    PRIMARY KEY (id)
);


CREATE TABLE Schedule (
    id SERIAL UNIQUE,
    doctor_id integer REFERENCES Person (id),
    date date,
    PRIMARY KEY (doctor_id, date)
);


CREATE TABLE Disponibility (
    id SERIAL UNIQUE,
    schedule_id integer REFERENCES Schedule (id),
    hourStart int,
    minuteStart int,
    hourEnd int,
    minuteEnd int,
    description VARCHAR(255),
    isBooked boolean,
    PRIMARY KEY (hourStart,minuteStart, schedule_id)
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

INSERT INTO Person VALUES (1,'Admin','Admin','admin','06/13/1995','0667901111','admin@mail.fr');
INSERT INTO Administrator VALUES (1);

INSERT INTO Person VALUES (2,'Nicolas','Zambrano','123','06/13/1995','0667901111','nico@mail.fr');
INSERT INTO Doctor VALUES (2,'104I19491419','239','chemin de la coccinelle','Sète','34200',true);

INSERT INTO Person VALUES (3,'Bastien','Ricoeur','123','06/13/1995','0667901111','bastien@mail.fr');
INSERT INTO Patient VALUES (3,false);
