package cz.vse.adventura.logika.veci.pouzitelneVeci;

import cz.vse.adventura.logika.HerniPlan;
import cz.vse.adventura.logika.veci.PouzitelnaVec;

import java.util.Objects;

public class Prut extends PouzitelnaVec {
    public Prut(String nazev, boolean prenositelna, Integer hmotnost) {
        super(nazev, prenositelna, hmotnost);
    }

    @Override
    public String pouzij(HerniPlan plan) {

        if(muzeBytPouzita(plan)) return "Prut zde nelze použít!";

        return "Použil jsi prut a chytil si <rybu>.";
    }

    @Override
    public boolean muzeBytPouzita(HerniPlan plan) {

        return Objects.equals(plan.getAktualniProstor().getNazev(), "dunaj");
    }
}
