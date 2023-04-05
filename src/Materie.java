import java.util.Date;

public class Materie {

    String nume;

    int nrCredite;
    Profesor profesorCurs;
    Profesor profesorLaborator;

    public Materie(String nume, int nrCredite, Profesor profesorCurs, Profesor profesorLaborator) {
        this.nume = nume;
        this.nrCredite = nrCredite;
        this.profesorCurs = profesorCurs;
        this.profesorLaborator = profesorLaborator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }


    public int getNrCredite() {
        return nrCredite;
    }

    public void setNrCredite(int nrCredite) {
        this.nrCredite = nrCredite;
    }

    public Profesor getProfesorCurs() {
        return profesorCurs;
    }

    public void setProfesorCurs(Profesor profesorCurs) {
        this.profesorCurs = profesorCurs;
    }

    public Profesor getProfesorLaborator() {
        return profesorLaborator;
    }

    public void setProfesorLaborator(Profesor profesorLaborator) {
        this.profesorLaborator = profesorLaborator;
    }

    public void afisare(){
        System.out.println("=====================================================");
        System.out.println("Nume materie: " + this.nume);
        System.out.println("Numar credite: " + this.nrCredite);
        System.out.println("Profesor curs: " + this.profesorCurs.getNume() + " " + this.profesorCurs.getPrenume());
        System.out.println("Profesor laborator: " + this.profesorLaborator.getNume() + " " + this.profesorLaborator.getPrenume());
        System.out.println("=====================================================");
    }
}
