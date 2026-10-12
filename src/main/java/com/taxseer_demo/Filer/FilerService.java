package com.taxseer_demo.Filer;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FilerService {

    private final FilerRepository filerRepository;

    public FilerService(FilerRepository filerRepository) {
        this.filerRepository = filerRepository;
    }

    // Save single record
    public Mono<Filers> saveFile(Filers filer) {
        return filerRepository.save(filer);
    }

    // Save multiple records
    public Flux<Filers> saveFiles(Flux<Filers> filers) {
        return filerRepository.saveAll(filers);
    }

    public Flux<Filers> getAllFiler() {
        return filerRepository.findAll();
    }

    public Mono<Filers> editFilers(Filers filer) {
        return filerRepository.save(filer);
    }
}