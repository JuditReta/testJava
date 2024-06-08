package com.api.test.pokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationI {
    @JsonProperty("red-blue")
    private RedBlue red_blue;
    private RedBlue yellow;
}
