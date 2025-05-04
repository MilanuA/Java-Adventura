package cz.vse.adventura.logika.veci.pouzitelneVeci;

import cz.vse.adventura.logika.HerniPlan;
import cz.vse.adventura.logika.veci.PouzitelnaVec;
import java.util.Objects;

public class Pacidlo extends PouzitelnaVec {
    public Pacidlo(String nazev, boolean prenositelna, Integer hmotnost) {
        super(nazev, prenositelna, hmotnost);
    }

    @Override
    public String pouzij(HerniPlan plan) {
        if(muzeBytPouzita(plan)) return "Páčidlo zde nelze použít!";

        return "Použil jsi páčidlo na truhlu. V truhle se nacházel <Stříbrný prsten> a <Mapa Slovenska>.";
    }

    @Override
    public boolean muzeBytPouzita(HerniPlan plan) {

        return Objects.equals(plan.getAktualniProstor().getNazev(), "zřícenina");
    }
}
