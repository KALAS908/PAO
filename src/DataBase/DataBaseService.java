package DataBase;


import Clases.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DataBaseService {

    public Connection conexiune;
    String url = "jdbc:mysql://localhost:3306/pao252";
    String username = "root";
    String password = "hT@5030204374522";

    List<Profesor> profesori = new ArrayList<Profesor>();
    List<Elev> elevi = new ArrayList<Elev>();
    List<Clasa> clase = new ArrayList<Clasa>();
    List<Materie> materii = new ArrayList<Materie>();
    List<Nota> note = new ArrayList<Nota>();
    DataBase dataBase = new DataBase();


    public void CreareConexiune() {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexiunea la baza de date a fost realizata cu succes");

            Statement statement = connection.createStatement();
            statement.execute(dataBase.CreateTablePROFESORI());
            statement.execute(dataBase.CreateTableELEVI());
            statement.execute(dataBase.CreateTableMATERII());
            statement.execute(dataBase.CreateTableNOTE());

        } catch (SQLException e) {
            throw new RuntimeException("Ceva nu a mers bine =(");
        }


    }


    public void AddProfesor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul profesorului: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti numele profesorului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele profesorului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti sexul profesorului(S/M)");
        String sex = scanner.nextLine();
        System.out.println("Introduceti varsta profesorului: ");
        int varsta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti scoala profesorului: ");
        String scoala = scanner.nextLine();
        System.out.println("Introduceti salariul profesorului: ");
        double salariu = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Introduceti materia profesorului: ");
        String materie = scanner.nextLine();
        System.out.println("Introduceti gradul profesorului: ");
        int grad = scanner.nextInt();
        scanner.nextLine();

        Profesor profesor = new Profesor(id, nume, prenume, varsta, sex, scoala, salariu, materie, grad);
        profesori.add(profesor);

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insert = "INSERT INTO profesori (profesor_id, nume, prenume,varsta,sex,scoala,salariu,materie,grad) VALUES(? , ? , ? , ? , ? , ? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, profesor.getID());
            preparedStatement.setString(2, profesor.getNume());
            preparedStatement.setString(3, profesor.getPrenume());
            preparedStatement.setInt(4, profesor.getVarsta());
            preparedStatement.setString(5, profesor.getSex());
            preparedStatement.setString(6, profesor.getScoala());
            preparedStatement.setDouble(7, profesor.getSalariu());
            preparedStatement.setString(8, profesor.getMaterie());
            preparedStatement.setInt(9, profesor.getGrad());
            preparedStatement.executeUpdate();
            System.out.println("Profesorul a fost adaugat cu succes!");

        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        }


//        return "INSERT INTO profesori VALUES ("+profesor.getID()+","+profesor.getNume()+","+profesor.getPrenume()+","+profesor.getVarsta()+","+profesor.getSex()+","+profesor.getScoala()+","+profesor.getSalariu()+","+profesor.getMaterie()+","+profesor.getGrad()+")";

    }

    public void AddElev() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul elevului: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti numele elevului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele elevului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti varsta elevului: ");
        int varsta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti sexul elevului(S/M)");
        String sex = scanner.nextLine();
        System.out.println("Introduceti clasa elevului: ");
        String clasa = scanner.nextLine();
        System.out.println("Introduceti media elevului: ");
        double medie = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Introduceti scoala elevului: ");
        String scoala = scanner.nextLine();

        Elev elev = new Elev(id, nume, prenume, varsta, sex, clasa, scoala, medie);
        elevi.add(elev);
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insert = "INSERT INTO elevi(elev_id,nume,prenume,varsta,sex,scoala,clasa,medie) VALUES(? , ? , ? , ? , ? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, elev.getId());
            preparedStatement.setString(2, elev.getNume());
            preparedStatement.setString(3, elev.getPrenume());
            preparedStatement.setInt(4, elev.getVarsta());
            preparedStatement.setString(5, elev.getSex());
            preparedStatement.setString(6, elev.getScoala());
            preparedStatement.setString(7, elev.getClasa());
            preparedStatement.setDouble(8, elev.getMedie());
            preparedStatement.executeUpdate();
            System.out.println("Elevul a fost adaugat cu succes!");

        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        }
    }


    public void AddMaterie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul materiei: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti numele materiei: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti numarul de credite: ");
        int credite = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introdceti id-ul profesorul de curs: ");
        int id_profesor_curs = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introdceti id-ul profesorul de laborator: ");
        int id_profesor_lab = scanner.nextInt();
        scanner.nextLine();

        Materie materie = new Materie(id, nume, credite, id_profesor_curs, id_profesor_lab);
        materii.add(materie);
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insert = "INSERT INTO materii(materie_id,nume,credite,profesor_curs_id,profesor_laborator_id) VALUES(? , ? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, materie.getId());
            preparedStatement.setString(2, materie.getNume());
            preparedStatement.setInt(3, materie.getNrCredite());
            preparedStatement.setInt(4, materie.getIdProfesorCurs());
            preparedStatement.setInt(5, materie.getIdProfesorLaborator());
            preparedStatement.executeUpdate();
            System.out.println("Materia a fost adaugata cu succes!");

        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        }
    }


    public void AddNota() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul notei: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti id-ul elevului: ");
        int id_elev = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti id-ul materiei: ");
        int id_materie = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti nota: ");
        double nota = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti numele materiei: ");
        String nume_materie = scanner.nextLine();


        Nota nota1 = new Nota(id, id_elev, id_materie, nota, nume_materie);
        note.add(nota1);


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String insert = "INSERT INTO note(nota_id,elev_id,materie_id,materie,nota) VALUES(? , ? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, nota1.getId());
            preparedStatement.setInt(2, nota1.getIdElev());
            preparedStatement.setInt(3, nota1.getIdMaterie());
            preparedStatement.setString(4, nota1.getMaterie());
            preparedStatement.setDouble(5, nota1.getNota());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        }


    }


    public void UpdateElev() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul elevului pe care doriti sa-l modificati: ");
        int id = scanner.nextInt();
        System.out.println("Ce doriti sa modificati? ");
        System.out.println("1.Clasa");
        System.out.println("2.Media");
        System.out.println("3.Scoala");
        int optiune = scanner.nextInt();
        scanner.nextLine();

        switch (optiune) {
            case 1:
                System.out.println("Introduceti noua clasa: ");
                String clasa = scanner.nextLine();

                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE elevi SET clasa = ? WHERE elev_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, clasa);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Clasa a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                System.out.println("Introduceti noua medie: ");
                double medie = scanner.nextDouble();
                scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE elevi SET medie = ? WHERE elev_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setDouble(1, medie);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Media a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                System.out.println("Introduceti noua scoala: ");
                String scoala = scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE elevi SET scoala = ? WHERE elev_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, scoala);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Scoala a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Optiunea nu exista!");
                break;
        }


    }


    public void UpdateProfesor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul profesorului pe care doriti sa-l modificati: ");
        int id = scanner.nextInt();
        System.out.println("Ce doriti sa modificati? ");
        System.out.println("1.Scoala");
        System.out.println("2.Salariul");
        System.out.println("3.Materia");
        int optiune = scanner.nextInt();
        scanner.nextLine();


        switch (optiune) {
            case 1:
                System.out.println("Introduceti noua scoala: ");
                String scoala = scanner.nextLine();

                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE profesori SET scoala = ? WHERE profesor_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, scoala);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Scoala a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                System.out.println("Introduceti noul salariu: ");
                double salariu = scanner.nextDouble();
                scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE profesori SET salariu = ? WHERE profesor_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setDouble(1, salariu);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Salariul a fost modificat cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                System.out.println("Introduceti noua materie: ");
                String materie = scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE profesori SET materie = ? WHERE profesor_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, materie);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Materia a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Optiunea nu exista!");
                break;
        }


    }
}

