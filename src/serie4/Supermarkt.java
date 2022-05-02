package serie4;

import java.util.*;

public class Supermarkt {

    private Map<Artikel, Integer> sortiment = new HashMap<>();
    private Set<Kunde> kunden = new HashSet<>();

    public Supermarkt(){
    }

    public void addKunde(Kunde kunde){
        kunden.add(kunde);
    }

    public void aktualisiereArtikel(Artikel artikel, int anzahl){
        if( anzahl == 0 ){
            sortiment.remove(artikel);
        }
        else{
            sortiment.put(artikel ,anzahl);
        }
    }

    public Map<Artikel, Integer> filterePreis(double minPreis, double maxPreis){
        Map<Artikel, Integer> sortimentb = new HashMap<>();

        for(Artikel i : sortiment.keySet()){
            if (i.getPreis() >= minPreis && i.getPreis() <= maxPreis ){
                sortimentb.put(i, sortiment.get(i));
            }
        }
        return sortimentb;
    }

    public Set<Kunde> filtereErwachsene(){
        Set<Kunde> kundenb = new HashSet<>();
        for (Kunde i : kunden){
            if(i.getAlter() >= 18){
                kundenb.add(i);
            }
        }
        return kundenb;
    }

    public List<Artikel> sortiereArtikel(boolean aufsteigend){
        List<Artikel> sortierteArtikel = new ArrayList<>();
        for (Artikel i : sortiment.keySet()){
            sortierteArtikel.add(i);
        }
        Collections.sort(sortierteArtikel, Comparator.naturalOrder());
        if(aufsteigend){
            return sortierteArtikel;
        }
        else {
            Collections.reverse(sortierteArtikel);
            return sortierteArtikel;
        }
    }

    public boolean istValiderEinkauf(int kundenId) {

        boolean d = true;

        for (Kunde k : this.kunden){
            if(k.getId() == kundenId){

                for(Artikel a : k.getEinkaufsliste().keySet()){
                    if(!this.sortiment.keySet().contains(a)){
                        d = false;
                    }

                    if(this.sortiment.get(a) < k.getEinkaufsliste().get(a)){
                        d = false;
                    }
                     if( a instanceof Video){
                         if( ((Video)a).isAltersbeschraenkt() == true && !filtereErwachsene().contains(k) ){
                             d = false;
                         }
                     }
                }
            }
        }
        return d;
    }
}


