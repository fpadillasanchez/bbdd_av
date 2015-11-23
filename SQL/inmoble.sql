\echo inmoble

CREATE TABLE inmoble(

	FOREIGN KEY (ano) REFERENCES cadastre(ano),
	id_Inmoble INTEGER PRIMARY KEY,
	data_baixa TEXT NOT NULL,
	data_alta TEXT NOT NULL,
	estat TEXT NOT NULL,
	internet TEXT NOT NULL,
	referencia_cadastral TEXT NOT NULL,
	num_residents INTEGER,
	planta INTEGER
	
);
