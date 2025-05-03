package cz.vse.adventura.logika.veci.pouzitelneVeci;

import cz.vse.adventura.logika.veci.PouzitelnaVec;

public class Sekera extends PouzitelnaVec {
    public Sekera(String nazev, boolean prenositelna, Integer hmotnost) {
        super(nazev, prenositelna, hmotnost);
    }
    @Override
    public String pouzij() {
        return "Sekera použita!";
    }
}
