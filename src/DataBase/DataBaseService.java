package DataBase;
import Audit.Audit;
import Clases.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DataBaseService {

    public Connection conexiune;
    String url = "jdbc:mysql://localhost:3306/pao252";
    String username = "root";
    String password = "hT@5030204374522";
    Audit audit = new Audit();

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
        int id = 0;
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT MAX(profesor_id) AS id FROM PROFESORI";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
               id = resultSet.getInt("id");
            }
        }catch (SQLException e) {
            throw new RuntimeException("Ceva nu a mers bine =(");
        }

        id++;
        System.out.println("Introduceti numele profesorului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele profesorului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti sexul profesorului(F/M)");
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
            audit.logAction("Profesorul" + profesor.getNume() + " " + profesor.getPrenume() + " a fost adaugat cu succes!");
        }
        catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        return "INSERT INTO profesori VALUES ("+profesor.getID()+","+profesor.getNume()+","+profesor.getPrenume()+","+profesor.getVarsta()+","+profesor.getSex()+","+profesor.getScoala()+","+profesor.getSalariu()+","+profesor.getMaterie()+","+profesor.getGrad()+")";

    }

    public void AddElev() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT MAX(elev_id) AS id FROM ELEVI";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        }catch (SQLException e) {
            throw new RuntimeException("Ceva nu a mers bine =(");
        }
        id++;
        System.out.println("Introduceti numele elevului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele elevului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti varsta elevului: ");
        int varsta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti sexul elevului(F/M)");
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
            audit.logAction("Elevul" + elev.getNume() + " " + elev.getPrenume() + " a fost adaugat cu succes!");

        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void AddMaterie() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT MAX(materie_id) AS id FROM MATERII";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        }catch (SQLException e) {
            throw new RuntimeException("Ceva nu a mers bine =(");

        }
        id++;
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
            audit.logAction("Materia" + materie.getNume() + " a fost adaugata cu succes!");

        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void AddNota() {

        Scanner scanner = new Scanner(System.in);
        int id = 0;
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT MAX(nota_id) AS id FROM NOTE";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        }catch (SQLException e) {
            throw new RuntimeException("Ceva nu a mers bine =(");
        }
        id++;
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
            System.out.println("Nota a fost adaugata cu succes!");
            audit.logAction("Nota" + nota1.getNota() + " a fost adaugata cu succes!");
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        } catch (IOException e) {
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
                    audit.logAction("Clasa elevului cu id-ul " + id + " a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
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
                    audit.logAction("Media elevului cu id-ul " + id + " a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
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
                    audit.logAction("Scoala elevului cu id-ul " + id + " a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
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
                    audit.logAction("Scoala profesorului cu id-ul " + id + " a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
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
                    audit.logAction("Salariul profesorului cu id-ul " + id + " a fost modificat cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
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
                    audit.logAction("Materia profesorului cu id-ul " + id + " a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Optiunea nu exista!");
                break;
        }


    }


    public void UpdateNota() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul notei pe care doriti sa o modificati: (Va rugam sa introduceti id-ul notei pe care doriti sa o modificati)");
        int id = scanner.nextInt();
        System.out.println("Ce doriti sa modificati? ");
        System.out.println("1.Elev");
        System.out.println("2.Materia");
        System.out.println("3.Nota");
        int optiune = scanner.nextInt();
        scanner.nextLine();


        switch (optiune) {
            case 1:
                System.out.println("Introduceti noul elev: ");
                String elev = scanner.nextLine();

                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE note SET elev = ? WHERE nota_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, elev);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Elevul a fost modificat cu succes!");
                    audit.logAction("Elevul notei cu id-ul " + id + " a fost modificat cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                System.out.println("Introduceti noua materie: ");
                String materie = scanner.nextLine();
                System.out.println("Introduceti id-ul materiei:(trebuie un id care exista in baza de date)");
                int materie_id = scanner.nextInt();
                scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE note SET materie = ? WHERE nota_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, materie);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    String update2 = "UPDATE note SET materie_id = ? WHERE nota_id = ?";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(update2);
                    preparedStatement2.setInt(1, materie_id);
                    preparedStatement2.setInt(2, id);

                    System.out.println("Materia a fost modificata cu succes!");
                    audit.logAction("Materia notei cu id-ul " + id + " a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                System.out.println("Introduceti noua nota: ");
                double nota = scanner.nextDouble();
                scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE note SET nota = ? WHERE nota_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setDouble(1, nota);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Nota a fost modificata cu succes!");
                    audit.logAction("Nota cu id-ul " + id + " a fost modificata cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Optiunea nu exista!");
                break;
        }
    }


    public void UpdateMaterie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul materiei pe care doriti sa o modificati: ");
        int id = scanner.nextInt();
        System.out.println("Ce doriti sa modificati? ");
        System.out.println("1.Numele materiei");
        System.out.println("2.Id-ul profesorului de curs");
        System.out.println("3.Id-ul profesorului de laborator");
        System.out.println("4.Numarul de credite");
        int optiune = scanner.nextInt();
        scanner.nextLine();

        switch (optiune)
        {

            case 1:
                System.out.println("Introduceti noul nume al materiei: ");
                String nume = scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE materii SET nume = ? WHERE materie_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, nume);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Numele materiei a fost modificat cu succes!");
                    audit.logAction("Numele materiei cu id-ul " + id + " a fost modificat cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                System.out.println("Introduceti id-ul  noul profesoror de curs: ");
                String profesor = scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE materii SET profesor_curs_id = ? WHERE materie_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, profesor);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Profesorul a fost modificat cu succes!");
                    audit.logAction("Profesorul de curs al materiei cu id-ul " + id + " a fost modificat cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                System.out.println("Introduceti id-ul noului profesor de laborator: ");
                String profesor2 = scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE materii SET profesor_laborator_id = ? WHERE materie_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setString(1, profesor2);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Profesorul a fost modificat cu succes!");
                    audit.logAction("Profesorul de laborator al materiei cu id-ul " + id + " a fost modificat cu succes!");

                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

            case 4:
                System.out.println("Introduceti noul numar de credite: ");
                int credite = scanner.nextInt();
                scanner.nextLine();
                try (Connection connection = DriverManager.getConnection(url, username, password)) {
                    String update = "UPDATE materii SET credite = ? WHERE materie_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setInt(1, credite);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();
                    System.out.println("Numarul de credite a fost modificat cu succes!");
                    audit.logAction("Numarul de credite al materiei cu id-ul " + id + " a fost modificat cu succes!");
                } catch (SQLException e) {
                    System.out.println("Ceva nu a mers bine =(");
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Optiunea nu exista!");
                break;

        }
    }



    public void DeleteProfesor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul profesorului pe care doriti sa il stergeti: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String delete = "DELETE FROM profesori WHERE profesor_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Profesorul a fost sters cu succes!");
            audit.logAction("Profesorul cu id-ul " + id + " a fost sters cu succes!");
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void DeleteElev()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul elevului pe care doriti sa il stergeti: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String delete = "DELETE FROM elevi WHERE elev_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Elevul a fost sters cu succes!");
            audit.logAction("Elevul cu id-ul " + id + " a fost sters cu succes!");
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void DeleteMaterie()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul materiei pe care doriti sa o stergeti: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String delete = "DELETE FROM materii WHERE materie_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Materia a fost stearsa cu succes!");
            audit.logAction("Materia cu id-ul " + id + " a fost stearsa cu succes!");
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void DeleteNota()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul notei pe care doriti sa o stergeti: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String delete = "DELETE FROM note WHERE nota_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Nota a fost stearsa cu succes!");
            audit.logAction("Nota cu id-ul " + id + " a fost stearsa cu succes!");
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void AfisareProfesori()
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String select = "SELECT * FROM profesori";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                int id = resultSet.getInt("profesor_id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                System.out.println("Id: " + id + " Nume: " + nume + " Prenume: " + prenume);

            }
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public void AfisareElevi()
    {   try (Connection connection = DriverManager.getConnection(url, username, password)) {
        String select = "SELECT * FROM elevi";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        while (resultSet.next()) {
            int id = resultSet.getInt("elev_id");
            String nume = resultSet.getString("nume");
            String prenume = resultSet.getString("prenume");
            System.out.println("Id: " + id + " Nume: " + nume + " Prenume: " + prenume);

        }
    } catch (SQLException e) {
        System.out.println("Ceva nu a mers bine =(");
        throw new RuntimeException(e);
    }
        System.out.println();
    }



    public void AfisareNote()
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String select = "SELECT * FROM note";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                int id = resultSet.getInt("nota_id");
                int nota = resultSet.getInt("nota");
                int elev_id = resultSet.getInt("elev_id");
                int materie_id = resultSet.getInt("materie_id");
                System.out.println("Id: " + id + " Nota: " + nota + " Elev_id: " + elev_id + " Materie_id: " + materie_id);

            }
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        }

    }

    public void AfisareMaterii()
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String select = "SELECT * FROM materii";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                int id = resultSet.getInt("materie_id");
                String nume = resultSet.getString("nume");
                System.out.println("Id: " + id + " Nume: " + nume);

            }
        } catch (SQLException e) {
            System.out.println("Ceva nu a mers bine =(");
            throw new RuntimeException(e);
        }
        System.out.println();
    }


    public void Menu()
    {
        int ok = 1;
        while(ok==1)
        {Scanner scanner = new Scanner(System.in);
        System.out.println("Ce doriti sa faceti?");
        System.out.println("1.Adaugati in database");
        System.out.println("2.Modificati in database");
        System.out.println("3.Stergeti din database");
        System.out.println("4.Afisati din database");
        System.out.println("5.Iesiti din program");



        int optiune = scanner.nextInt();
        scanner.nextLine();
        switch (optiune)
        {

            case 1:
                System.out.println("Ce doriti sa adaugati?");
                System.out.println("1.Profesor");
                System.out.println("2.Elev");
                System.out.println("3.Materie");
                System.out.println("4.Nota");
                int optiune1 = scanner.nextInt();
                scanner.nextLine();
                switch (optiune1)
                {
                    case 1:
                        AddProfesor();
                        break;
                    case 2:
                        AddElev();
                        break;
                    case 3:
                        AddMaterie();
                        break;
                    case 4:
                        AddNota();
                        break;
                    default:
                        System.out.println("Optiunea nu exista!");
                        break;
                }
                break;
            case 2:
                System.out.println("Ce doriti sa modificati?");
                System.out.println("1.Profesor");
                System.out.println("2.Elev");
                System.out.println("3.Materie");
                System.out.println("4.Nota");
                int optiune2 = scanner.nextInt();
                scanner.nextLine();
                switch (optiune2)
                {
                    case 1:
                        UpdateProfesor();
                        break;
                    case 2:
                        UpdateElev();
                        break;
                    case 3:
                        UpdateMaterie();
                        break;
                    case 4:
                        UpdateNota();
                        break;
                    default:
                        System.out.println("Optiunea nu exista!");
                        break;
                }
                break;
            case 3:
                System.out.println("Ce doriti sa stergeti?");
                System.out.println("1.Profesor");
                System.out.println("2.Elev");
                System.out.println("3.Materie");
                System.out.println("4.Nota");
                int optiune3 = scanner.nextInt();
                scanner.nextLine();
                switch (optiune3)
                {
                    case 1:
                        DeleteProfesor();
                        break;
                    case 2:
                        DeleteElev();
                        break;
                    case 3:
                        DeleteMaterie();
                        break;
                    case 4:
                        DeleteNota();
                        break;
                    default:
                        System.out.println("Optiunea nu exista!");
                        break;
                }
                break;
                case 4:
                System.out.println("Ce doriti sa afisati?");
                System.out.println("1.Profesor");
                System.out.println("2.Elev");
                System.out.println("3.Materie");
                System.out.println("4.Nota");
                int optiune4 = scanner.nextInt();
                scanner.nextLine();
                switch (optiune4)
                {
                    case 1:
                        AfisareProfesori();
                        break;
                    case 2: AfisareElevi();
                        break;
                    case 3:
                        AfisareMaterii();
                        break;
                    case 4:
                        AfisareNote();
                        break;
                    default:
                        System.out.println("Optiunea nu exista!");
                        break;
                }
                break;
            case 5:
                ok=0;
                break;
            default:
                System.out.println("Optiunea nu exista!");
                break;
        }

        }

    }

}

