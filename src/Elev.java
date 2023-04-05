public class Elev extends Persoana {

     String clasa;
     String scoala;
     double medie;
     Nota[] note = new Nota[10];

    public Elev(String nume, int varsta, int sex, String clasa, String scoala, double medie) {
        super(nume, varsta, sex);
        this.clasa = clasa;
        this.scoala = scoala;
        this.medie = medie;
    }

    public void adaugaNota(Nota nota) {
        for (int i = 0; i < note.length; i++) {
            if (note[i] == null) {
                note[i] = nota;
                break;
            }
        }
    }
}
