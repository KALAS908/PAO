package Clases;

public class Profesor extends Persoana {

    protected String scoala;
    protected  double salariu;
    protected String materie;
    int grad;

    public Profesor(int id,String nume, String prenume, int varsta, String sex, String scoala, double salariu, String materie , int grad) {
        super(id,nume, prenume, varsta, sex);
        this.scoala = scoala;
        this.salariu = salariu;
        this.materie = materie;
        this.grad = grad;
    }
     public int getID()
    {
        return id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public String getScoala() {
        return scoala;
    }

    public void setScoala(String scoala) {
        this.scoala = scoala;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "Clases.Profesor{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", materie='" + materie + '\'' +
                ", grad=" + grad +
                '}';

    }
}
