\echo cadastre

CREATE TABLE cadastre {

	any TEXT,
	mes TEXT,
	dia TEXT,
	superficie INTEGER,
	taxes INTEGER,
	incripcions INTEGER,
	id_Inmoble FOREIGN KEY (sol) REFERENCES sol(superficie),
	id_Subinmoble FOREIGN KEY (subtipus) REFERENCES subtipus(id_Subtipus),
	id_Persona FOREIGN KEY (persona) REFERENCES persona(dni)
	
};
