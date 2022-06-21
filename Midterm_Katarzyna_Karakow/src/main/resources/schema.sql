CREATE TABLE carTypes(
id Long PRIMARY KEY AUTO_INCREMENT,
carType VARCHAR (255));

CREATE TABLE carModels(
id Long PRIMARY KEY AUTO_INCREMENT,
modelNo Long,
modelName VARCHAR (255),
carType VARCHAR (255),
price double (7),
description VARCHAR (255));
