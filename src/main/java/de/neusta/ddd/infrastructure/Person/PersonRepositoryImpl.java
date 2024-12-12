package de.neusta.ddd.infrastructure.Person;

import de.neusta.ddd.domain.Person.Person;
import de.neusta.ddd.domain.Person.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<String, Person> personMap;

    public PersonRepositoryImpl() {
        this.personMap = new HashMap<>();;
    }

    @Override
    public void speichere(Person person) {
        personMap.put(person.getId().getUuid().toString(), person);

    }

    @Override
    public Person lade(String id) {
        return personMap.get(id);
    }

    @Override
    public Map<String, Person> ladeAllePersonen() {
        return personMap;
    }
}
