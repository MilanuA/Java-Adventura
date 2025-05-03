package cz.vse.adventura.json;
import java.util.List;

public record ProstorDTO(
        String nazev,
        String popis,
        List<String> vychody,
        List<String> veci,
        List<String> postavy
) {}
