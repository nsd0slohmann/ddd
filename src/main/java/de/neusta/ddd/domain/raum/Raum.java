package de.neusta.ddd.domain.raum;

import de.neusta.ddd.domain.Person.Person;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Raum {
    private Id id;
    private Nummer raumNummer;
    private Name name;
    private List<Person.Id> personen;

    private Raum() {
    }

    public Raum(String id, String name) {
        this.id = new Id();
        this.raumNummer = new Nummer(id);
        this.name = new Name(name);
        this.personen = new ArrayList<>();

    }

    public Id getId() {
        return id;
    }

    public Nummer getRaumNummer() {
        return this.raumNummer;
    }

    public Name getName() {
        return this.name;
    }

    public List<Person.Id> getPersonen() {
        return this.personen;
    }

    public void setPersonen(Person person) {
        this.personen.add(person.getId());
    }

    public static class Id {
        private final UUID uuid;

        Id() {
            this.uuid = UUID.randomUUID();
        }

        public UUID getUuid() {
            return uuid;
        }
    }

    public static class Nummer {
        private String nummer;

        private Nummer() {
        }

        public Nummer(String nummer) {
            if (NumberUtils.isParsable(nummer)) {
                if (nummer.length() == 4) {
                    this.nummer = nummer;
                } else {
                    throw new NumberFormatException();
                }
            } else {
                throw new NumberFormatException();
            }
        }

        public String getNummer() {
            return nummer;
        }
    }

    public static class Name {
        private String name;

        private Name() {

        }

        public Name(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

}
