package de.neusta.ddd.application.Person;

import de.neusta.ddd.domain.Person.PersonRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PersonBenutzerNameEindeutigService {

    @Resource
    PersonRepository personRepository;

    public boolean istBenutzerNameEindeutig(String benutzerName) {
        return personRepository.ladeAllePersonen().values()
                .stream()
                .noneMatch(person -> person.getBenutzerName().toString().equals(benutzerName));
    }
}
