package com.api.test.pokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationVii {
    private DreamWorld icons;
    @JsonProperty("ultra-sun-ultra-moon")
    private Home ultraSunUltraMoon;
}
