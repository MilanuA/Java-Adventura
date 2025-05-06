package cz.vse.adventura.logika;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import cz.vse.adventura.logika.veci.Vec;

import java.util.List;
import java.util.Map;

public class Postava {
    private String nazev;
    private List<String> dialog;
    private List<String> pokracovaniDialogu;
    private String pozadovanaVec;
    private String odmena;

    private boolean promluvilSPostavou;

    @JsonCreator
    public Postava(
            @JsonProperty("nazev") String nazev,
            @JsonProperty("dialog") List<String> dialog,
            @JsonProperty("pokracovaniDialogu") List<String> pokracovaniDialogu,
            @JsonProperty("odmena") String odmena,
            @JsonProperty("pozadovanaVec") String pozadovanaVec) {
        this.nazev = nazev;
        this.dialog = dialog;
        this.pokracovaniDialogu = pokracovaniDialogu;
        this.odmena = odmena;
        this.pozadovanaVec = pozadovanaVec;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getDalsiRadek(int index) {
        List<String> aktivniDialog = promluvilSPostavou ? pokracovaniDialogu : dialog;

        if (index >= 0 && index < aktivniDialog.size()) {
            return aktivniDialog.get(index);
        }

        return null;
    }

    public void setPromluvilSPostavou(boolean promluvilSPostavou) {
        this.promluvilSPostavou = promluvilSPostavou;
    }

    public String prijmiVec(Vec vec, Batoh batoh, Map<String, Vec> dostupneVeci) {
        if (pozadovanaVec == null || !pozadovanaVec.equalsIgnoreCase(vec.getNazev())) {
            return getNazev() + " tuhle věc nechce.";
        }

        if (odmena != null && !odmena.isEmpty()) {

            Vec odmenenaVec = dostupneVeci.get(odmena);

            if (odmenenaVec != null) {
                try {
                    batoh.pridejVec(odmenenaVec);
                    return getNazev() + " si vzal " + vec.getNazev() + " a dal ti " + odmena + ".";
                } catch (IllegalStateException e) {
                    return "Věc byla odebrána, ale odměnu nelze vložit do batohu: " + e.getMessage();
                }
            }
        }

        return getNazev() + " si vzal " + vec.getNazev() + ".";
    }

}
