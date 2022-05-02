package serie4;

public class Artikel implements Comparable<Artikel>{
    private int id;
    private double preis;
    private String name;

    public Artikel(int id, double preis, String name) {
        this.id = id;
        this.preis = preis;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
    @Override
    public String toString(){

        return "Artikel: " + name + " " + preis;
    }
    @Override
    public int compareTo(Artikel vergleichsobjet){
        if (vergleichsobjet.getPreis() > this.getPreis()) {
            return -1;
        }
        else if (vergleichsobjet.getPreis() < this.getPreis()){
            return 1;
        }
        else {
            return this.name.compareTo(vergleichsobjet.name);
        }
    }
}
