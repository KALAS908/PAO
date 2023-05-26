import DataBase.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao252", "root", "hT@5030204374522"))
         {  System.out.println("Conexiunea la baza de date a fost realizata cu succes");DataBase dataBase = new DataBase();
             Statement statement = connection.createStatement();
             statement.execute(dataBase.CreateTablePROFESORI());
             statement.execute(dataBase.CreateTableELEVI());
             statement.execute(dataBase.CreateTableMATERII());
             statement.execute(dataBase.CreateTableNOTE());


        }catch (SQLException e)
            {
                    throw new RuntimeException("Ceva nu a mers bine =(");
            }
    }

}