CREATE TABLE  user(
id VARCHAR (20) PRIMARY KEY NOT NULL,
firstname VARCHAR (50) NOT NULL,
lastname VARCHAR (60) NOT NULL,
gender VARCHAR (10) NOT NULL,
nic VARCHAR (10) NOT NULL,
email VARCHAR (10) NOT NULL,
dob TIMESTAMP ,
role VARCHAR (20),

),

INSERT INTO users (id , firstname , lastname , gender , nic , email , dob ,role ) VALUES (
 '1' , 'Naveen' , 'Perera' , 'Male' , '942260512V' , 'naveenperera777@gmail.com' , '2019-06-17 00:00:00' , 'Admin'
)