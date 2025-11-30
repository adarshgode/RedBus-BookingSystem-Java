create database redbus;
use redbus;
create table buses(busno int primary key, busname varchar(225), bustype enum('ac', 'non-ac'), seattype enum('seater', 'sleeper'), totalseats int , availseats int, boardingpoint varchar(225) , dropingpoint varchar(225),
	occupiedseats int, boardingtime time, droppingtime time, dateofboarding date, rating int, pricing decimal(9,2));

INSERT INTO buses VALUES
(201, 'Shiv Travels', 'ac', 'seater', 40, 25, 'Pune', 'Mumbai',
 15, '09:00:00', '12:30:00', CURDATE() + INTERVAL 1 DAY, 4, 550.00),

(202, 'Royal Express', 'non-ac', 'seater', 45, 30, 'Nagpur', 'Amravati',
 15, '10:15:00', '12:45:00', CURDATE() + INTERVAL 1 DAY, 3, 400.00),

(203, 'Cityline Sleeper', 'ac', 'sleeper', 30, 10, 'Mumbai', 'Surat',
 20, '20:00:00', '04:30:00', CURDATE() + INTERVAL 1 DAY, 5, 1200.00),

(204, 'Night Rider', 'non-ac', 'sleeper', 28, 18, 'Nashik', 'Pune',
 10, '22:30:00', '03:45:00', CURDATE() + INTERVAL 1 DAY, 4, 850.00),

(205, 'Green Travels', 'ac', 'seater', 50, 40, 'Kolhapur', 'Pune',
 10, '08:45:00', '11:15:00', CURDATE() + INTERVAL 1 DAY, 4, 600.00),

(206, 'MetroLine', 'non-ac', 'seater', 48, 32, 'Aurangabad', 'Mumbai',
 16, '07:10:00', '12:00:00', CURDATE() + INTERVAL 1 DAY, 3, 350.00),

(207, 'Comfort Sleeper', 'ac', 'sleeper', 32, 20, 'Mumbai', 'Nagpur',
 12, '21:00:00', '07:00:00', CURDATE() + INTERVAL 1 DAY, 5, 1500.00),

(208, 'FastTrack', 'ac', 'seater', 42, 22, 'Pune', 'Ahmedabad',
 20, '06:30:00', '13:00:00', CURDATE() + INTERVAL 1 DAY, 4, 500.00),

(209, 'Rajdhani Bus', 'non-ac', 'sleeper', 30, 12, 'Surat', 'Mumbai',
 18, '23:15:00', '05:45:00', CURDATE() + INTERVAL 1 DAY, 3, 750.00),

(210, 'BlueLine Travels', 'ac', 'seater', 44, 28, 'Mumbai', 'Pune',
 16, '11:40:00', '14:10:00', CURDATE() + INTERVAL 1 DAY, 5, 650.00);

create table bookedSeat(bId int primary key, busno int , passname varchar(225), phonenum varchar(225),
gender enum('male','female'), ispayed boolean, foreign key(busno) references buses(busno));

create table users( uid int primary key auto_increment, name varchar(225), phonenum varchar(15) , gender enum('male','female'));

create table bookings(bid int primary key auto_increment,
	uid int, busno int, seats_booked int, total_amount decimal(9,2),
	booking_date date, ispaid boolean, foreign key(uid) references users(uid),
    foreign key(busno) references buses(busno)
);
    
create table seatbooked(
	sid int primary key auto_increment,
    bid int,
    seat_no int,
    foreign key(bid) references bookings(bid)
);


