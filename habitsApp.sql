CREATE DATABASE habitApp;
use habitApp;
drop database habitApp;


CREATE TABLE coachHabits (
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 name varchar(50) NOT NULL,
 points INT NOT NULL,
 description varchar(1000) NOT NULL
);

INSERT INTO coachHabits(name,points,description) VALUES
('Ilość posiłków',10,'Zjedz dzisiaj 5 posiłków. Dodaj do przynajmniej trzech porcję warzyw, a do kolejnych dwóch porcję owoców'),
('Pij na zdrowie',5,'Dbaj o nawodnienie w ciągu całego dnia. Dbaj o prawidłowe nawodnienie w ciągu całego dnia. Do bilansu wodnego zaliczamy oczywiście spożywanie takich płynów jak herbata, zupa czy kawa oraz warzywa, owoce i inne produkty bogate w wodę.'),
('Dbaj o sen', 15,'Zaleca się poświęcenie przynajmniej 7-8 godzin tej czynności. Oprócz długości snu duże znaczenie będzie miała odpowiednia higiena snu – spanie w wywietrzonym, chłodniejszym oraz zaciemnionym pomieszczeniu.'),
('Spędzaj czas na dworze',12,'Jeśli możesz wybieraj uprawianie aktywności na zewnątrz. Jeśli zdarzy się taka okazja – zjedz posiłek również na zewnątrz. ')
;

CREATE TABLE user(
idUser INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
email varchar(50) NOT NULL,
name varchar(50) NOT NULL,
password varchar(150) NOT NULL
);
select*from user;

CREATE TABLE habits(
idHabits INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name varchar(50) NOT NULL,
description varchar(500) ,
date date,
time time,
points int(50) NOT NULL,
status varchar(50) NOT NULL,
user_iduser INT,
INDEX ud_id(user_iduser) ,
foreign KEY (user_iduser) REFERENCES user(idUser)
);

select*from habits;


CREATE TABLE habits_user(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_iduser INT NOT NULL,
FOREIGN KEY (user_iduser) REFERENCES user(idUser),
habit_idhabits INT NOT NULL,
FOREIGN KEY (habit_idhabits) REFERENCES habits(idHabits)
);

CREATE TABLE checkins(
idCheckin INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
date_checkin DATE NOT NULL,
user_iduser INT NOT NULL,
FOREIGN KEY (user_iduser) REFERENCES user(idUser),
habits_idhabits INT NOT NULL,
FOREIGN KEY (habits_idhabits) REFERENCES habits(idHabits)
);

CREATE TABLE points(
idPoints INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_iduser INT NOT NULL,
FOREIGN KEY (user_iduser) REFERENCES user(idUser),
value INT
);



delimiter //
//
 -- trigger - kiedy użytkownik ustawia, że wykonał dane zadanie to w momenice updetu habitu,
 -- informcja o zadaniu przekazywane są do tabeli z checkinsami, czyli wykonanymi zadaniami oraz do tabeli points,
 -- gdzie widać informacje na temat punktów każdego z użytkowników
create trigger after_update_habits
after update
on habits for each row
begin

declare sum int;


select sum(points) 
into sum
from habits where user_iduser=new.user_iduser and status=new.status;

if new.status='done' then
insert into checkins(date_checkin,user_iduser,habits_idhabits)  
values(curdate(),new.user_iduser,new.idHabits);
if not exists (select user_iduser from points where user_iduser=new.user_iduser) then
insert into points(user_iduser,value)
values(new.user_iduser,sum);
else 
update points set value=sum where user_iduser=new.user_iduser;
end if;
end if;
end//
//






