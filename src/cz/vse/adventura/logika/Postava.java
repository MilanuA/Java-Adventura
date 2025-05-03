package cz.vse.adventura.logika;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Postava {
    private String nazev;
    private List<String> dialog;
    private List<String> pokracovaniDialogu;

    private boolean promluvilSPostavou;

    @JsonCreator
    public Postava(
            @JsonProperty("nazev") String nazev,
            @JsonProperty("dialog") List<String> dialog,
            @JsonProperty("pokracovaniDialogu") List<String> pokracovaniDialogu) {
        this.nazev = nazev;
        this.dialog = dialog;
        this.pokracovaniDialogu = pokracovaniDialogu;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public List<String> getDialog() {
        return dialog;
    }

    public void setDialog(List<String> dialog) {
        this.dialog = dialog;
    }

    public String getNextDialog(int index) {
        List<String> aktivniDialog = promluvilSPostavou ? pokracovaniDialogu : dialog;

        if (index >= 0 && index < aktivniDialog.size()) {
            return aktivniDialog.get(index);
        }

        return null;
    }


    public void setPromluvilSPostavou(boolean promluvilSPostavou) {
        this.promluvilSPostavou = promluvilSPostavou;
    }
}
