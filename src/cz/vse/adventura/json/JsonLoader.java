package cz.vse.adventura.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.vse.adventura.logika.veci.Vec;
import cz.vse.adventura.logika.Postava;
import cz.vse.adventura.logika.veci.VecDTO;
import cz.vse.adventura.logika.veci.VecFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonLoader {

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

    public static Map<String, Vec> nactiVeciDoMapy(String cesta) throws IOException {
        List<Vec> veciList = nactiVeci(cesta);

        Map<String, Vec> veciMapa = new HashMap<>();

        for (Vec vec : veciList) {
            veciMapa.put(vec.getNazev(), vec);
        }
        return veciMapa;
    }

    public static List<Postava> nactiPostavy(String cesta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(cesta), new TypeReference<List<Postava>>() {});
    }

    public static List<ProstorDTO> nactiProstoryDTO(String cesta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(cesta), new TypeReference<List<ProstorDTO>>() {});
    }
}
