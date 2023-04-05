public class Diriginte extends Profesor{
    String clasa;

    public Diriginte(String nume, String prenume, int varsta, String sex, String scoala, double salariu, String materie, int grad, String clasa) {
        super(nume, prenume, varsta, sex, scoala, salariu, materie, grad);
        this.clasa = clasa;
    }

    public Diriginte(Profesor profesor, String clasa)
    {
        super(profesor.getNume(), profesor.getPrenume(), profesor.getVarsta(), profesor.getSex(), profesor.getScoala(), profesor.getSalariu(), profesor.getMaterie(), profesor.getGrad());
        this.clasa = clasa;

    }




    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    @Override
    public void afisare() {
        System.out.println("=====================================================");
        System.out.println("Nume diriginte: " + this.nume + " " + this.prenume);
        System.out.println("Varsta: " + this.varsta);
        System.out.println("Materie Predata: " + this.materie);
        System.out.println("Salariu: " + this.salariu);
        System.out.println("Grad Profesoral: " + this.grad);
        System.out.println("Diriginte pentru clasa : " + this.clasa);
        System.out.println("=====================================================");
    }
}
