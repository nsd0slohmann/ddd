package de.neusta.ddd.application.Raum;

import de.neusta.ddd.application.Person.PersonSpeichernService;
import de.neusta.ddd.domain.Person.Person;
import de.neusta.ddd.domain.Person.PersonDto;
import de.neusta.ddd.domain.raum.Raum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class RaumPersonenHinzufuegeService {

    @Resource
    RaumLadenService raumLadenService;
    @Resource
    RaumSpeichernService raumSpeichernService;
    @Resource
    PersonSpeichernService personSpeichernService;

    public Raum fuegePersonZuRaumHinzu(PersonDto personDto, String raumId) {
        final Raum raum = raumLadenService.lade(raumId);
        final Person person = personSpeichernService.speichere(personDto);
        raum.setPersonen(person);
        raumSpeichernService.speichere(raum);
        return raum;
    }

}
