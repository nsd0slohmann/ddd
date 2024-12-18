package de.neusta.ddd.domain.Raum;

import java.util.Map;

public interface RaumRepository {

    void speichere(Raum raum);

    Raum lade(String id);

    Map<String, Raum> getRaumMap();
}
