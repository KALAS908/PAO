package DataBase;

import java.util.Scanner;
public class DataBaseService {



    public void AddProfesor()
    {
        Scanner scanner = new Scanner(System.in);
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

    }


    public void AddElev()
    {


    }


    public void AddMaterie()
    {


    }

    public void AddNota()
    {


    }

}
