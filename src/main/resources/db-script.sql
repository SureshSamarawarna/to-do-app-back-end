
CREATE TABLE USER
(
    user_name VARCHAR(50) PRIMARY KEY,
    full_name VARCHAR(50)  NOT NULL,
    password  VARCHAR(150) NOT NULL
);

CREATE TABLE TodoItem(
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         user_name VARCHAR(50) NOT NULL ,
                         description VARCHAR(250) NOT NULL ,
                         status ENUM('DONE','NOT-DONE') NOT NULL ,
                         CONSTRAINT 'un_fk' FOREIGN KEY (user_name) REFERENCES USER (user_name)
)