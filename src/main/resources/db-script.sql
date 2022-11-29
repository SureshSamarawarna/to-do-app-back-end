
CREATE TABLE USER
(
    user_name VARCHAR(50) PRIMARY KEY,
    full_name VARCHAR(50)  NOT NULL,
    password  VARCHAR(150) NOT NULL
);

DROP TABLE TodoItem;
CREATE TABLE TodoItem(
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         user_name VARCHAR(50) NOT NULL ,
                         description VARCHAR(250) NOT NULL ,
                         status ENUM('DONE','NOT_DONE') NOT NULL ,
                         CONSTRAINT  FOREIGN KEY (user_name) REFERENCES USER (user_name)
)

INSERT INTO USER (user_name, full_name, password) VALUES
                                                      ('Tharindu','Tharindu Lasantha','123456789'),
                                                      ('Kavindu','Kavindu Hasaranga','987654321'),
                                                      ('Lathindu','Lathindu Hewagama','123459876');

INSERT INTO TodoItem ( user_name, description, status) VALUES
                                                              ('Tharindu','do something 1','NOT_DONE'),
                                                              ('Kavindu','do something 2','DONE'),
                                                              ('Lathindu','do something 3','NOT_DONE');
