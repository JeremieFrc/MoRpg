use mydb;

DELETE FROM arme
WHERE id BETWEEN 5 and 100;

 -- /*******************insert Arlme*************************
INSERT INTO arme (nom,degat,cpa) 
VALUES  ('bagette',10,5),
		('potion',12,2),
        ('sortillege',12,2),
		('epee',12,2),
        
        ('fusil',20,20),
        ('pelle',8,2),
        ('gatlin',15,2);
        
	
INSERT INTO armure (nom,degat,cpa) 
VALUES  ('cape',10,5),
		('animal',12,2),
        ('souffle',12,2),
		('tank',12,2),
        ('voiture',20,20),
        ('bouclier',8,2),
        ('sable',15,2);
        
 -- /*******************Insert heritee*************************

insert into armemagic (arme_id) values (1);
insert into armemagic (arme_id) values (2);
insert into armemagic (arme_id) values (3);

insert into armephysic (arme_id) values (4);
insert into armephysic (arme_id) values (5);
insert into armephysic (arme_id) values (6);

insert into armuremagic (arme_id) values (1);
insert into armuremagic (arme_id) values (2);
insert into armuremagic (arme_id) values (3);

insert into armurephysic (arme_id) values (4);
insert into armurephysic (arme_id) values (5);
insert into armurephysic (arme_id) values (6);

-- /*****************Verification**************************
select 
	*
from arme;

select
*
from armemagic;

select
*
from armephysic;

select 
*
from armure;

-- /*****************armemagic****************************

select
	arme.nom,
    arme.degat,
    arme.cpa
from armemagic 
INNER join arme on arme.id = armemagic.arme_id;


    
-- /****************armephysic**************************

select
	arme.nom,
    arme.degat,
    arme.cpa
from armephysic 
	INNER join arme on arme.id = armephysic.arme_id;
    
-- /***************test de creation table mixte ***************************

-- 1 create table mixte 

DROP TABLE IF EXISTS armemixte;

CREATE TABLE armemixte (
	id BIGINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 2 create constrainte key primary and foreinKey
	
ALTER TABLE armemixte
ADD CONSTRAINT fk_armemixte_arme
    FOREIGN KEY (id)
    REFERENCES arme (id);
    
 CREATE TABLE IF NOT EXISTS armemixte (
  id BIGINT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  CONSTRAINT `fk_armemixte_arme`
    FOREIGN KEY (id)
    REFERENCES arme (`id`))ENGINE=InnoDB DEFAULT CHARSET=UTF8;   
    
  
 CREATE TABLE IF NOT EXISTS armemagique (
  id BIGINT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id),
  CONSTRAINT `fk_armemagique_arme`
    FOREIGN KEY (id)
    REFERENCES arme (`id`))ENGINE=InnoDB DEFAULT CHARSET=UTF8;   

use myrpg;    

select
	arme.id,
	arme.nom,
    arme.degat,
    arme.cpa
from armemagique 
INNER join arme on arme.id = armemagique.id;



    
    
    
    
    