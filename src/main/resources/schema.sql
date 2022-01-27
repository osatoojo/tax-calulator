DROP ALL OBJECTS;

DROP TABLE IF EXISTS tax;
CREATE TABLE tax (
                     id INT AUTO_INCREMENT  PRIMARY KEY,
                     min_amount NUMERIC NOT NULL,
                     max_amount NUMERIC NOT NULL,
                     rate NUMERIC NOT NULL,
                     filling_status VARCHAR(10) NOT NULL,
                     year INT NOT NULL

);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      first_name VARCHAR(50) NOT NULL,
                      last_name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS salary;
CREATE TABLE salary (
                        id INT AUTO_INCREMENT  PRIMARY KEY,
                        amount NUMERIC NOT NULL,
                        additional_amount NUMERIC NULL,
                        year INT NOT NULL,
                        user_id INT NOT NULL,
                        tax_id INT NOT NULL,
                        FOREIGN KEY (tax_id) REFERENCES tax(id),
                        FOREIGN KEY (user_id) REFERENCES user(id)

);
CREATE  INDEX ix_salary_year_taxid ON salary(year, tax_id);


