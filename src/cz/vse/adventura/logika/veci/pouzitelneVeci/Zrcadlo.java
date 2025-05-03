package cz.vse.adventura.logika.veci.pouzitelneVeci;

import cz.vse.adventura.logika.veci.PouzitelnaVec;

public class Zrcadlo extends PouzitelnaVec {
    public Zrcadlo(String nazev, boolean prenositelna, Integer hmotnost) {
        super(nazev, prenositelna, hmotnost);
    }

    @Override
    public String pouzij() {
        return "Zrcadlo použito!";
    }
}
