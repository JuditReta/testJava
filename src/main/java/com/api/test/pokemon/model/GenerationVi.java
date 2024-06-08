package com.api.test.pokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationVi {
    @JsonProperty("omegaruby-alphasapphire")
    private Home omegarubyAlphasapphire;
    @JsonProperty("x-y")
    private Home xy;
}
