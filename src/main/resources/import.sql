/** Provider **/
INSERT INTO provider(id, first_name, last_name, salutation, telno, mobile_number,created, created_by)
VALUES (-299, 'Marcus', 'Welby', 'Dr.', '650-555-1212','415-555-1212',now(), -9999);
INSERT INTO provider(id, first_name, last_name, salutation, telno, mobile_number,created, created_by)
VALUES (-399, 'Mindy', 'Lahiri', 'Dr.', '510-555-1212','925-555-1212',now(), -9999);

/** Patient **/
INSERT INTO patient(id, first_name, last_name, salutation, id_image_location, dob)
VALUES (-9, 'Jane', 'Doe', 'Ms.', '/images/jdoe1/localPic1.jpg', '1974-11-29');
INSERT INTO patient(id, first_name, last_name, salutation, id_image_location, dob)
VALUES (-99, 'Beyonce', 'Knowles', 'Ms.', '/images/jdoe1/localPic1.jpg', '1981-09-29');
INSERT INTO patient(id, first_name, last_name, salutation, id_image_location, dob)
VALUES (-999, 'Brad', 'Pitt', 'Mr.', '/images/jdoe1/localPic1.jpg', '1963-12-28');


/** Appointment **/
INSERT INTO appointment(id, provider_id, patient_id, location_id, start_time, end_time,
            notes, created, created_by)
VALUES (-9, -9, -9, -9, (date '2016-08-01' + time '07:00'), (date '2016-08-01' + time '08:00'), 'test Notes', now(), -9);
INSERT INTO appointment(id, provider_id, patient_id, location_id, start_time, end_time,
            notes, created, created_by)
VALUES (-91, -9, -9, -9, (date '2016-08-01' + time '09:00'), (date '2016-08-01' + time '10:00'), 'test Notes', now(), -9);
INSERT INTO appointment(id, provider_id, patient_id, location_id, start_time, end_time,
            notes, created, created_by)
VALUES (-92, -9, -9, -9, (date '2016-08-01' + time '10:00'), (date '2016-08-01' + time '11:00'), 'test Notes', now(), -9);
INSERT INTO appointment(id, provider_id, patient_id, location_id, start_time, end_time,
            notes, created, created_by)
VALUES (-93, -9, -9, -9, (date '2016-08-01' + time '11:00'), (date '2016-08-01' + time '12:00'), 'test Notes', now(), -9);
INSERT INTO appointment(id, provider_id, patient_id, location_id, start_time, end_time,
            notes, created, created_by)
VALUES (-94, -9, -9, -9, (date '2016-08-01' + time '14:00'), (date '2016-08-01' + time '15:00'), 'test Notes', now(), -9);
INSERT INTO appointment(id, provider_id, patient_id, location_id, start_time, end_time,
            notes, created, created_by)
VALUES (-95, -9, -9, -9, (date '2016-08-01' + time '17:00'), (date '2016-08-01' + time '18:00'), 'test Notes', now(), -9);



/** Location **/
INSERT INTO location(id, location_name, address1, address2, city, state_province,
            postal_code, country, main_number,created, created_by)
VALUES (-9, 'Mountain View Office', '235 Main', 'Suite 345', 'Mountain View', 'CA', '94039', 'US','650-234-1234', now(), -9999);
INSERT INTO location(id, location_name, address1, address2, city, state_province,
            postal_code, country, main_number,created, created_by)
VALUES (-99, 'San Jose Office', '235 Jefferson', 'Suite 345', 'San Jose', 'CA', '95105', 'US','650-234-1234', now(), -9999);
INSERT INTO location(id, location_name, address1, address2, city, state_province,
            postal_code, country, main_number,created, created_by)
VALUES (-999, 'San Francisco Office', '235 Washington', 'Suite 345', 'San Francisco', 'CA', '94106', 'US','650-234-1234', now(), -9999);


