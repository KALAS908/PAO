import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoala {

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
            System.out.println("Clasa " + entry.getKey() + " este in scoala " + entry.getValue().getScoala());
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
