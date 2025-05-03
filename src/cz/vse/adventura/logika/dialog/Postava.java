package cz.vse.adventura.logika.dialog;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Postava {
    private String nazev;
    private List<String> dialog;

    @JsonCreator
    public Postava(@JsonProperty("nazev") String nazev, @JsonProperty("dialog")List<String> dialog) {
        this.nazev = nazev;
        this.dialog = dialog;
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
        if (index < dialog.size()) {
            return dialog.get(index);
        }
        return null;
    }
}
