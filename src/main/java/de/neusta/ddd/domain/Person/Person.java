package de.neusta.ddd.domain.Person;

import org.apache.logging.log4j.util.Strings;

import java.util.Optional;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.defaultString;

public class Person {
    private Id id;
    private Nachname nachname;
    private Vorname vorname;
    private BenutzerName benutzerName;
    private NamensZusatz namensZusatz;

    private Person() {
    }

    public Person(String vorname, String nachname, String benutzerName, String namensZusatz) {
        this.id = new Id();
        this.benutzerName = new BenutzerName(benutzerName);
        this.vorname = new Vorname(vorname);
        this.nachname = new Nachname(nachname);
        this.namensZusatz = Strings.isNotBlank(namensZusatz) ? NamensZusatz.valueOf(namensZusatz) : null;
    }

    public Id getId() {
        return id;
    }

    public Vorname getVorname() {
        return this.vorname;
    }

    public Nachname getNachname() {
        return this.nachname;
    }

    public BenutzerName getBenutzerName() {
        return this.benutzerName;
    }

    public NamensZusatz getNamensZusatz() {
        return namensZusatz;
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

    public static class Nachname {
        private String nachname;

        public Nachname(String nachname) {
            this.nachname = nachname;
        }

        public String getNachname() {
            return this.nachname;
        }
    }

    public static class Vorname {
        private String vorname;

        public Vorname(String vorname) {
            this.vorname = vorname;
        }

        public String getVorname() {
            return this.vorname;
        }
    }

    public static class BenutzerName {
        private String benutzerName;

        public BenutzerName(String benutzerName) {
            this.benutzerName = benutzerName;
        }

        public String getBenutzerName() {
            return this.benutzerName;
        }
    }

    public enum NamensZusatz {
        von,
        van,
        de;
    }

    public String getKurzName() {
        return this.vorname.getVorname() + defaultString(Optional.ofNullable(namensZusatz).map(NamensZusatz::name).orElse("")) + this.nachname.getNachname() + this.benutzerName.getBenutzerName();
    }

}
