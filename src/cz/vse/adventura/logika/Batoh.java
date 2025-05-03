package cz.vse.adventura.logika;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Batoh
{
    private int maxHmotnost;

    private Map<String, Vec> veci = new HashMap<>();

    public Batoh()
    {

    }

    public Batoh(int maxHmotnost){
        this.maxHmotnost = maxHmotnost;
    }

    public Batoh(Map<String, Vec> veci){
        this.veci = veci;
    }

    public Batoh(int maxHmotnost, Set<Vec> veci){
        this.maxHmotnost = maxHmotnost;
        this.veci = new HashMap<>();

        for (Vec vec: veci){
            this.veci.put(vec.getNazev(), vec);
        }
    }

    public Vec pridejVec(Vec v)
    {
        String nazev = v.getNazev();

        //vratit false, pokud se vec nevejde do batohu, neni prenositelna ci uz je v batohlu absahla
        if(!vejdeSe(v))
            throw new IllegalStateException("Věc " + nazev + " se do batohu nevejde");

        if(!veci.containsKey(nazev))
            throw new IllegalStateException("Věc " + nazev + " je již v batohu přítomna");

        if(!v.isPrenositelna())
            throw new IllegalStateException("Věc " + nazev + " není přenositelná");

        veci.put(nazev, v);

        return v;
    }

    public Vec getVec(String nazev){
        return veci.get(nazev);
    }

    public Vec odeberVec(String nazev){

        if(!veci.containsKey(nazev))
            throw new IllegalStateException("Věc " + nazev + " v batohu není");

        Vec v = getVec(nazev);

        veci.remove(nazev);
        return v;
    }


    public Vec odeberVec(Vec v){

        if(!veci.containsValue(v))
            throw new IllegalStateException("Věc " + v.getNazev() + " v batohu není");

        veci.remove(v.getNazev());
        return v;
    }

    public String popisBatohu() {
        if (veci.isEmpty()) {
            return "[Batoh]: prázdný | 0 kg";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[Batoh]: ");

        for (Vec vec : veci.values()) {
            sb.append(vec.getNazev()).append(" (").append(vec.getHmotnost()).append(" kg), ");
        }

        sb.setLength(sb.length() - 2);

        sb.append(" | ").append(getAktualniHmotnost()).append(" kg");

        return sb.toString();
    }

    private boolean vejdeSe(Vec v){
        return getAktualniHmotnost() + v.getHmotnost() <= this.maxHmotnost;
    }

    private int getAktualniHmotnost() {
        int sum = 0;

        for (Vec vec : veci.values()) {
            sum += vec.getHmotnost();
        }
        return sum;
    }
}
