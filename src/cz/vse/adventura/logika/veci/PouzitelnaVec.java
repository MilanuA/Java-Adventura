package cz.vse.adventura.logika.veci;

public abstract class PouzitelnaVec extends Vec {

    public PouzitelnaVec(String nazev, boolean prenositelna, Integer hmotnost) {
        super(nazev, prenositelna, hmotnost, true);
    }

    public abstract String pouzij();
}

