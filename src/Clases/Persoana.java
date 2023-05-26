package Clases;
public  abstract class  Persoana {
    int id;

    protected String nume;
    protected String prenume;
    protected int varsta;
    protected String sex;

    public Persoana(int id,String nume, String prenume, int varsta, String sex) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.sex = sex;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    ///abstract  void afisare();
    public abstract String toString();

}