package com.taxseer_demo.Recipient;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/recipients")
@CrossOrigin(
        origins = { "http://localhost:4200", "http://localhost:54288" },
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class RecipientController {

    private final RecipientService recipientService;

    public RecipientController(RecipientService recipientService) {
        this.recipientService = recipientService;
    }

    // FIX: Changed from @GetMapping to @PostMapping for creation
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Recipients> createRecipient(@RequestBody Recipients recipients) {
        return recipientService.cretaeRecipient(recipients);
    }

    @GetMapping
    public Flux<Recipients> getAllRecipients() {
        return recipientService.getAllRecipients();
    }

    // FIX: Changed from @PostMapping to @GetMapping("/filter") to match Angular's GET call
    @GetMapping("/filter")
    public Flux<Recipients> getByFiler(@RequestParam("filer") String filerName) {
        return recipientService.findByFiler(filerName);
    }

    @PutMapping("/{id}")
    public Mono<Recipients> updateRecipient(
            @PathVariable Long id,
            @RequestBody Recipients recipients) {
        recipients.setId(id);
        return recipientService.updateRecipient(recipients);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteRecipient(@PathVariable Long id) {
        return recipientService.deleteRecipients(id);
    }
}