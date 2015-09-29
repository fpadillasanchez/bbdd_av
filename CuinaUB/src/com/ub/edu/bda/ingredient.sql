\echo ingredient
CREATE TABLE ingredient{

	id_Ingredient INTEGER PRIMARY KEY,
	refrigeracio TEXT NOT NULL,
	id_Familia INTEGER FOREIGN KEY,
	familia TEXT NOT NULL,
	nom TEXT NOT NULL
		
};

