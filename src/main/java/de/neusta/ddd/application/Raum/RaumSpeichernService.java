package de.neusta.ddd.application.Raum;

import de.neusta.ddd.domain.raum.RaumRepository;
import de.neusta.ddd.domain.raum.Raum;
import de.neusta.ddd.domain.raum.RaumDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RaumSpeichernService {

    @Resource
    private RaumRepository raumRepository;

    public Raum speichere(RaumDto raumDto) {
        final Raum raum = mapToRaum(raumDto);
        raumRepository.speichere(raum);
        return raum;
    }

    public Raum speichere(Raum raum) {
        raumRepository.speichere(raum);
        return raum;
    }

    private Raum mapToRaum(RaumDto raumDto) {
        return new Raum(raumDto.getNummer(), raumDto.getName());
    }
}
