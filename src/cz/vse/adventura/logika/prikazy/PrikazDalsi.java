package cz.vse.adventura.logika.prikazy;
import cz.vse.adventura.logika.HerniPlan;
import cz.vse.adventura.logika.Postava;
import cz.vse.adventura.logika.dialogue.DialogueManager;

public class PrikazDalsi implements IPrikaz {
    private static final String NAZEV = "další";

    public PrikazDalsi() {

    }

    @Override
    public String provedPrikaz(String... parametry) {
        return DialogueManager.getInstance().dalsiRadek();
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }

}
