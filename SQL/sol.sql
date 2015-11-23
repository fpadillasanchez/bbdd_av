\echo sol

CREATE TABLE sol(
	
	FOREIGN KEY (ano) REFERENCES cadastre(ano),
	id_Sol INTEGER PRIMARY KEY,
	superficie INTEGER
	
);
