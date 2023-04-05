public class Persoana {

    String nume;
    int varsta;
    int sex;

    public Persoana(String nume, int varsta, int sex) {
        this.nume = nume;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
