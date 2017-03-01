Create table USERS(
	Uid char(4) not null, 
	First_Name varchar,
	Last_name varchar, 
	Address varchar, 
	Username char(15), 
	Password char(15), 
	Phone varchar, 
	Email varchar,
	Primary key (Uid)
);

Create table MOVIES(
	Mid char(4) NOT null, 
	Movie_name varchar, 
	Description varchar, 
	Genre varchar, 
	Duration int, 
	Rating decimal,
	MPAA varchar,
	Primary key (Mid)
);

Create table THEATRES(
	Tid char(4), 
	Theatre_Name varchar, 
	Street varchar, 
	City varchar, 
	State varchar, 
	Country varchar, 
	Zipcode int, 
	Phone varchar,
	Primary key (Tid)
);

Create table SHOWS(
	Sid char(4) NOT null,
	Mid char(4) REFERENCES MOVIES(mid) NOT null,
	Tid char(4) REFERENCES THEATRES(Tid) NOT null,
	Date varchar,
	Time varchar,
	Rate varchar(4),
	availability int,
	Primary key (Sid)
);

Create table Billing(
	Uid char(4) REFERENCES USERS(Uid) NOT null,
	Sid char(4) REFERENCES SHOWS(Sid) NOT null,
	Num_Tickets int,
	D_C char(10),
	Status char(1),
	Primary key (Uid,Sid)
);

insert into users values ('U002', 'anuja', 'jadhav', 'Athens', 'ajadhav', 'abcd', '765-258-610','ajadhav@gmail.com');

insert into movies values ('M001', 'Inception', 
'A thief who steals corporate secrets through use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.',
 'Sci-fi', 148, 8.8, 'PG-13');

insert into movies values ('M002', 'Interstellar', 
'Team of explorers travel through a wormhole in an attempt to ensure humanitys survival.',
 'Sci-fi', 169, 8.7, 'PG-13');

insert into movies values ('M003', 'The Gunman', 
'A sniper on a mercenary assassination team', 'Action', 115, 5.6, 'R');

insert into theatres values ('T001', 'GTC University 16', 
'1793 Oconee Connector', 'Athens', 'Georgia', 'USA',30606, '726-458-526');

insert into theatres values ('T002', 'GTC Commerce Stadium', 
'340 Banks Crossing Drive', 'Athens', 'Georgia', 'USA',30606, '756-789-123');

insert into shows values ('S001', 'M001', 'T001','5/18/2015','1pm', '7', 50);
insert into shows values ('S002', 'M001', 'T002','5/19/2015','5pm', '9', 50);
insert into shows values ('S003', 'M002', 'T002','5/20/2015','9pm', '9', 50);
insert into shows values ('S004', 'M003', 'T001','5/21/2015','11am', '6', 50);
