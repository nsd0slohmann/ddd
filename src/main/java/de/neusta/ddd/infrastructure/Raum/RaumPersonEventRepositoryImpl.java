package de.neusta.ddd.infrastructure.Raum;

import de.neusta.ddd.domain.Raum.PersonWurdeRaumZugeordnetEvent;
import de.neusta.ddd.domain.Raum.RaumPersonEventRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RaumPersonEventRepositoryImpl implements RaumPersonEventRepository {

    private final List<PersonWurdeRaumZugeordnetEvent> events;

    public RaumPersonEventRepositoryImpl() {
        this.events = new ArrayList<>();
    }

    @Override
    public void schmeisse(PersonWurdeRaumZugeordnetEvent event) {
        events.add(event);
    }
}
