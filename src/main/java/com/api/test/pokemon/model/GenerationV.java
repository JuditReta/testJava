package com.api.test.pokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationV {
    @JsonProperty("black-white")
    private BlackWhite blackWhite;
}
