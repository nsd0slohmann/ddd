package de.neusta.ddd.domain.raum;

import org.apache.commons.lang3.math.NumberUtils;

import javax.naming.Name;
import java.util.UUID;

public class Raum {
    private final Id nummer;
    private Nummer raumNummer;
    private Name name;

    Raum() {
        this.nummer = new Id();
    }

    public Id getId() {
        return nummer;
    }

    public Nummer getRaumNummer() {
        return this.raumNummer;
    }

    public Name getName() {
        return this.name;
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

        private Nummer() {}

        public Nummer(String nummer) {
            if(NumberUtils.isParsable(nummer)) {
                if(nummer.length() == 4) {
                    this.nummer = nummer;
                } else {
                    throw new NumberFormatException();
                }
            }
            else {
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
