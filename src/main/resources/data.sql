INSERT INTO owners (id, name, dateOfBirth, drivingLicence)
VALUES
(1, 'Ivanov', '01.01.1990', '1601984257'),
(2, 'Petrov', '01.02.1980', '1601787328'),
(3, 'Smirnov', '01.03.1995', '1601780312'),
(4, 'Morozov', '01.04.1960', '1601949827'),
(5, 'Pavlov', '01.05.1970', '1606427985');

INSERT INTO autos (id, model, vin, regNumber, ownerId)
VALUES
       (1, 'BMW', 'KMSKJ84NVOF540289', 'b005mw_116', 2),
       (2, 'Kia', 'QILHU19VKNS402903', 'k006ia_716', 1),
       (3, 'Mazda', 'AJHUE48QLID049838', 'm002az_716', 3),
       (4, 'Jaguar', 'KDSJA90GLKJ219206', 'e007ee_716', 4),
       (5, 'Audi', 'SLEOE22TTYU129093', 'a001ud_116', 3),
       (6, 'Subaru', 'EHCXJ59JDFJ956171', 's009ub_116', 2),
       (7, 'Lada', 'KMHUI12WQIW059928', 'u001hh_116', 1),
       (8, 'Toyota', 'WEGJK02KHKW063828', 't006ot_116', 5),
       (9, 'Jeep', 'ITUWK50BQEJ432542', 'g009ep_116', 1);

INSERT INTO offenses (id, regNumber, article, amountFine, urlPhoto, paid)
VALUES
       (1, 't006ot_116', '12.10.2', 1000, '/media/c30a6ac0-b8dc-41e0-ab84-99878411d7ba.jpeg', 1),
       (2, 'k006ia_716', '12.3.3.', 3000, '/media/7b73e23b-4ad7-4622-948d-36c05822dabc.jpeg', 0),
       (3, 's009ub_116', '12.9.2', 500, '/media/2b014d19-3fb8-44d6-85c5-9c9008436c20.jpeg', 1),
       (4, 'b005mw_116', '12.9.3', 1500, '/media/f52b0c75-57c1-4f35-ad6d-6fa518d69bc7.jpeg', 1),
       (5, 's009ub_116', '12.9.3', 1500, '/media/ad2f485c-5996-435a-801c-8b8be3c4719e.jpeg', 0),
       (6, 'b005mw_116', '12.9.2', 500, '/media/f52b0c75-57c1-4f35-ad6d-6fa518d69bc7.jpeg', 0),
       (7, 'e007ee_716', '12.9.4', 2500, '/media/3dc5108d-602c-4493-a397-1776bf2aa353.jpeg', 0),
       (8, 'a001ud_116', '12.12.2', 800, '/media/ee1bf59a-b1fd-4ea9-b051-2c31f925bcc0.jpeg', 0),
       (9, 'b005mw_116', '12.9.4', 2500, '/media/f52b0c75-57c1-4f35-ad6d-6fa518d69bc7.jpeg', 0),
       (10, 'e007ee_716', '12.9.3', 1500, '/media/3dc5108d-602c-4493-a397-1776bf2aa353.jpeg', 0);






