package cz.vse.adventura.logika.prikazy;
import cz.vse.adventura.logika.HerniPlan;
import cz.vse.adventura.logika.veci.PouzitelnaVec;
import cz.vse.adventura.logika.veci.Vec;

public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length != 1) {
            return "Nevím, co mám sebrat. Napiš název věci";
        }

        String nazevVeci = parametry[0];

        try {
            Vec vec = plan.seberVec(nazevVeci);

            if (vec instanceof PouzitelnaVec) {
                return "Věc '" + vec.getNazev() + "' byla vložena do batohu a lze ji použít.";
            } else {
                return "Věc '" + vec.getNazev() + "' byla vložena do batohu.";
            }

        } catch (Exception e) {
            return "Něco se pokazilo: " + e.getMessage();
        }

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

}
