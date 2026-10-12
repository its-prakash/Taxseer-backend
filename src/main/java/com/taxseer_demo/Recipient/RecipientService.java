package com.taxseer_demo.Recipient;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RecipientService {

    private RecipientRespository recipientRespository;

    public RecipientService(RecipientRespository recipientRespository) {
        this.recipientRespository = recipientRespository;
    }

    public Mono<Recipients> cretaeRecipient(Recipients recipients ){
       return recipientRespository.save(recipients);
    }

    public Flux<Recipients> getAllRecipients(){
        return recipientRespository.findAll();
    }

    public Mono<Recipients> updateRecipient(Recipients recipients){
        return recipientRespository.save(recipients);
    }

    public Mono<Void> deleteRecipients(Long id){
        return recipientRespository.deleteById(id);
    }
}
