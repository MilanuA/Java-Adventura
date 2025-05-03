package cz.vse.adventura.logika.veci;

import cz.vse.adventura.logika.veci.pouzitelneVeci.Pacidlo;
import cz.vse.adventura.logika.veci.pouzitelneVeci.Prut;
import cz.vse.adventura.logika.veci.pouzitelneVeci.Sekera;
import cz.vse.adventura.logika.veci.pouzitelneVeci.Zrcadlo;

public class VecFactory {
    public static Vec vytvorVec(VecDTO data) {
        if (!data.pouzitelna()) {
            return new Vec(data.nazev(), data.prenositelna(), data.hmotnost(), false);
        }

        return switch (data.nazev()) {
            case "sekera" -> new Sekera(data.nazev(), data.prenositelna(), data.hmotnost());
            case "zrcadlo" -> new Zrcadlo(data.nazev(), data.prenositelna(), data.hmotnost());
            case "páčidlo" -> new Pacidlo(data.nazev(), data.prenositelna(), data.hmotnost());
            case "prut" -> new Prut(data.nazev(), data.prenositelna(), data.hmotnost());
            default -> new Vec(data.nazev(), data.prenositelna(), data.hmotnost(), false);
        };
    }
}
