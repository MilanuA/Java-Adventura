package cz.vse.adventura.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.vse.adventura.logika.veci.Vec;
import cz.vse.adventura.logika.Postava;
import cz.vse.adventura.logika.veci.VecFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Třída {@code JsonLoader} slouží pro načítání herních dat ze souborů ve formátu JSON
 * Načítá seznamy předmětů (věcí), postav a dat o prostorech pro hru
 *
 * @author Alex Milanů
 * @version pro školní rok 2024/2025
 */
public class JsonLoader {

    /**
     * Načítá seznam věcí ze souboru ve formátu JSON
     * Používá {@code VecDTO} a tovární metodu pro vytvoření instancí třídy {@code Vec} nebo jejích podtříd
     *
     * @param cesta cesta k souboru s JSON daty
     * @return seznam instancí třídy {@code Vec}
     */
    private static List<Vec> nactiVeci(String cesta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File(cesta);
        VecDTO[] dataPole = mapper.readValue(file, VecDTO[].class);

        List<Vec> veci = new ArrayList<>();
        for (VecDTO data : dataPole) {
            veci.add(VecFactory.vytvorVec(data));
        }

        return veci;
    }

    /**
     * Načítá věci ze souboru a vrací je jako mapu, kde klíčem je název věci
     *
     * @param cesta cesta k souboru s JSON daty
     * @return mapa názvů a odpovídajících instancí třídy {@code Vec}
     */
    public static Map<String, Vec> nactiVeciDoMapy(String cesta) throws IOException {
        List<Vec> veciList = nactiVeci(cesta);

        Map<String, Vec> veciMapa = new HashMap<>();

        for (Vec vec : veciList) {
            veciMapa.put(vec.getNazev(), vec);
        }
        return veciMapa;
    }

    /**
     * Načítá seznam postav ze souboru ve formátu JSON
     *
     * @param cesta cesta k souboru s JSON daty
     * @return seznam instancí třídy {@code Postava}
     */
    public static List<Postava> nactiPostavy(String cesta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(cesta), new TypeReference<List<Postava>>() {});
    }

    /**
     * Načítá seznam DTO objektů představujících prostory ze souboru ve formátu JSON
     *
     * @param cesta cesta k souboru s JSON daty
     * @return seznam instancí třídy {@code ProstorDTO}
     */
    public static List<ProstorDTO> nactiProstoryDTO(String cesta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(cesta), new TypeReference<List<ProstorDTO>>() {});
    }
}

