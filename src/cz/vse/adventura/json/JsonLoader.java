package cz.vse.adventura.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.vse.adventura.logika.Prostor;
import cz.vse.adventura.logika.Vec;
import cz.vse.adventura.logika.dialog.Postava;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonLoader {

    private static List<Vec> nactiVeci(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), new TypeReference<List<Vec>>() {});
    }

    public static Map<String, Vec> nactiVeciDoMapy(String path) throws IOException {
        List<Vec> veciList = nactiVeci(path);
        Map<String, Vec> veciMapa = new HashMap<>();
        for (Vec vec : veciList) {
            veciMapa.put(vec.getNazev(), vec);
        }
        return veciMapa;
    }

    public static List<Postava> nactiPostavy(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Načítání JSONu jako seznam objektů Postava
        return mapper.readValue(new File(path), new TypeReference<List<Postava>>() {});
    }

    public static List<ProstorDTO> nactiProstoryDTO(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), new TypeReference<List<ProstorDTO>>() {});
    }

}
