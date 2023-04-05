public class Elev extends Persoana {

     String clasa;
     String scoala;
     double medie;
     Nota[] note = new Nota[10];

    public Elev(String nume,String prenume, int varsta, String sex, String clasa, String scoala, double medie  )  {
        super(nume,prenume, varsta, sex);
        this.clasa = clasa;
        this.scoala = scoala;
        this.medie = medie;
    }

    public Elev(String nume,String prenume, int varsta, String sex, String clasa, String scoala) {
        super(nume, prenume,varsta, sex);
        this.clasa = clasa;
        this.scoala = scoala;
    }

    public void adaugaNota(Nota nota) {
        for (int i = 0; i < note.length; i++) {
            if (note[i] == null) {
                note[i] = nota;
                break;
            }
        }
        calculeazaMedie();
    }

    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public String getScoala() {
        return scoala;
    }

    public void setScoala(String scoala) {
        this.scoala = scoala;
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }

    public Nota[] getNote() {
        return note;
    }

    public void setNote(Nota[] note) {
        this.note = note;
    }

    public void calculeazaMedie() {
        double suma = 0;
        int nrNote = 0;
        for (int i = 0; i < note.length; i++) {
            if (note[i] != null) {
                suma += note[i].getNota();
                nrNote++;
            }
        }
        this.medie = suma / nrNote;
    }

    public void afiseazaNote() {
        for (int i = 0; i < note.length; i++) {
            if (note[i] != null) {
                System.out.println("Materie: " + note[i].getMaterie() + "; Nota: " + note[i].getNota());
            }
        }
    }

    @Override
    public void afisare()
    {
        System.out.println("=====================================================");
        System.out.println("Nume elev: " + this.nume + " " + this.prenume);
        System.out.println("Varsta: " + this.varsta);
        System.out.println("Clasa: " + this.clasa);
        this.afiseazaNote();
        System.out.println("Media este: " + this.medie);
        System.out.println("=====================================================");
    }

}
