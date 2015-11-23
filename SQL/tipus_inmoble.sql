\echo tipus inmoble

CREATE TABLE  tipus_inmoble(

	FOREIGN KEY (id_Subtipus) REFERENCES subtipus_inmoble(id_Subtipus),
	id_Subtipus INTEGER PRIMARY KEY,
	nom TEXT NOT NULL,
	descripcio VARCHAR(30)
	
	
);
