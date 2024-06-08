package com.api.test.pokemon.service;

import com.api.test.pokemon.model.Pokemon;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PokemonService {
    @Value("${pokemon.api.base-url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public Object getPokemon(String name) {
        try {
            HttpHeaders headers = new HttpHeaders();
            String completeUrl = url.concat(name.toLowerCase());

            return restTemplate.getForObject(completeUrl, Pokemon.class);
            //ResponseEntity<String> response = restTemplate.exchange(completeUrl, HttpMethod.GET,new HttpEntity<>(headers),String.class);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
