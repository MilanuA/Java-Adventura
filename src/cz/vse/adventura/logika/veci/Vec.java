package cz.vse.adventura.logika.veci;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Vec
{
    protected String nazev;
    protected boolean prenositelna;
    protected Integer hmotnost;


    protected boolean jePouzitelna;

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
               @JsonProperty("hmotnost") Integer hmotnost,
               @JsonProperty("pouzitelna") boolean jePouzitelna) {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.hmotnost = hmotnost;
        this.jePouzitelna = jePouzitelna;
    }

    public String getNazev() {
        return nazev;
    }

    public boolean isPrenositelna() {
        return prenositelna;
    }

    public boolean isJePouzitelna() {
        return jePouzitelna;
    }

    public Integer getHmotnost() {
        return hmotnost;
    }
}
