package cz.vse.adventura.utils;

import cz.vse.adventura.logika.Prostor;
import cz.vse.adventura.logika.veci.Vec;
import cz.vse.adventura.logika.Postava;

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
            String jmeno = null;
            if (element instanceof Prostor) {
                jmeno = ((Prostor) element).getNazev();
            } else if (element instanceof Vec) {
                jmeno = ((Vec) element).getNazev();
            } else if (element instanceof Postava) {
                jmeno = ((Postava) element).getNazev();
            }

            if (jmeno != null) {
                joiner.add(capitalize(jmeno));
            }
        }

        return Barvy.BOLD + Barvy.BLUE + nazev + ":" + Barvy.RESET + " " + joiner.toString();
    }

    private static String capitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }



}
