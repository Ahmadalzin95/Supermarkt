package serie4;

public class Video extends Artikel {

    private boolean altersbeschraenkt;

    public Video(int id, double preis, String name, boolean altersbeschraenkt) {
        super(id, preis, name);
        this.altersbeschraenkt = altersbeschraenkt;
    }

    public boolean isAltersbeschraenkt() {
        return altersbeschraenkt;
    }
    @Override
    public String toString(){
        String alter = "";
        if(altersbeschraenkt){
            alter = " altersbeschraenktes Video";
        }

        return super.toString() + alter;
    }
}
