/*
7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
8. Создать таблицы с иерархией из диаграммы в БД
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
*/

CREATE SCHEMA `human_friends`;

USE human_friends;

-- Реестр животных в питомнике

DROP TABLE IF EXISTS human_friends;
CREATE TABLE IF NOT EXISTS human_friends(
	id INT PRIMARY KEY AUTO_INCREMENT,
    type_of_animal_id INT,
    FOREIGN KEY (type_of_animal_id) REFERENCES type_of_animal(id_type)
);

INSERT INTO human_friends(type_of_animal_id) VALUES
(1),(6),(5),(5),(2),(3),(4),(1),(4),(2),(3),(6),(2),(5),(5),(1);

-- Виды животных

DROP TABLE IF EXISTS type_of_animal;
CREATE TABLE IF NOT EXISTS type_of_animal(
	id_type INT PRIMARY KEY AUTO_INCREMENT,
    type_of_animal VARCHAR(20),
    class INT,
	FOREIGN KEY (class) REFERENCES class(id_class)
);

INSERT INTO type_of_animal(type_of_animal, class) VALUES
('Dog', 1),
('Cat', 1),
('Hamster', 1),
('Horse', 2),
('Camel', 2),
('Donkey', 2);

-- Классы животных (Pet, Pack Animal)

DROP TABLE IF EXISTS class;
CREATE TABLE IF NOT EXISTS class(
	id_class INT PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(20)
);

INSERT INTO class(class_name) VALUES
('Pet'),
('Pack Animal');

-- Команды для животных

DROP TABLE IF EXISTS commands;
CREATE TABLE IF NOT EXISTS commands(
	id_commands INT PRIMARY KEY AUTO_INCREMENT,
    command_name VARCHAR(20)
);

INSERT INTO commands(command_name) VALUES
('Call'),
('Go'),
('Run'),
('Lie'),
('Faster'),
('Eat'),
('Stop');

-- Таблицы с животными по видам

DROP TABLE IF EXISTS dog;
CREATE TABLE IF NOT EXISTS dog(
	id_dog INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    name VARCHAR(20), 
    dateOfBirth DATE,
    gender VARCHAR(10), 
    breed VARCHAR(20),
    commands INT,
    FOREIGN KEY (animal_id) REFERENCES human_friends(id),
    FOREIGN KEY (commands) REFERENCES commands(id_commands)
);

INSERT INTO dog(animal_id, name, dateOfBirth, gender, breed, commands) VALUES
(1, 'Canela', '2018-11-05', 'female', 'pudel', 7),
(8, 'Charli', '2019-07-01', 'male', 'rotweiler', 4),
(16, 'Hatiko', '2021-03-07', 'male', 'haski', 1);

DROP TABLE IF EXISTS cat;
CREATE TABLE IF NOT EXISTS cat(
	id_cat INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    name VARCHAR(20), 
    dateOfBirth DATE,
    gender VARCHAR(10), 
    breed VARCHAR(20),
    commands INT,
    FOREIGN KEY (animal_id) REFERENCES human_friends(id),
    FOREIGN KEY (commands) REFERENCES commands(id_commands)
);

INSERT INTO cat(animal_id, name, dateOfBirth, gender, breed, commands) VALUES
(5, 'Teo', '2021-01-16', 'male', 'european', 1),
(10, 'Markiz', '2015-08-25', 'male', 'siam', 1),
(13, 'Philip', '2013-07-10', 'male', 'maykun', 6);

DROP TABLE IF EXISTS hamster;
CREATE TABLE IF NOT EXISTS hamster(
	id_hamster INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    name VARCHAR(20), 
    dateOfBirth DATE,
    gender VARCHAR(10), 
    breed VARCHAR(20),
    commands INT,
    FOREIGN KEY (animal_id) REFERENCES human_friends(id),
    FOREIGN KEY (commands) REFERENCES commands(id_commands)
);

INSERT INTO hamster(animal_id, name, dateOfBirth, gender, breed, commands) VALUES
(6, 'Pepe', '2023-10-11', 'female', 'eastern_piggy', NULL),
(11, 'Chichi', '2022-12-25', 'male', 'western_piggy', NULL);

DROP TABLE IF EXISTS horse;
CREATE TABLE IF NOT EXISTS horse(
	id_horse INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    name VARCHAR(20), 
    dateOfBirth DATE,
    gender VARCHAR(10), 
    breed VARCHAR(20),
    commands INT,
    FOREIGN KEY (animal_id) REFERENCES human_friends(id),
    FOREIGN KEY (commands) REFERENCES commands(id_commands)
);

INSERT INTO horse(animal_id, name, dateOfBirth, gender, breed, commands) VALUES
(7, 'Halk', '2019-05-27', 'male', 'strongest', 3),
(9, 'Juanita', '2022-12-25', 'female', 'spanish', 3);

DROP TABLE IF EXISTS camel;
CREATE TABLE IF NOT EXISTS camel(
	id_camel INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    name VARCHAR(20), 
    dateOfBirth DATE,
    gender VARCHAR(10), 
    breed VARCHAR(20),
    commands INT,
    FOREIGN KEY (animal_id) REFERENCES human_friends(id),
    FOREIGN KEY (commands) REFERENCES commands(id_commands)
);

INSERT INTO camel(animal_id, name, dateOfBirth, gender, breed, commands) VALUES
(3, 'Mehmed', '2014-02-18', 'male', 'nearestern', 5),
(4, 'Ahmed', '2022-01-10', 'male', 'persian', 2),
(14, 'Saltan', '2017-04-01', 'male', 'african', 2),
(15, 'Kebaba', '2019-06-30', 'female', 'african', 5);

DROP TABLE IF EXISTS donkey;
CREATE TABLE IF NOT EXISTS donkey(
	id_donkey INT PRIMARY KEY AUTO_INCREMENT,
    animal_id INT,
    name VARCHAR(20), 
    dateOfBirth DATE,
    gender VARCHAR(10), 
    breed VARCHAR(20),
    commands INT,
    FOREIGN KEY (animal_id) REFERENCES human_friends(id),
    FOREIGN KEY (commands) REFERENCES commands(id_commands)
);

INSERT INTO donkey(animal_id, name, dateOfBirth, gender, breed, commands) VALUES
(2, 'Beauty', '2020-05-18', 'female', 'hardworker', 7),
(12, 'Armagedon', '2020-03-03', 'male', 'hardworker', 7);

-- Показать реестр всех животных

DELIMITER $$
DROP PROCEDURE IF EXISTS animal_list;
CREATE PROCEDURE IF NOT EXISTS animal_list()
BEGIN
	DROP TEMPORARY TABLE IF EXISTS all_animals;
	CREATE TEMPORARY TABLE all_animals(
		SELECT h.id, t.type_of_animal, c.class_name, l.name, 
		l.dateOfBirth, l.gender, l.breed, l.commands 
		FROM human_friends AS h
		JOIN type_of_animal AS t ON h.type_of_animal_id = t.id_type
		JOIN class AS c ON t.class = c.id_class
		JOIN (SELECT * FROM dog
			UNION SELECT * FROM cat
			UNION SELECT * FROM hamster
			UNION SELECT * FROM horse
			UNION SELECT * FROM camel
			UNION SELECT * FROM donkey) AS l ON h.id=l.animal_id
		ORDER BY h.id
	);
	SELECT * FROM all_animals;
END $$
DELIMITER ;

 CALL animal_list();
 
-- Удалим из таблицы верблюдов

DELETE FROM all_animals WHERE all_animals.type_of_animal='Camel';

-- Объединим таблицы лошади, и ослы в одну таблицу. Т.е. создадим таблицу с оствшимися в питомнике вьючными животными.

DELIMITER $$
DROP PROCEDURE IF EXISTS pack_animals_in_kennel;
CREATE PROCEDURE pack_animals_in_kennel()
BEGIN
	DROP TEMPORARY TABLE IF EXISTS rest_of_pack_animals;
	CREATE TEMPORARY TABLE IF NOT EXISTS rest_of_pack_animals(
		SELECT * FROM all_animals
		WHERE class_name='Pack Animal'
	);
	SELECT * FROM rest_of_pack_animals;
END $$
DELIMITER ;

CALL pack_animals_in_kennel();

-- Создать новую таблицу “молодые животные” в которую попадут все 
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице

DELIMITER $$
DROP FUNCTION IF EXISTS get_age;
CREATE FUNCTION IF NOT EXISTS get_age(d DATE)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
	DECLARE age VARCHAR(20) DEFAULT '';
		SET age=CONCAT(
			TIMESTAMPDIFF(YEAR, d, CURDATE()),
            ' y. ',
            TIMESTAMPDIFF(MONTH, d, CURDATE()) % 12,
            ' m.'
		);
	RETURN age;
END $$
DELIMITER ;

DELIMITER $$
DROP PROCEDURE IF EXISTS young_animals;
CREATE PROCEDURE young_animals()
BEGIN
	DROP TEMPORARY TABLE IF EXISTS young_animals;
	CREATE TEMPORARY TABLE IF NOT EXISTS young_animals(
		SELECT *, get_age(dateOfBirth) FROM all_animals
		WHERE TIMESTAMPDIFF(YEAR, dateOfBirth, CURDATE()) BETWEEN 1 AND 2
	);
    SELECT * FROM young_animals;
END $$
DELIMITER ;

CALL young_animals();

-- Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

DELIMITER $$
DROP PROCEDURE IF EXISTS full_list;
CREATE PROCEDURE IF NOT EXISTS full_list()
BEGIN
	DROP TEMPORARY TABLE IF EXISTS full_list;
	CREATE TEMPORARY TABLE IF NOT EXISTS full_list(
		SELECT *, get_age(dateOfBirth) AS age
		FROM human_friends AS h
		JOIN type_of_animal AS t ON h.type_of_animal_id = t.id_type
		JOIN class AS c ON t.class = c.id_class
		JOIN (SELECT * FROM dog
			UNION SELECT * FROM cat
			UNION SELECT * FROM hamster
			UNION SELECT * FROM horse
			UNION SELECT * FROM camel
			UNION SELECT * FROM donkey) AS l ON h.id=l.animal_id
		ORDER BY h.id
	);
	SELECT * FROM full_list;
END $$
DELIMITER ;

 CALL full_list();