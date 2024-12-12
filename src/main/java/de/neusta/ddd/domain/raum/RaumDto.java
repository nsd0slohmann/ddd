package de.neusta.ddd.domain.raum;

import de.neusta.ddd.domain.Person.PersonDto;

import java.util.List;

public class RaumDto {
    private String nummer;
    private String name;
    private List<PersonDto> personen;

    public RaumDto() {
        // Default constructor
    }

    public RaumDto(String nummer, String name,  List<PersonDto> personen) {
        this.nummer = nummer;
        this.name = name;
        this.personen = personen;
    }

    public RaumDto(Raum raum, List<PersonDto> personen) {
        this.nummer = raum.getRaumNummer().getNummer();
        this.name = raum.getName().getName();
        this.personen = personen;
    }

    public String getNummer() {
        return nummer;
    }

    public String getName() {
        return name;
    }

    public List<PersonDto> getPersonen() {
        return personen;
    }
}
