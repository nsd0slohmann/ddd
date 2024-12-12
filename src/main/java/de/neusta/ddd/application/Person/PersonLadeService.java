package de.neusta.ddd.application.Person;

import de.neusta.ddd.domain.Person.Person;
import de.neusta.ddd.domain.Person.PersonDto;
import de.neusta.ddd.domain.Person.PersonRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonLadeService {

    @Resource
    private PersonRepository personRepository;

    public Person lade(String id) {
        return personRepository.lade(id);
    }

    public PersonDto ladePersonDto(String id) {
        final Person person = personRepository.lade(id);
        return mapToPersonDto(person);
    }

    private PersonDto mapToPersonDto(Person person) {
        return new PersonDto(person.getNachname().getNachname(), person.getVorname().getVorname(), person.getBenutzerName().getBenutzerName(), Optional.ofNullable(person.getNamensZusatz()).map(Person.NamensZusatz::name).orElse(""), person.getKurzName());
    }
}
