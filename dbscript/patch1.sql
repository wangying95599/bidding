CREATE TABLE `sys_sequence` (  
   `NAME` varchar(50) NOT NULL,  
   `CURRENT_VALUE` int(11) NOT NULL DEFAULT '0',  
   `INCREMENT` int(11) NOT NULL DEFAULT '1',  
   PRIMARY KEY (`NAME`)  
 )
 
 
 INSERT INTO SYS_SEQUENCE(NAME,CURRENT_VALUE,INCREMENT) VALUES('TBL_FS', 1,1)  
 DELIMITER $$  
  
 
DROP FUNCTION IF EXISTS `currval`$$  
  
CREATE DEFINER=`root`@`%` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS INT(11)  
BEGIN  
DECLARE VALUE INTEGER;  
SET VALUE=0;  
SELECT current_value INTO VALUE  
FROM sys_sequence   
WHERE NAME=seq_name;  
RETURN VALUE;  
END$$  
DELIMITER ;


grant all privileges on *.* to root@"%" identified by "password";   
flush privileges; 


DELIMITER $$  
DROP FUNCTION IF EXISTS `nextval`$$  
  
CREATE DEFINER=`root`@`%` FUNCTION `nextval`(seq_name varchar(50)) RETURNS int(11)  
BEGIN  
UPDATE sys_sequence  
SET CURRENT_VALUE = CURRENT_VALUE + INCREMENT  
where name=seq_name;  
return currval(seq_name);  
END$$  


INSERT INTO SYS_SEQUENCE(NAME,CURRENT_VALUE,INCREMENT) VALUES('projects_id_seq', 1,1);
select nextval('projects_id_seq')  ;

INSERT INTO SYS_SEQUENCE(NAME,CURRENT_VALUE,INCREMENT) VALUES('set_id_seq', 1,1);
select nextval('set_id_seq')  ;
