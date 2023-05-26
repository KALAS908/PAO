//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Clases.*;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class Service {
   public Scoala scoala;

    Service() {
        System.out.println("Bine ati venit la un sistem de gestiune a unei scoli!");
        System.out.println("Va rugam sa introduceti numele scolii: ");
        Scanner scanner = new Scanner(System.in);
        String numeScoala = scanner.nextLine();
        this.scoala = new Scoala(numeScoala);
        Profesor Tudor = new Profesor(1,"Haulica", "Tudor", 20, "M", "LMK", 30000.0, "Matematica", 1);
        Profesor Andrei = new Profesor(2,"Popescu", "Andrei", 30, "M", "LMK", 30000.0, "Istorie", 1);
        Profesor Cosmin = new Profesor(3,"Popa", "Cosmin", 30, "M", "LMK", 30000.0, "Romana", 1);
        Profesor profesor1 = new Profesor(4,"Hrincu", "Ion", 35, "M", "LMK", 5000.0, "Matematica", 2);
        Profesor profesor2 = new Profesor(5,"Ionescu", "Maria", 28, "F", "LMK", 5500.0, "Fizica", 1);
        Profesor profesor3 = new Profesor(6,"Vasilescu", "Alexandru", 42, "M", "LMK", 6000.0, "Istorie", 3);
        Profesor profesor4 = new Profesor(7,"Georgescu", "Andreea", 31, "F", "LMK", 4500.0, "Limba Engleza", 2);
        Profesor profesor5 = new Profesor(8,"Mandache", "Mihai", 39, "M", "LMK", 5500.0, "Chimie", 3);
        Profesor profesor6 = new Profesor(9,"Dumitrescu", "Ana", 27, "F", "LMK", 4000.0, "Informatica", 1);
        Materie Matematica = new Materie(1,"Matematica", 5, Tudor, profesor1);
        Materie Istorie = new Materie(2,"Istorie", 4, Andrei, profesor3);
        Materie Romana = new Materie(3,"Romana", 4, Cosmin, Cosmin);
        Materie Fizica = new Materie(4,"Fizica", 4, profesor2, profesor2);
        Materie Chimie = new Materie(5,"Chimie", 4, profesor5, profesor5);
        Materie Informatica = new Materie(6,"Informatica", 4, profesor6, profesor6);
        this.scoala.adaugaProfesor(Tudor);
        this.scoala.adaugaProfesor(Andrei);
        this.scoala.adaugaProfesor(Cosmin);
        this.scoala.adaugaProfesor(profesor1);
        this.scoala.adaugaProfesor(profesor2);
        this.scoala.adaugaProfesor(profesor3);
        this.scoala.adaugaProfesor(profesor4);
        this.scoala.adaugaProfesor(profesor5);
        this.scoala.adaugaProfesor(profesor6);
        this.scoala.adaugaMaterie(Matematica);
        this.scoala.adaugaMaterie(Istorie);
        this.scoala.adaugaMaterie(Romana);
        this.scoala.adaugaMaterie(Fizica);
        this.scoala.adaugaMaterie(Chimie);
        this.scoala.adaugaMaterie(Informatica);
    }

    public void afisareClase() {
        Iterator var1 = this.scoala.clase.entrySet().iterator();

        while(var1.hasNext()) {
            Map.Entry<String, Clasa> entry = (Map.Entry)var1.next();
            PrintStream var10000 = System.out;
            String var10001 = (String)entry.getKey();
            var10000.println("Clasa " + var10001 + " este in scoala " + ((Clasa)entry.getValue()).getScoala());
            ((Clasa)entry.getValue()).afisareDiriginte();
            ((Clasa)entry.getValue()).afisareElevi();
        }

        System.out.println("============Aici se termina afisarea claselor============");
        System.out.println("\n");
    }

    public void afisareMaterii() {
        System.out.println("La scoala " + this.scoala.getNumeScoala() + " sunt urmatoarele materii: ");
        Iterator var1 = this.scoala.materii.iterator();

        while(var1.hasNext()) {
            Materie materie = (Materie)var1.next();
            PrintStream var10000 = System.out;
            String var10001 = materie.getNume();
            var10000.println("Materia " + var10001 + " este predata de " + materie.getProfesorCurs().getNume() + " " + materie.getProfesorCurs().getPrenume());
        }

        System.out.println("============Aici se termina afisarea materiilor============");
        System.out.println("\n");
    }

    public void afisareProfesori() {
        System.out.println("La scoala " + this.scoala.getNumeScoala() + " sunt urmatorii profesori: ");
        Iterator var1 = this.scoala.profesori.entrySet().iterator();

        while(var1.hasNext()) {
            Map.Entry<String, Profesor> entry = (Map.Entry)var1.next();
            PrintStream var10000 = System.out;
            String var10001 = (String)entry.getKey();
            var10000.println("Profesorul " + var10001 + " " + ((Profesor)entry.getValue()).getPrenume());
        }

        System.out.println("============Aici se termina afisarea profesorilor============");
        System.out.println("\n");
    }

    public void afisareClasa(String numeClasa) {
        Clasa clasa = (Clasa)this.scoala.clase.get(numeClasa);
        PrintStream var10000 = System.out;
        String var10001 = clasa.getNumeClasa();
        var10000.println("Clasa " + var10001 + " este in scoala " + clasa.getScoala());
        clasa.afisareDiriginte();
        clasa.afisareElevi();
        System.out.println("============Aici se termina afisarea clasei============");
        System.out.println("\n");
    }

    public void afisareMaterie(String numeMaterie) {
        Iterator var2 = this.scoala.materii.iterator();

        while(var2.hasNext()) {
            Materie materie = (Materie)var2.next();
            if (materie.getNume().equals(numeMaterie)) {
                PrintStream var10000 = System.out;
                String var10001 = materie.getNume();
                var10000.println("Materia " + var10001 + " este predata de " + materie.getProfesorCurs().getNume() + " " + materie.getProfesorCurs().getPrenume());
            }
        }

        System.out.println("============Aici se termina afisarea Materiei============");
        System.out.println("\n");
    }

    public void afisareProfesor(String numeProfesor) {
        Profesor profesor = (Profesor)this.scoala.profesori.get(numeProfesor);
        PrintStream var10000 = System.out;
        String var10001 = profesor.getNume();
        var10000.println("Profesorul " + var10001 + " " + profesor.getPrenume());
    }

    public void afisareElev(String numeElev) {
        Iterator var2 = this.scoala.clase.entrySet().iterator();

        while(var2.hasNext()) {
            Map.Entry<String, Clasa> entry = (Map.Entry)var2.next();
            Iterator var4 = ((Clasa) entry.getValue()).getElevi().iterator();

            while(var4.hasNext()) {
                Elev elev = (Elev)var4.next();
                if (elev.getNume().equals(numeElev)) {
                    elev.toString();
                }
            }
        }

        System.out.println("============Aici se termina afisarea Elevului============");
        System.out.println("\n");
    }

    public void adaugaClasa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele clasei: ");
        String numeClasa = scanner.nextLine();
        System.out.println("Introduceti numele Dirigintelui: ");
        String numeProfesor = scanner.nextLine();
        if (this.scoala.getProfesori().containsKey(numeProfesor)) {
            Profesor profesor = (Profesor)this.scoala.getProfesori().get(numeProfesor);
            Diriginte diriginte = new Diriginte(profesor, numeClasa);
            Clasa clasa = new Clasa(numeClasa, this.scoala.getNumeScoala(), diriginte);
            this.scoala.clase.put(numeClasa, clasa);
            System.out.println("Clasa a fost adaugata cu succes!");
        } else {
            System.out.println("Profesorul nu exista!");
            System.out.println("Incercati din nou cu un profesor existent sau adaugati profesorul dorit!");
        }

    }

    public void adaugaProfesor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele profesorului: ");
        String numeProfesor = scanner.nextLine();
        System.out.println("Introduceti prenumele profesorului: ");
        String prenumeProfesor = scanner.nextLine();
        System.out.println("Introduceti varsta profesorului: ");
        int varstaProfesor = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti genul profesorului:(M/F) ");
        String genProfesor = scanner.nextLine();
        String numeSc = this.scoala.getNumeScoala();
        System.out.println("Introduceti salariul profesorului: ");
        int salariuProfesor = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti materia pe care o preda profesorul: ");
        String materieProfesor = scanner.nextLine();
        System.out.println("Introducet gradul profesorului: ");
        int gradProfesor = scanner.nextInt();
        Profesor profesor = new Profesor(100,numeProfesor, prenumeProfesor, varstaProfesor, genProfesor, numeSc, (double)salariuProfesor, materieProfesor, gradProfesor);
        this.scoala.adaugaProfesor(profesor);
        System.out.println("Profesorul a fost adaugat cu succes!");
    }

    public void adaugaMaterie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti id-ul materiei: ");
        int idMaterie = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti numele materiei: ");
        String numeMaterie = scanner.nextLine();
        System.out.println("Intorduceti numarul de credite: ");
        int nrCredite = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceti numele profesorului de curs: ");
        String numeProfesorCurs = scanner.nextLine();
        System.out.println("Introduceti numele profesorului de laborator: ");
        String numeProfesorLab = scanner.nextLine();
        if (this.scoala.getProfesori().containsKey(numeProfesorCurs) && this.scoala.getProfesori().containsKey(numeProfesorLab)) {
            Profesor profesor = (Profesor)this.scoala.getProfesori().get(numeProfesorCurs);
            Profesor profesor1 = (Profesor)this.scoala.getProfesori().get(numeProfesorLab);
            Materie materie = new Materie(idMaterie,numeMaterie, nrCredite, profesor, profesor1);
            this.scoala.adaugaMaterie(materie);
            System.out.println("Materia a fost adaugata cu succes!");
        } else {
            System.out.println("Profesorul nu exista!");
            System.out.println("Incercati din nou cu un profesor existent sau adaugati profesorul dorit!");
        }

    }

    public void ModClasa(Clasa clasa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alegeti o optiune: ");
        System.out.println("1. Adaugati un elev");
        System.out.println("2. Stergeti un elev");
        System.out.println("3.Afisati toti elevii");
        System.out.println("4.Afisati datele unui elev dupa nume");
        System.out.println("5.Afisati Dirigintele si datele acestuia");
        System.out.println("6.Adaugati nota unui elev");
        System.out.println("7.Iesire");
        int optiune = scanner.nextInt();
        scanner.nextLine();
        switch (optiune) {
            case 1:
                System.out.println("Introduceti numele elevului: ");
                String numeElev = scanner.nextLine();
                System.out.println("Introduceti prenumele elevului: ");
                String prenumeElev = scanner.nextLine();
                System.out.println("Introduceti varsta elevului: ");
                int varstaElev = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Introduceti genul elevului:(M/F) ");
                String genElev = scanner.nextLine();
                String numeSc = this.scoala.getNumeScoala();
                Elev elev = new Elev(100,numeElev, prenumeElev, varstaElev, genElev, clasa.getNumeClasa(), numeSc);
                clasa.adaugaElev(elev);
                System.out.println("Elevul a fost adaugat cu succes!");
                break;
            case 2:
                System.out.println("Introduceti numele elevului: ");
                String numeElev3 = scanner.nextLine();
                clasa.stergereElev(numeElev3);
                System.out.println("Elevul a fost sters cu succes!\n");
                break;
            case 3:
                clasa.afisareElevi();
                break;
            case 4:
                boolean ok = false;
                System.out.println("Introduceti numele elevului: ");
                String numeElev1 = scanner.nextLine();
                Iterator var19 = clasa.getElevi().iterator();

                while(var19.hasNext()) {
                    Elev elev1 = (Elev)var19.next();
                    if (elev1.getNume().equals(numeElev1)) {
                        elev1.toString();
                        ok = true;
                    }
                }

                if (!ok) {
                    System.out.println("Elevul nu exista!");
                }
                break;
            case 5:
                clasa.getDiriginte().toString();
                break;
            case 6:
                boolean ok1 = false;
                System.out.println("Introduceti numele elevului: ");
                String numeElev2 = scanner.nextLine();
                System.out.println("Introduceti nota elevului: ");
                int notaElev = scanner.nextInt();
                System.out.println("Introduceti materia la care a fost notat elevul: ");
                String materieElev = scanner.nextLine();
                Iterator var17 = clasa.getElevi().iterator();

                while(var17.hasNext()) {
                    Elev elev2 = (Elev)var17.next();
                    if (elev2.getNume().equals(numeElev2)) {
                        elev2.adaugaNota(new Nota((double)notaElev, materieElev));
                        ok1 = true;
                        System.out.println("Nota a fost adaugata cu succes\n!");
                    }
                }

                if (!ok1) {
                    System.out.println("Elevul nu exista\n!");
                }
                break;
            case 7:
                System.out.println("Iesire din meniu modificari clase\n!");
        }

    }

    public void run() {
        while(true) {
            System.out.println("Alegeti o optiune: ");
            System.out.println("1. Adaugati o clasa");
            System.out.println("2. Adaugati un profesor");
            System.out.println("3. Adaugati o materie");
            System.out.println("4. Afisati clasele");
            System.out.println("5. Afisati profesorii");
            System.out.println("6. Afisati materiile");
            System.out.println("7. Actiuni asupra unei clase");
            System.out.println("8. Iesire");
            Scanner scanner = new Scanner(System.in);
            int optiune = scanner.nextInt();
            scanner.nextLine();
            switch (optiune) {
                case 1:
                    this.adaugaClasa();
                    break;
                case 2:
                    this.adaugaProfesor();
                    break;
                case 3:
                    this.adaugaMaterie();
                    break;
                case 4:
                    this.afisareClase();
                    break;
                case 5:
                    this.afisareProfesori();
                    break;
                case 6:
                    this.afisareMaterii();
                    break;
                case 7:
                    System.out.println("Introduceti numele clasei: ");
                    String numeClasa = scanner.nextLine();
                    if (this.scoala.clase.containsKey(numeClasa)) {
                        Clasa clasa = (Clasa)this.scoala.clase.get(numeClasa);
                        this.ModClasa(clasa);
                        break;
                    }

                    System.out.println("Clasa nu exista!");
                    System.out.println("Incercati din nou cu o clasa existenta sau adaugati clasa dorita!");
                    break;
                case 8:
                    System.out.println("La revedere!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }
}
