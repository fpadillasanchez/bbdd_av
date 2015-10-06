\echo recepta
CREATE TABLE recepta{

	id_Recepta INTEGER PRIMARY KEY,
        nom Text NOT NULL,
	elaboracio character varying(60),
	temps TEXT NOT NULL,
	dificultat TEXT NOT NULL,
	id_Xef INTEGER

};
