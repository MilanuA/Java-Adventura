package cz.vse.adventura.utils;

import cz.vse.adventura.logika.Prostor;
import cz.vse.adventura.logika.Vec;
import cz.vse.adventura.logika.dialog.Postava;

import java.util.Collection;
import java.util.StringJoiner;

public class TextUtils
{
    public static String popisElementu(String nazev, Collection<?> collection) {
        if (collection.isEmpty()) {
            return Barvy.BOLD + Barvy.BLUE + nazev + ":" + Barvy.RESET + " žádné";
        }

        StringJoiner joiner = new StringJoiner(", ");
        for (Object element : collection) {
            if (element instanceof Prostor) {
                joiner.add(((Prostor) element).getNazev());
            } else if (element instanceof Vec) {
                joiner.add(((Vec) element).getNazev());
            } else if (element instanceof Postava) {
                joiner.add(((Postava) element).getNazev());
            }
        }

        return Barvy.BOLD + Barvy.BLUE + nazev + ":" + Barvy.RESET + " " + joiner.toString();
    }

}
