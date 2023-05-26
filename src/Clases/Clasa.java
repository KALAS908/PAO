package Clases;

import java.util.*;

public class Clasa {

    List<Elev> elevi = new ArrayList<Elev>();
    String numeClasa;
    String scoala;
    Diriginte diriginte;
    int nrElevi = 0;

    public Clasa(String numeClasa, String scoala , Diriginte diriginte) {
        this.numeClasa = numeClasa;
        this.scoala = scoala;
        this.diriginte = diriginte;
    }


public void adaugaElev(Elev elev) {
        elevi.add(elev);
        nrElevi++;
        elevi.sort((o1, o2) -> o1.getNume().compareTo(o2.getNume()));
    }

    public String getNumeClasa() {
        return numeClasa;
    }

    public void setNumeClasa(String numeClasa) {
        this.numeClasa = numeClasa;
    }

    public String getScoala() {
        return scoala;
    }

    public void setScoala(String scoala) {
        this.scoala = scoala;
    }

    public int getNrElevi() {
        return nrElevi;
    }

    public void setNrElevi(int nrElevi) {
        this.nrElevi = nrElevi;
    }

    public Diriginte getDiriginte() {
        return diriginte;
    }

    public void setDiriginte(Diriginte diriginte) {
        this.diriginte = diriginte;
    }


    public List<Elev> getElevi() {
        return elevi;
    }
   public void afisareDiriginte() {
            System.out.println("Dirigintele clasei " + this.numeClasa + " este: " + this.diriginte.getNume() + " " + this.diriginte.getPrenume());
            this.diriginte.toString();
        }

  public void afisareElevi()
  {
      System.out.println("Elevii clasei " + this.numeClasa + " sunt: ");
        for (Elev elev : elevi) {
            elev.toString();
        }
        System.out.println ("==================AM TERMINAT AFISAREA ELEVILOR DIN CLASA ===================================");
  }


  public void stergereElev(String nume )
  {
        for (Elev elev : elevi) {
            if (elev.getNume().equals(nume))
            {
                elevi.remove(elev);
                nrElevi--;
                break;
            }
        }
  }
  public void adaugaProfesor()
  {
      Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele profesorului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele profesorului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti varsta profesorului: ");
        int varsta = scanner.nextInt();
        System.out.println("Introduceti sexul profesorului:(M/F)");



  }

   public void afisareClasa() {
        System.out.println("=====================================================");
        System.out.println("Nume clasa: " + this.numeClasa);
        System.out.println("Clases.Clasa.Scoala: " + this.scoala);
        System.out.println("Nr elevi: " + this.nrElevi);
        System.out.println("Clases.Diriginte: " + this.diriginte.getNume() + " " + this.diriginte.getPrenume());
        System.out.println("=====================================================");
    }

    public  abstract static class  Persoana {

        protected String nume;
        protected String prenume;
        protected int varsta;
        protected String sex;
        int id;

        public Persoana(int id ,String nume, String prenume, int varsta, String sex) {
            this.id = id;
            this.nume = nume;
            this.prenume = prenume;
            this.varsta = varsta;
            this.sex = sex;
        }

        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public int getVarsta() {
            return varsta;
        }

        public void setVarsta(int varsta) {
            this.varsta = varsta;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPrenume() {
            return prenume;
        }

        public void setPrenume(String prenume) {
            this.prenume = prenume;
        }

        ///abstract  void afisare();
        public abstract String toString();

    }

    public static class Scoala {

        Map <String, Clasa> clase = new HashMap<String, Clasa>();
        List <Materie> materii = new ArrayList<Materie>();
        Map <String, Profesor> profesori = new HashMap<String, Profesor>();
        String numeScoala;

        public Scoala(String numeScoala) {
            this.numeScoala = numeScoala;
        }

        public void adaugaClasa(Clasa clasa) {
            clase.put(clasa.getNumeClasa(), clasa);
        }

        public void afisareClase() {
            for (Map.Entry<String, Clasa> entry : clase.entrySet()) {
                System.out.println("Clases.Clasa " + entry.getKey() + " este in scoala " + entry.getValue().getScoala());
                entry.getValue().afisareDiriginte();
                entry.getValue().afisareElevi();
            }
        }

        public void adaugaMaterie(Materie materie) {
            materii.add(materie);
        }

        public void afisareMaterii() {

            System.out.println("La scoala " + this.numeScoala + " sunt urmatoarele materii: ");
            for (Materie materie : materii) {
                System.out.println("Materia " + materie.getNume() + " este predata de " + materie.getProfesorCurs().getNume() + " " + materie.getProfesorCurs().getPrenume());
            }
        }
        public void adaugaProfesor(Profesor profesor) {
            profesori.put(profesor.getNume(), profesor);
        }

        public String getNumeScoala() {
            return numeScoala;
        }

        public void setNumeScoala(String numeScoala) {
            this.numeScoala = numeScoala;
        }

        public Map<String, Clasa> getClase() {
            return clase;
        }
        public void setClase(Map<String, Clasa> clase) {
            this.clase = clase;
        }
        public List<Materie> getMaterii() {
            return materii;
        }
        public void setMaterii(List<Materie> materii) {
            this.materii = materii;
        }
        public Map<String, Profesor> getProfesori() {
            return profesori;
        }

    }

    public static class Service {

        Scoala scoala;
        Service(){
            System.out.println("Bine ati venit la un sistem de gestiune a unei scoli!");
            System.out.println("Va rugam sa introduceti numele scolii: ");
            Scanner scanner = new Scanner(System.in);
            String numeScoala = scanner.nextLine();
            scoala = new Scoala(numeScoala);

            Profesor Tudor = new Profesor(1,"Haulica" , "Tudor" , 20, "M", "LMK", 30000,"Matematica",1);
            Profesor Andrei = new Profesor(2,"Popescu" , "Andrei" , 30, "M", "LMK", 30000,"Istorie",1);
            Profesor Cosmin = new Profesor(3,"Popa" , "Cosmin" , 30, "M", "LMK", 30000,"Romana",1);
            Profesor profesor1 = new Profesor(4,"Hrincu", "Ion", 35, "M", "LMK", 5000, "Matematica", 2);
            Profesor profesor2 = new Profesor(5,"Ionescu", "Maria", 28, "F", "LMK", 5500, "Fizica", 1);
            Profesor profesor3 = new Profesor(6,"Vasilescu", "Alexandru", 42, "M", "LMK", 6000, "Istorie", 3);
            Profesor profesor4 = new Profesor(7,"Georgescu", "Andreea", 31, "F", "LMK", 4500, "Limba Engleza", 2);
            Profesor profesor5 = new Profesor(8,"Mandache", "Mihai", 39, "M", "LMK", 5500, "Chimie", 3);
            Profesor profesor6 = new Profesor(9,"Dumitrescu", "Ana", 27, "F", "LMK", 4000, "Informatica", 1);


            Materie Matematica = new Materie(1,"Matematica", 5,Tudor, profesor1);
            Materie Istorie = new Materie(2,"Istorie", 4,Andrei, profesor3);
            Materie Romana = new Materie(3,"Romana", 4,Cosmin, Cosmin);
            Materie Fizica = new Materie(4,"Fizica", 4,profesor2, profesor2);
            Materie Chimie = new Materie(5,"Chimie", 4,profesor5, profesor5);
            Materie Informatica = new Materie(6,"Informatica", 4,profesor6, profesor6);


            scoala.adaugaProfesor(Tudor);
            scoala.adaugaProfesor(Andrei);
            scoala.adaugaProfesor(Cosmin);
            scoala.adaugaProfesor(profesor1);
            scoala.adaugaProfesor(profesor2);
            scoala.adaugaProfesor(profesor3);
            scoala.adaugaProfesor(profesor4);
            scoala.adaugaProfesor(profesor5);
            scoala.adaugaProfesor(profesor6);

            scoala.adaugaMaterie(Matematica);
            scoala.adaugaMaterie(Istorie);
            scoala.adaugaMaterie(Romana);
            scoala.adaugaMaterie(Fizica);
            scoala.adaugaMaterie(Chimie);
            scoala.adaugaMaterie(Informatica);

        }




        public void afisareClase() {
            for (Map.Entry<String, Clasa> entry : scoala.clase.entrySet()) {
                System.out.println("Clases.Clasa " + entry.getKey() + " este in scoala " + entry.getValue().getScoala());
                entry.getValue().afisareDiriginte();
                entry.getValue().afisareElevi();
            }

            System.out.println("============Aici se termina afisarea claselor============");
            System.out.println("\n");
        }

        public void afisareMaterii() {
            System.out.println("La scoala " + scoala.getNumeScoala() + " sunt urmatoarele materii: ");
            for (Materie materie : scoala.materii) {
                System.out.println("Materia " + materie.getNume() + " este predata de " + materie.getProfesorCurs().getNume() + " " + materie.getProfesorCurs().getPrenume());
            }

            System.out.println("============Aici se termina afisarea materiilor============");
            System.out.println("\n");
        }

        public void afisareProfesori() {
            System.out.println("La scoala " + scoala.getNumeScoala() + " sunt urmatorii profesori: ");
            for (Map.Entry<String, Profesor> entry : scoala.profesori.entrySet()) {
                System.out.println("Profesorul " + entry.getKey() + " " + entry.getValue().getPrenume());
            }

            System.out.println("============Aici se termina afisarea profesorilor============");
            System.out.println("\n");
        }


        public void afisareClasa(String numeClasa) {
            Clasa clasa = scoala.clase.get(numeClasa);
            System.out.println("Clases.Clasa " + clasa.getNumeClasa() + " este in scoala " + clasa.getScoala());
            clasa.afisareDiriginte();
            clasa.afisareElevi();

            System.out.println("============Aici se termina afisarea clasei============");
            System.out.println("\n");
        }


        public void afisareMaterie(String numeMaterie) {
            for (Materie materie : scoala.materii) {
                if (materie.getNume().equals(numeMaterie)) {
                    System.out.println("Materia " + materie.getNume() + " este predata de " + materie.getProfesorCurs().getNume() + " " + materie.getProfesorCurs().getPrenume());
                }
            }
            System.out.println("============Aici se termina afisarea Materiei============");
            System.out.println("\n");
        }


        public void afisareProfesor(String numeProfesor) {
            Profesor profesor = scoala.profesori.get(numeProfesor);
            System.out.println("Profesorul " + profesor.getNume() + " " + profesor.getPrenume());
        }

        public void afisareElev(String numeElev) {
            for (Map.Entry<String, Clasa> entry : scoala.clase.entrySet()) {
                for (Elev elev : entry.getValue().elevi) {
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

              if (scoala.getProfesori().containsKey(numeProfesor)) {

                  Profesor profesor = scoala.getProfesori().get(numeProfesor);
                  Diriginte diriginte = new Diriginte(profesor, numeClasa);
                  Clasa clasa = new Clasa(numeClasa, scoala.getNumeScoala(), diriginte);
                  scoala.clase.put(numeClasa, clasa);
                  System.out.println("Clases.Clasa a fost adaugata cu succes!");
              }
              else{
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
              String numeSc = scoala.getNumeScoala();
              System.out.println("Introduceti salariul profesorului: ");
              int salariuProfesor = scanner.nextInt();
              scanner.nextLine();
              System.out.println("Introduceti materia pe care o preda profesorul: ");
              String materieProfesor = scanner.nextLine();
              System.out.println("Introducet gradul profesorului: ");
              int gradProfesor = scanner.nextInt();

              Profesor profesor = new Profesor(1,numeProfesor, prenumeProfesor, varstaProfesor, genProfesor, numeSc, salariuProfesor, materieProfesor, gradProfesor);
              scoala.adaugaProfesor(profesor);
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

                if (scoala.getProfesori().containsKey(numeProfesorCurs) && scoala.getProfesori().containsKey(numeProfesorLab)){
                    Profesor profesor = scoala.getProfesori().get(numeProfesorCurs);
                    Profesor profesor1 = scoala.getProfesori().get(numeProfesorLab);
                    Materie materie = new Materie(idMaterie,numeMaterie, nrCredite, profesor, profesor1);
                    scoala.adaugaMaterie(materie);
                    System.out.println("Materia a fost adaugata cu succes!");
                }
                else{
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
                    String numeSc = scoala.getNumeScoala();
                    Elev elev = new Elev(1,numeElev, prenumeElev, varstaElev, genElev,clasa.getNumeClasa(), numeSc);
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
                    int ok = 0;
                    System.out.println("Introduceti numele elevului: ");
                    String numeElev1 = scanner.nextLine();
                    for (Elev elev1 : clasa.getElevi()) {
                        if (elev1.getNume().equals(numeElev1)) {
                           elev1.toString();
                           ok =1;
                        }
                    }
                    if (ok == 0){
                        System.out.println("Elevul nu exista!");
                    }
                    break;
                case 5:
                     clasa.getDiriginte().toString();
                    break;
                case 6:
                    int ok1 = 0;
                    System.out.println("Introduceti numele elevului: ");
                    String numeElev2 = scanner.nextLine();
                    System.out.println("Introduceti nota elevului: ");
                    int notaElev = scanner.nextInt();
                    System.out.println("Introduceti materia la care a fost notat elevul: ");
                    String materieElev = scanner.nextLine();
                    for (Elev elev2 : clasa.getElevi()) {
                        if (elev2.getNume().equals(numeElev2)) {
                            elev2.adaugaNota(new Nota(notaElev, materieElev));
                            ok1 = 1;
                            System.out.println("Clases.Nota a fost adaugata cu succes\n!");
                        }

                    }
                      if (ok1 == 0) {
                          System.out.println("Elevul nu exista\n!");
                      }
                    break;
                  case 7:
                      System.out.println("Iesire din meniu modificari clase\n!");
                      break;
            }

        }

        public void run()
        {  while (true) {
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
                    adaugaClasa();
                    break;
                case 2:
                    adaugaProfesor();
                    break;
                case 3:
                    adaugaMaterie();
                    break;
                case 4:
                    afisareClase();
                    break;
                case 5:
                    afisareProfesori();
                    break;
                case 6:
                    afisareMaterii();
                    break;
                case 7:
                    System.out.println("Introduceti numele clasei: ");
                    String numeClasa = scanner.nextLine();
                    if (scoala.clase.containsKey(numeClasa)) {
                        Clasa clasa = scoala.clase.get(numeClasa);
                        ModClasa(clasa);
                    }
                    else{
                        System.out.println("Clases.Clasa nu exista!");
                        System.out.println("Incercati din nou cu o clasa existenta sau adaugati clasa dorita!");
                    }
                    break;
                case 8:
                    System.out.println("La revedere!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }


        }


        }


    }
}
