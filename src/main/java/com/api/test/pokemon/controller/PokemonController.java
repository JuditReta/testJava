package com.api.test.pokemon.controller;

import com.api.test.catalogo.service.ItemService;
import com.api.test.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getPokemongetPokemon(@PathVariable String name){
        return ResponseEntity.ok(pokemonService.getPokemon(name));

    }
}
