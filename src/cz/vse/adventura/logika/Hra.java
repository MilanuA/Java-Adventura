package cz.vse.adventura.logika;

import cz.vse.adventura.logika.dialogue.DialogueManager;
import cz.vse.adventura.logika.prikazy.*;
import cz.vse.adventura.utils.Barvy;

import java.util.Objects;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Alex Milanů
 *@version    pro školní rok 2024/2025
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan;
    private Batoh batoh;
    private boolean konecHry = false;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {

        int maximalniHmotnost = 8;

        batoh = new Batoh(maximalniHmotnost);

        herniPlan = new HerniPlan(batoh);

        platnePrikazy = new SeznamPrikazu();

        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPoloz(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazZkontrolujKlice(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazMluv(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazDalsi());
        platnePrikazy.vlozPrikaz(new PrikazVypis(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazOdemkni(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazDej(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPouzij(herniPlan));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        String oddelovac = Barvy.BOLD + Barvy.YELLOW + "--------------------------" + Barvy.RESET;
        return oddelovac + "\n" +
                Barvy.BOLD + Barvy.YELLOW +
                "Vítejte!\n" +
                "Toto je příběh o Tajemství Spišsského pokladu.\n" +
                "Napište 'nápověda', pokud si nevíte rady, jak hrát dál.\n" +
                Barvy.RESET + "\n" +
                oddelovac + "\n\n" +
                herniPlan.getAktualniProstor().dlouhyPopis();
    }

    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Dík, že jste si zahráli.  Ahoj.";
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
           	parametry[i]= slova[i+1];  	
        }
        String textKVypsani=" .... ";

         if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu.toLowerCase()))
         {
             DialogueManager dialogManager = DialogueManager.getInstance();

             if (dialogManager.getIsDialogueAktivni() && !Objects.equals(slovoPrikazu, "další")) {
                 return "Je třeba pokračovat v dialogu. Nelze jej přerušit.";
             }

             IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu.toLowerCase());
             textKVypsani = prikaz.provedPrikaz(parametry);
         }
        else
        {
            textKVypsani="Nevím, co tím myslíš? Tento příkaz neznám. ";
        }

        return textKVypsani;
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
     public void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }
    
}

