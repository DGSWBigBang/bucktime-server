use mysql;
create database bucktime;
create user bigbang@localhost identified by 'bigbang12!@';
grant select, delete, insert, update on bucktime.* to bigbang@localhost;
flush privileges;