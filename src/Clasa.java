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
            this.diriginte.afisare();
        }

  public void afisareElevi()
  {
      System.out.println("Elevii clasei " + this.numeClasa + " sunt: ");
        for (Elev elev : elevi) {
            elev.afisare();
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
        System.out.println("Scoala: " + this.scoala);
        System.out.println("Nr elevi: " + this.nrElevi);
        System.out.println("Diriginte: " + this.diriginte.getNume() + " " + this.diriginte.getPrenume());
        System.out.println("=====================================================");
    }
}
