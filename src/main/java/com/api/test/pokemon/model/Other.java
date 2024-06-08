package com.api.test.pokemon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
public class Other {
    @JsonProperty("dream_world")
    private DreamWorld dreamWorld;
    private Home home;

    @JsonProperty("official-artwork")
    private OfficialArtwork officialArtwork;
    private Sprites showdown;
}
