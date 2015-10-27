\ juridica

CREATE TABLE juridica (
	FOREIGN KEY (nom) REFERENCES persona(nom),
  	NIF TEXT PRIMARY KEY,
  	primer_Cognom TEXT NOT NULL,
  	segon_Cognom TEXT NOT NULL

  
);
