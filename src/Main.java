public class Main {
    public static void main(String[] args) {
        Elev elev = new Elev("Popescu", "Ion", 15, "M", "9A", "Liceul Teoretic");
         elev.adaugaNota(new Nota(10, "Matematica"));
         elev.adaugaNota(new Nota(9, "Romana"));
         elev.adaugaNota(new Nota(8, "Istorie"));
         elev.adaugaNota(new Nota(7, "Geografie"));
         elev.adaugaNota(new Nota(6, "Biologie"));

            elev.afisare();
    }
}