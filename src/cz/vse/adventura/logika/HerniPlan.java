package cz.vse.adventura.logika;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import cz.vse.adventura.json.JsonLoader;
import cz.vse.adventura.json.ProstorDTO;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;

    private Map<String, Prostor> prostoryMapa;
    private Map<String, Vec> veciMapa;

    /**
     * Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     * Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Batoh batoh) throws IOException {
        this.batoh = batoh;

        zalozProstoryHry("src/cz/vse/adventura/json/veci.json", "src/cz/vse/adventura/json/prostory.json");
    }

    /**
     * Načte prostory a věci z JSON souborů a propojí je.
     *
     * @param veciPath cesta k souboru s JSON daty o věcech.
     * @param prostoryPath cesta k souboru s JSON daty o prostorech.
     */
    private void zalozProstoryHry(String veciPath, String prostoryPath) throws IOException {
        veciMapa = JsonLoader.nactiVeciDoMapy(veciPath);

        List<ProstorDTO> prostoryDTO = JsonLoader.nactiProstoryDTO(prostoryPath);
        prostoryMapa = new HashMap<>();

        for (ProstorDTO dto : prostoryDTO) {
            Prostor p = new Prostor(dto.nazev, dto.popis);
            prostoryMapa.put(dto.nazev, p);
        }

        for (ProstorDTO dto : prostoryDTO) {
            Prostor p = prostoryMapa.get(dto.nazev);
            if (dto.veci != null) {
                for (String vecNazev : dto.veci) {
                    Vec vec = veciMapa.get(vecNazev);
                    if (vec != null) {
                        p.pridejVec(vec);
                    }
                }
            }
        }

        for (ProstorDTO dto : prostoryDTO) {
            Prostor p = prostoryMapa.get(dto.nazev);
            if (dto.vychody != null) {
                for (String vychodNazev : dto.vychody) {
                    Prostor vychod = prostoryMapa.get(vychodNazev);
                    if (vychod != null) {
                        p.setVychod(vychod);
                    }
                }
            }
        }


        aktualniProstor = prostoryMapa.get("zřícenina");
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

    public void pridejVec(String nazev){
        Vec v = batoh.getVec(nazev);
        batoh.odeberVec(v);

        aktualniProstor.pridejVec(v);
    }

    public Batoh getBatoh()
    {
        return batoh;
    }
}
