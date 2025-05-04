package cz.vse.adventura.logika.veci;

import cz.vse.adventura.logika.veci.pouzitelneVeci.Pacidlo;
import cz.vse.adventura.logika.veci.pouzitelneVeci.Prut;
import cz.vse.adventura.logika.veci.pouzitelneVeci.Sekera;
import cz.vse.adventura.logika.veci.pouzitelneVeci.Zrcadlo;

/// <summary>
/// Tovární třída pro vytváření instancí třídy Vec na základě dat z VecDTO
/// Rozhoduje, zda vytvořit běžnou nebo použitelnou věc dle jejího názvu a vlastností
/// </summary>
public class VecFactory {

    /// <summary>
    /// Vytváří instanci třídy Vec nebo její podtřídy na základě zadaných dat
    /// Pokud je věc označena jako použitelná, vytvoří instanci příslušné třídy podle názvu
    /// Pokud není použitelná, vrací instanci základní třídy Vec
    /// </summary>
    /// <returns>Instance třídy Vec nebo její podtřídy</returns>
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

