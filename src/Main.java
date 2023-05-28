import DataBase.DataBaseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao252", "root", "hT@5030204374522"))
        {

            System.out.println("Connected to database!");
            DataBaseService dataBaseService = new DataBaseService();
            dataBaseService.Menu();
        }catch ( SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());

        }


    }
}