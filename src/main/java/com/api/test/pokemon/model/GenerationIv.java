package com.api.test.pokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationIv {
    @JsonProperty("diamond-pearl")
    private DiamondPearl diamondPearl;
    @JsonProperty("heartgold-soulsilver")
    private DiamondPearl heartgoldSoulsilver;
    private Sprites platinum;
}
