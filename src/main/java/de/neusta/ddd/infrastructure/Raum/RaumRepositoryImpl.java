package de.neusta.ddd.infrastructure.Raum;

import de.neusta.ddd.domain.Raum.RaumRepository;
import de.neusta.ddd.domain.Raum.Raum;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RaumRepositoryImpl implements RaumRepository {

    private final Map<String, Raum> raumMap;

    public RaumRepositoryImpl() {
        this.raumMap = new HashMap<>();
    }

    @Override
    public void speichere(Raum raum) {
        raumMap.put(raum.getRaumNummer().getNummer(), raum);
    }

    @Override
    public Raum lade(String id) {
        return raumMap.get(id);
    }

    @Override
    public Map<String, Raum> getRaumMap() {
        return raumMap;
    }
}
