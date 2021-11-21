drop table if exists user;
drop table if exists sector;
drop table if exists user_sectors;

create table user
(
	user_id varchar not null,
	password varchar not null,
	name     varchar not null,
	constraint pk_user_id primary key (user_id)
);

create table sector
(
	sector_id int,
	name      varchar(50) not null,
	parent_id int,
	constraint pk_sector_id primary key (sector_id),
	foreign key (parent_id) references sector (sector_id)
);

create table user_sector
(
	user_id  varchar not null,
	sector_id int          not null,
	foreign key (user_id) references user (user_id),
	foreign key (sector_id) references sector (sector_id),
	constraint pk_user_sector primary key (user_id, sector_id)
);
