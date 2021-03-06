use testdb;
show tables;
CREATE TABLE pet (
name VARCHAR(20),
id MEDIUMINT NOT NULL AUTO_INCREMENT,
owner VARCHAR(20),
species VARCHAR(20),
sex CHAR(1),
birth DATE,
death DATE,
PRIMARY KEY (id)
) engine = InnoDB;

CREATE TABLE user (
    id mediumint not null auto_increment,
    first_name CHAR(30) NULL ,
    last_name CHAR(30) null ,
    primary key (id)
) engine = InnoDB;;

DELIMITER //

create procedure read_pet (
IN in_name VARCHAR(100),
OUT out_owner VARCHAR(100),
out out_species VARCHAR(100),
out out_sex VARCHAR(100),
out out_birth DATE,
out out_death DATE
)

BEGIN
    select owner,species,sex,birth,death
        INTO out_owner,out_species,out_sex,out_birth,out_death
    FROM pet where name = in_name;
end //
DELIMITER ;

CALL read_pet('Fluffy',@out_owner,@out_species,@out_sex,
    @out_birth, @out_death);

select @out_owner,@out_species,@out_sex,@out_birth,@out_death;

delimiter //
create procedure read_all_pets()
begin
    select * from pet;
end //

delimiter ;

call read_all_pets();

delimiter $$

SET GLOBAL log_bin_trust_function_creators = 1;
create function get_pet_owner(in_name varchar(200))
returns
varchar(200)
begin
    declare out_owner varchar(200);

    select owner
    into out_owner
    from pet where name = in_name;
    return out_owner;
end; $$
SET GLOBAL log_bin_trust_function_creators = 0;

select get_pet_owner('Fluffy') as owner; $$