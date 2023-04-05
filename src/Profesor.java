public class Profesor extends Persoana {

    protected String scoala;
    protected  double salariu;
    protected String materie;

    int grad;

    public Profesor(String nume, String prenume, int varsta, String sex, String scoala, double salariu, String materie , int grad) {
        super(nume, prenume, varsta, sex);
        this.scoala = scoala;
        this.salariu = salariu;
        this.materie = materie;
        this.grad = grad;
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
    public void afisare() {

        System.out.println("=====================================================");
        System.out.println("Nume profesor: " + this.nume + " " + this.prenume);
        System.out.println("Varsta: " + this.varsta);
        System.out.println("Materie Predata: " + this.materie);
        System.out.println("Salariu: " + this.salariu);
        System.out.println("Grad Profesoral: " + this.grad);
        System.out.println("=====================================================");
    }
}
