package de.neusta.ddd.infrastructure.Raum;

import de.neusta.ddd.application.Raum.RaumLadenService;
import de.neusta.ddd.application.Raum.RaumPersonenHinzufuegeService;
import de.neusta.ddd.application.Raum.RaumSpeichernService;
import de.neusta.ddd.domain.Person.PersonDto;
import de.neusta.ddd.domain.raum.Raum;
import de.neusta.ddd.domain.raum.RaumDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class RaumController {

    @Resource
    RaumSpeichernService raumSpeichernService;
    @Resource
    RaumLadenService raumLadenService;
    @Resource
    RaumPersonenHinzufuegeService raumPersonenHinzufuegeService;

    @GetMapping("/room/{ID}")
    @ResponseBody
    public RaumDto getRaum(@PathVariable("ID") String id) {
        return raumLadenService.ladeRaumDto(id);
    }

    @PostMapping("/room")
    @ResponseBody
    public Raum createRaum(@RequestBody RaumDto raum) {
        return raumSpeichernService.speichere(raum);
    }

    @PutMapping("/room/{ID}/person")
    @ResponseBody
    public Raum ordnePersonZuRaum(@RequestBody PersonDto personDto, @PathVariable("ID") String raumId) {
        return raumPersonenHinzufuegeService.fuegePersonZuRaumHinzu(personDto, raumId);
    }
}
