package cz.vse.adventura.logika.prikazy;
import cz.vse.adventura.logika.*;
import cz.vse.adventura.logika.dialogue.DialogueManager;

public class PrikazDej implements IPrikaz {
    private static final String NAZEV = "dej";
    private HerniPlan plan;

    public PrikazDej(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length != 2) {
            return "Použij příkaz ve tvaru: dej <věc> <postava>";
        }

        String nazevVeci = parametry[0];
        String nazevPostavy = parametry[1];

        Prostor aktualniProstor = plan.getAktualniProstor();
        Batoh batoh = plan.getBatoh();

        Postava postava = aktualniProstor.getPostavu(nazevPostavy);

        if (postava == null) {
            return "Postava '" + nazevPostavy + "' tady není.";
        }

        Vec vec = batoh.getVec(nazevVeci);
        if (vec == null) {
            return "Tuhle věc nemáš v batohu.";
        }

        String pozadovanaVec = postava.getPozadovanaVec();
        if (pozadovanaVec == null || !pozadovanaVec.equalsIgnoreCase(nazevVeci)) {
            return "Tuhle věc " + postava.getNazev() + " nechce.";
        }

        batoh.odeberVec(nazevVeci);
        String odmena = postava.getOdmena();

        if (odmena != null && !odmena.isEmpty()) {
            Vec odmenenaVec = plan.getDostupneVeci().get(postava.getOdmena());
            try {
                batoh.pridejVec(odmenenaVec);
            } catch (IllegalStateException e) {
                return "Věc byla odebrána, ale odměnu nelze vložit do batohu: " + e.getMessage();
            }
            return postava.getNazev() + " si vzal " + nazevVeci + " a dal ti " + odmena + ".";
        }

        return postava.getNazev() + " si vzal " + nazevVeci + ".";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

}
