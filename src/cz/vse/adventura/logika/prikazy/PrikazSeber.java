package cz.vse.adventura.logika.prikazy;
import cz.vse.adventura.logika.HerniPlan;
import cz.vse.adventura.logika.Vec;

public class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    /**
    *  Konstruktor třídy
    *
    *  @param plan herní plán, ve kterém se bude ve hře "chodit"
    */
    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length != 1) {
            return "Nevím, co mám sebrat. Napiš název věci";
        }

        String nazevVeci = parametry[0];

        try{
            Vec vec = plan.seberVec(nazevVeci);
            return "Věc " + vec.getNazev() + " byla vložena do batohu";
        }
        catch (Exception e) {
            return "Něco se pokazilo: " + e.getMessage();
        }
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
