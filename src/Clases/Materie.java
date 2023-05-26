package Clases;

public class Materie {

    String nume;
    int id;
    int nrCredite;
    int idProfesorCurs;
    int idProfesorLaborator;
    Profesor profesorCurs;
    Profesor profesorLaborator;

    public Materie(int id,String nume, int nrCredite, Profesor profesorCurs, Profesor profesorLaborator) {
        this.id = id;
        this.nume = nume;
        this.nrCredite = nrCredite;
        this.profesorCurs = profesorCurs;
        this.profesorLaborator = profesorLaborator;
    }

    public Materie(int id,String nume, int nrCredite, int idProfesorCurs, int idProfesorLaborator) {
        this.id = id;
        this.nume = nume;
        this.nrCredite = nrCredite;
        this.idProfesorCurs = idProfesorCurs;
        this.idProfesorLaborator = idProfesorLaborator;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProfesorCurs() {
        return idProfesorCurs;
    }

    public void setIdProfesorCurs(int idProfesorCurs) {
        this.idProfesorCurs = idProfesorCurs;
    }

    public int getIdProfesorLaborator() {
        return idProfesorLaborator;
    }

    public void setIdProfesorLaborator(int idProfesorLaborator) {
        this.idProfesorLaborator = idProfesorLaborator;
    }

    public void afisare(){
        System.out.println("=====================================================");
        System.out.println("Nume materie: " + this.nume);
        System.out.println("Numar credite: " + this.nrCredite);
        System.out.println("Clases.Profesor curs: " + this.profesorCurs.getNume() + " " + this.profesorCurs.getPrenume());
        System.out.println("Clases.Profesor laborator: " + this.profesorLaborator.getNume() + " " + this.profesorLaborator.getPrenume());
        System.out.println("=====================================================");
    }
}
