package cz.vse.adventura.logika;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import cz.vse.adventura.logika.jsonNacitani.JsonLoader;
import cz.vse.adventura.logika.jsonNacitani.ProstorDTO;
import cz.vse.adventura.logika.veci.Vec;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Alex Milanů
 *@version    pro školní rok 2024/2025
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;

    private Map<String, Prostor> prostoryMapa;
    private Map<String, Vec> dostupneVeci;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Batoh batoh) {
        this.batoh = batoh;

        zalozProstoryHry();
    }

    private void zalozProstoryHry() {
        try {
            dostupneVeci = JsonLoader.nactiVeciDoMapy();

            List<Postava> postavyList = JsonLoader.nactiPostavy();
            Map<String, Postava> postavyMapa = new HashMap<>();
            for (Postava postava : postavyList) {
                postavyMapa.put(postava.getNazev(), postava);
            }

            List<ProstorDTO> prostoryDTO = JsonLoader.nactiProstoryDTO();
            prostoryMapa = new HashMap<>();
            for (ProstorDTO dto : prostoryDTO) {
                Prostor p = new Prostor(dto.nazev(), dto.popis());
                prostoryMapa.put(dto.nazev(), p);
            }

            for (ProstorDTO dto : prostoryDTO) {
                Prostor p = prostoryMapa.get(dto.nazev());

                if (dto.veci() != null) {
                    for (String vecNazev : dto.veci()) {
                        Vec vec = dostupneVeci.get(vecNazev);
                        if (vec != null) {
                            p.pridejVec(vec);
                        }
                    }
                }

                if (dto.vychody() != null) {
                    for (String vychodNazev : dto.vychody()) {
                        Prostor vychod = prostoryMapa.get(vychodNazev);
                        if (vychod != null) {
                            p.setVychod(vychod);
                        }
                    }
                }

                if (dto.postavy() != null) {
                    for (String postavaNazev : dto.postavy()) {
                        Postava postava = postavyMapa.get(postavaNazev);
                        if (postava != null) {
                            p.pridejPostavu(postava);
                        }
                    }
                }
            }

            aktualniProstor = prostoryMapa.get("hrad");

        } catch (IOException e) {
            System.err.println("Chyba při načítání souborů: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Došlo k chybě při zakládání prostorů hry: " + e.getMessage());
        }
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }


    public Vec seberVec(String nazev){
        Vec vec = getAktualniProstor().getVec(nazev);

        batoh.pridejVec(vec);
        aktualniProstor.odeberVec(nazev);

        return vec;
    }

    public Batoh getBatoh()
    {
        return batoh;
    }

    public void setDostupneVeci(Map<String, Vec> dostupneVeci) {
        this.dostupneVeci = dostupneVeci;
    }

    public Map<String, Vec> getDostupneVeci() {
        return dostupneVeci;
    }

}
