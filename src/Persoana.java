public  abstract class  Persoana {

    String nume;
    String prenume;
    int varsta;
    String sex;

    public Persoana(String nume, String prenume, int varsta, String sex) {
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
    abstract void afisare();

}
