package DataBase;

public class DataBase {

    public String CreateTablePROFESORI()
    {
        String sqlProfesor = "CREATE TABLE IF NOT EXISTS PROFESORI ("
                        + "profesor_id INTEGER PRIMARY KEY ,"
                        + "nume VARCHAR(50) NOT NULL,"
                        + "prenume VARCHAR(50) NOT NULL,"
                        +"varsta INTEGER NOT NULL,"
                        +"sex VARCHAR(50) NOT NULL,"
                        +"scoala VARCHAR(50) NOT NULL,"
                        +"salariu DOUBLE NOT NULL,"
                        +"materie VARCHAR(50) NOT NULL,"
                        +"grad INTEGER NOT NULL"
                        +")";
        return sqlProfesor;
    }

    public String CreateTableELEVI()
    {


        String sqlElev = "CREATE TABLE IF NOT EXISTS ELEVI("
                + "elev_id INTEGER PRIMARY KEY ,"
                + "nume VARCHAR(50) NOT NULL,"
                + "prenume VARCHAR(50) NOT NULL,"
                + "varsta INTEGER NOT NULL,"
                +  "sex VARCHAR(50) NOT NULL,"
                +  "scoala VARCHAR(50) NOT NULL,"
                + "clasa VARCHAR(50) NOT NULL,"
                + "medie DOUBLE NOT NULL"
                +")";
        return sqlElev;
    }


    public String CreateTableMATERII() {


        String sqlMaterie = "CREATE TABLE IF NOT EXISTS MATERII("
                + "materie_id INTEGER PRIMARY KEY ,"
                + "nume VARCHAR(50) NOT NULL,"
                + "credite INTEGER NOT NULL,"
                + "profesor_curs_id INTEGER NOT NULL,"
                + "profesor_laborator_id INTEGER NOT NULL,"
                + "FOREIGN KEY (profesor_curs_id) REFERENCES PROFESORI(profesor_id),"
                + "FOREIGN KEY (profesor_laborator_id) REFERENCES PROFESORI(profesor_id)"
                + ")";
        return sqlMaterie;
    }



    public String CreateTableNOTE() {


        String Note = "CREATE TABLE IF NOT EXISTS NOTE("
                + "nota_id INTEGER PRIMARY KEY ,"
                + "elev_id INTEGER NOT NULL,"
                + "materie_id INTEGER NOT NULL,"
                + "materie VARCHAR(50) NOT NULL,"
                + "nota DOUBLE NOT NULL,"
                + "FOREIGN KEY (elev_id) REFERENCES ELEVI(elev_id),"
                + "FOREIGN KEY (materie_id) REFERENCES MATERII(materie_id)"
                +")";
        return Note;
    }





}
