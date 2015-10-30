\echo cadastre

CREATE TABLE cadastre{

	m2 FOREIGN KEY (sol) REFERENCES sol(superficie),
	inscripcions INTEGER,
	id_AltaInscripcio   ,
	id_BaixaInscripcio  ,
	id_Inmoble FOREIGN KEY (sol) REFERENCES sol(superficie),
	id_Subinmoble FOREIGN KEY (subtipus) REFERENCES subtipus(id_Subtipus),
	id_Persona FOREIGN KEY (persona) REFERENCES persona(dni)
	
};
