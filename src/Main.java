import DataBase.DataBaseService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DataBaseService dataBaseService = new DataBaseService();
        dataBaseService.CreareConexiune();
//        dataBaseService.AddElev();
//        dataBaseService.AddMaterie();
//        dataBaseService.AddNota();
 //       dataBaseService.UpdateElev();
        dataBaseService.UpdateProfesor();

    }




}