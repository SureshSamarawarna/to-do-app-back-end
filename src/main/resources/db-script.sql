
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