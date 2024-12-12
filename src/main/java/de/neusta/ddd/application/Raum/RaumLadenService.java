package de.neusta.ddd.application.Raum;

import de.neusta.ddd.application.Person.PersonLadeService;
import de.neusta.ddd.domain.Person.Person;
import de.neusta.ddd.domain.Person.PersonDto;
import de.neusta.ddd.domain.Raum.RaumDto;
import de.neusta.ddd.domain.Raum.RaumRepository;
import de.neusta.ddd.domain.Raum.Raum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RaumLadenService {

    @Resource
    private RaumRepository raumRepository;
    @Resource
    private PersonLadeService personLadeService;

    public Raum lade(String id) {
        return raumRepository.lade(id);
    }

    public RaumDto ladeRaumDto(String id) {
        final Raum raum = raumRepository.lade(id);
        return mapToRaumDto(raum);
    }

    private RaumDto mapToRaumDto(Raum raum) {
        final List<PersonDto> personen = raum.getPersonen().stream().map(Person.Id::getUuid).map(UUID::toString).map(personLadeService::ladePersonDto).toList();
        return new RaumDto(raum, personen);
    }
}
