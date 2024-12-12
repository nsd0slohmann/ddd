package de.neusta.ddd.domain.Person;

import java.util.Map;

public interface PersonRepository {

    void speichere(Person person);

    Person lade(String id);

    Map<String, Person> ladeAllePersonen();
}
