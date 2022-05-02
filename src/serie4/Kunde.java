package serie4;

import java.util.HashMap;
import java.util.Map;

public class Kunde implements Comparable<Kunde> {
    private int id;
    private int alter;
    private String name;
    private Map<Artikel, Integer> einkaufsliste = new HashMap<>();

    public Kunde(int id, int alter, String name) {
        this.id = id;
        this.alter = alter;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAlter() {
        return alter;
    }

    public String getName() {
        return name;
    }

    public Map<Artikel, Integer> getEinkaufsliste() {
        return einkaufsliste;
    }

    public void setEinkaufsliste(Map<Artikel, Integer> einkaufsliste) {
        this.einkaufsliste = einkaufsliste;
    }

    public double gesamtkosten(){
        double gesamtKosten = 0;
        for( Artikel i : einkaufsliste.keySet()){
            gesamtKosten += einkaufsliste.get(i)*i.getPreis();
        }

        return gesamtKosten;
    }
    @Override
    public String toString(){

        return "Kunde: " + name + " " + alter;
    }
    @Override
    public int compareTo(Kunde vergleichsobjet){
        if (vergleichsobjet.getAlter() > this.getAlter()) {
            return -1;
        }
        else if (vergleichsobjet.getAlter() < this.getAlter()){
            return 1;
        }
        else {
            return 0;
        }
    }

}
