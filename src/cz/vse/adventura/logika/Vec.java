package cz.vse.adventura.logika;

public class Vec
{
    private String nazev;
    private boolean prenositelna;
    private Integer hmotnost;

    public Vec(String nazev, boolean prenositelna) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;

        if(prenositelna)
            this.hmotnost = 0;
        else
            this.hmotnost = null;
    }


    public Vec(String nazev, boolean prenositelna, Integer hmotnost) {
        this.prenositelna = prenositelna;
        this.nazev = nazev;
        this.hmotnost = hmotnost;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean isPrenositelna() {
        return prenositelna;
    }

    public Integer getHmotnost() {
        return hmotnost;
    }
}
