use mysql;
create database bucktime;
create user 히히빅뱅@localhost identified by '히히 몰라';
grant select, delete, insert, update on bucktime.* to 히히빅뱅@localhost;
flush privileges;