CREATE TABLE IF NOT EXISTS user(
                        user_id INTEGER AUTO_INCREMENT,
                        email varchar(255),
                        password text,
                        birthday text,
                        PRIMARY KEY(id)
);