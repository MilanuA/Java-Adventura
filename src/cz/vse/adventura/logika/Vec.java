package cz.vse.adventura.logika;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonCreator
    public Vec(@JsonProperty("nazev") String nazev,
               @JsonProperty("prenositelna") boolean prenositelna,
               @JsonProperty("hmotnost") Integer hmotnost) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
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
