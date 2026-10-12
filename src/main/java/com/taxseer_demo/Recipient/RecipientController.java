package com.taxseer_demo.Recipient;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/recipients")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class RecipientController {

    private RecipientService recipientService;

    public RecipientController(RecipientService recipientService) {
        this.recipientService = recipientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Recipients> createRecipient(@RequestBody Recipients recipients) {
        return recipientService.cretaeRecipient(recipients);
    }

    @GetMapping
    public Flux<Recipients> getAllRecipients() {
        return recipientService.getAllRecipients();
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
