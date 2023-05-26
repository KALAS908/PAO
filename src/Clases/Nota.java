package Clases;

public class Nota {

    double nota;
    int idElev;
    int idMaterie;
    int id;
    String materie;

    public Nota(double nota, String materie) {
        this.nota = nota;
        this.materie = materie;
    }

    public Nota(int id,int idElev, int idMaterie, double nota, String materie) {
        this.nota = nota;
        this.idElev = idElev;
        this.idMaterie = idMaterie;
        this.id = id;
        this.materie = materie;
    }

    public double getNota() {
        return nota;
    }

    public int getIdElev() {
        return idElev;
    }

    public int getIdMaterie() {
        return idMaterie;
    }

    public int getId() {
        return id;
    }


    public void setIdElev(int idElev) {
        this.idElev = idElev;
    }

    public void setIdMaterie(int idMaterie) {
        this.idMaterie = idMaterie;
    }

    public void setId(int id) {
        this.id = id;
    }




    public void setNota(double nota) {
        this.nota = nota;
    }


    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

}
