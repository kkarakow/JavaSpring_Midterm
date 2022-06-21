	CREATE TABLE provinces(
	id LONG PRIMARY KEY AUTO_INCREMENT,
	provinceName VARCHAR(255));
	
	CREATE TABLE customers(
	id LONG PRIMARY KEY AUTO_INCREMENT,
	custName VARCHAR(255),
	custAddress VARCHAR(255),
	custProvince VARCHAR(255),
	custCountry VARCHAR(255)
	);