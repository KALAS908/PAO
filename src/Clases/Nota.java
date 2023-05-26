package Clases;

public class Nota {

    double nota;
    String materie;

    public Nota(double nota, String materie) {
        this.nota = nota;
        this.materie = materie;
    }

    public double getNota() {
        return nota;
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
