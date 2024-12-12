package de.neusta.ddd.application.Person;

import de.neusta.ddd.domain.Person.Person;
import de.neusta.ddd.domain.Person.PersonDto;
import de.neusta.ddd.domain.Person.PersonRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PersonSpeichernService {

    @Resource
    PersonRepository personRepository;
    @Resource
    PersonBenutzerNameEindeutigService personBenutzerNameEindeutigService;

    public Person speichere(PersonDto personDto) {
        final Person person = mapToPerson(personDto);
        final boolean istBenutzerNameEindeutig = personBenutzerNameEindeutigService.istBenutzerNameEindeutig(person.getBenutzerName().getBenutzerName());
        if (!istBenutzerNameEindeutig){
            throw new IllegalArgumentException("Benutzername ist nicht eindeutig");
        }
        personRepository.speichere(person);
        return person;
    }

    private Person mapToPerson(PersonDto personDto) {
        return new Person(personDto.getBenutzerName(), personDto.getVorname(), personDto.getNachname(), personDto.getNamensZusatz());
    }
}
