package cz.vse.adventura.logika;

import java.util.HashMap;
import java.util.Map;

public class Batoh
{
    private int maxHmotnost;

    private Map<String, Vec> veci = new HashMap<>();

    public Batoh(){

    }

    public Batoh(int maxHmotnost){
        this.maxHmotnost = maxHmotnost;
    }

    public Batoh(Map<String, Vec> veci){
        this.veci = veci;
    }

    public Batoh(int maxHmotnost, Map<String, Vec> veci){
        this.maxHmotnost = maxHmotnost;
        this.veci = veci;
    }

    public boolean pridejVec(Vec v)
    {
        String nazev = v.getNazev();

        //vratit false, pokud se vec nevejde do batohu, neni prenositelna ci uz je v batohlu absahla
        if(!vejdeSe(v) || !v.isPrenositelna() || !veci.containsKey(nazev))
            return false;

        veci.put(nazev, v);
        return true;
    }

    public boolean odeberVec(String nazev){

        if(!veci.containsKey(nazev))
            return false;

        veci.remove(nazev);
        return true;
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
