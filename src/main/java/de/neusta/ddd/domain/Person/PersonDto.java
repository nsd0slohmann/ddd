package de.neusta.ddd.domain.Person;

public class PersonDto {
    private String nachname;
    private String vorname;
    private String benutzerName;
    private String namensZusatz;
    private String kurzName;

    public PersonDto() {
        // Default constructor
    }

    public PersonDto(String nachname, String vorname, String benutzerName, String namensZusatz, String kurzName) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.benutzerName = benutzerName;
        this.namensZusatz = namensZusatz;
        this.kurzName =  kurzName;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getBenutzerName() {
        return benutzerName;
    }

    public void setBenutzerName(String benutzerName) {
        this.benutzerName = benutzerName;
    }

    public String getNamensZusatz() {
        return namensZusatz;
    }

    public void setNamensZusatz(String namensZusatz) {
        this.namensZusatz = namensZusatz;
    }

    public String getKurzName() {
        return kurzName;
    }
}
