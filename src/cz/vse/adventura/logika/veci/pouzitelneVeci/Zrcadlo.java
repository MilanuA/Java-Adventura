package cz.vse.adventura.logika.veci.pouzitelneVeci;

import cz.vse.adventura.logika.HerniPlan;
import cz.vse.adventura.logika.veci.PouzitelnaVec;

import java.util.Objects;

public class Zrcadlo extends PouzitelnaVec {
    public Zrcadlo(String nazev, boolean prenositelna, Integer hmotnost) {
        super(nazev, prenositelna, hmotnost);
    }

    @Override
    public String pouzij(HerniPlan plan) {

        if(muzeBytPouzita(plan)) return "Zrcadlo zde nelze použít!";

        return "Zrcadlo použito!";
    }

    @Override
    public boolean muzeBytPouzita(HerniPlan plan) {
        return Objects.equals(plan.getAktualniProstor().getNazev(), "tatry");
    }
}
