package cz.vse.adventura.logika.veci;

import cz.vse.adventura.logika.HerniPlan;

public abstract class PouzitelnaVec extends Vec {

    public PouzitelnaVec(String nazev, boolean prenositelna, Integer hmotnost) {
        super(nazev, prenositelna, hmotnost, true);
    }

    public void pridejPredmety(Vec[] predmety){

    }

    public abstract String pouzij(HerniPlan plan);

    public abstract boolean muzeBytPouzita(HerniPlan plan);
}

