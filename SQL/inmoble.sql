\echo inmoble

CREATE TABLE inmoble{

	FOREIGN KEY (any) REFERENCES cadastre(any),
	data_baixa TEXT NOT NULL,
	data_alta TEXT NOT NULL,
	id_Inmoble INTEGER PRIMARY KEY,
	estat TEXT NOT NULL,
	internet TEXT NOT NULL,
	referencia_cadastral TEXT NOT NULL,
	num_residents INTEGER,
	planta INTEGER
	
};
