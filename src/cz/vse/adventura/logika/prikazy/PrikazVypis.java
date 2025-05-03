package cz.vse.adventura.logika.prikazy;
import cz.vse.adventura.logika.HerniPlan;

enum TypPrikazu {
    prostor,
    batoh,
}

public class PrikazVypis implements IPrikaz {

    private static final String NAZEV = "vypis";

    private HerniPlan plan;

    public PrikazVypis(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry)
    {
        if (parametry.length == 0) {
            return "Musíš zadat, co chceš vypsat (např. 'prostor' nebo 'batoh').";
        }

        TypPrikazu typ;
        try {
            typ = TypPrikazu.valueOf(parametry[0].toLowerCase());
        } catch (IllegalArgumentException e) {
            return "Neznámý typ výpisu: " + parametry[0];
        }

        return switch (typ) {
            case prostor ->
                    plan.getAktualniProstor().dlouhyPopis();
            case batoh ->
                    plan.getBatoh().popisBatohu();
            default -> "Tento typ výpisu není podporován.";
        };
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
