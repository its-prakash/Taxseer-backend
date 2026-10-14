package com.taxseer_demo.Filer;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.processing.Filer;

@RestController
@RequestMapping("/api/filer")
@CrossOrigin(
        origins = {"http://localhost:4200", "http://localhost:54288/,"},
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class FilerController {

    private final FilerService filerService;

    public FilerController(FilerService filerService) {
        this.filerService = filerService;
    }

    // Single item creation (Sends 1 JSON object {})
    @PostMapping
    public Mono<Filers> createFiler(@RequestBody Filers filer) {
        return filerService.saveFile(filer);
    }

    // Bulk creation (Sends JSON array [{}, {}])
    @PostMapping("/bulk")
    public Flux<Filers> createFilers(@RequestBody Flux<Filers> filers) {
        return filerService.saveFiles(filers);
    }

    @GetMapping
    public Flux<Filers> getFiler() {
        return filerService.getAllFiler();
    }

    @PutMapping("/{id}")
    public Mono<Filers> editFiler(@PathVariable Long id, @RequestBody Filers filer) {
        filer.setId(id);
        return filerService.editFilers(filer);
    }

    @GetMapping("/{id}")
    public Mono<Filers> getFilerById(@PathVariable("id") Long id) {
        return filerService.getFilerByID(id);
    }
}