package de.neusta.ddd.domain.Raum;

import de.neusta.ddd.domain.Person.Person;

public class PersonWurdeRaumZugeordnetEvent{
    private final Person person;
    private final Raum raum;

    public PersonWurdeRaumZugeordnetEvent(Person person, Raum raum) {
        this.person = person;
        this.raum = raum;
    }

    public Person getPerson() {
        return person;
    }

    public Raum getRaum() {
        return raum;
    }
}
