package Clases;

public class Diriginte extends Profesor {
    String clasa;

    public Diriginte(int id, String nume, String prenume, int varsta, String sex, String scoala, double salariu, String materie, int grad, String clasa) {
        super(id,nume, prenume, varsta, sex, scoala, salariu, materie, grad);
        this.clasa = clasa;
    }

    public Diriginte(Profesor profesor, String clasa)
    {
        super(profesor.getID(), profesor.getNume(), profesor.getPrenume(), profesor.getVarsta(), profesor.getSex(), profesor.getScoala(), profesor.getSalariu(), profesor.getMaterie(), profesor.getGrad());
        this.clasa = clasa;

    }




    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    @Override
    public String toString() {

        return "Clases.Diriginte{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                "}";

    }
}
